package in.sald.formbuilder.core;

import in.sald.formbuilder.core.components.builders.*;
import in.sald.formbuilder.core.parameters.*;
import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParameterHelper;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

//класс для инициализации и отображения формы
public abstract class FormBuilder implements IFormBuilder
{
	//список компонентов
    protected SortedMap<String, JComponent> components = new TreeMap<String, JComponent>();

	protected JFrame form = new JFrame();

    //инициализация параметров для формы
	public FormBuilder(HashMap parameters)
    {
        ParameterHelper helper = new ParameterHelper(parameters);
        form.setSize(helper.getWidth(), helper.getHeight());
    }

	//обязательный метод, определяемый пользователем, вызывается перед отображением формы
    protected abstract void initListeners();

    //добавление компонента в список компонентов для дальнейшего отображения на форме
	private void addComponent(String id, JComponent component)
    {
        components.put(id, component);
    }

	//метод для добавления компонентов на форму
    private void createForm()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        for(String element: components.keySet())
        {
			panel.add(components.get(element), "wrap");
        }

        Container container = form.getContentPane();
		container.setLayout(new MigLayout());
        container.add(panel);
    }

	//отображение формы
    public void showForm()
    {
        createForm();
        initListeners();

        form.setVisible(true);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	//метод для добавления компонента с определенными программистом параметрами
    protected void addButton(String id, HashMap<Parameter, Object> params)
    {
		ButtonBuilder builder = new ButtonBuilder(new ButtonParametersHelper(params));

        addComponent(id, builder.getElement());
    }

	//метод для добавления компонента с определенными программистом параметрами
    protected void addTextArea(String id, HashMap<Parameter, Object> params)
    {
		TextAreaBuilder builder = new TextAreaBuilder(new TextAreaParametersHelper(params));

		addComponent(id, builder.getElement());
    }

	//метод для добавления компонента с определенными программистом параметрами
    protected void addTextEdit(String id, HashMap<Parameter, Object> params)
    {
		TextFieldBuilder builder = new TextFieldBuilder(new TextFieldParametersHelper(params));

        addComponent(id, builder.getElement());
    }

	//метод для добавления компонента с определенными программистом параметрами
    protected void addCheckBox(String id, HashMap<Parameter, Object> params)
    {
		CheckBoxBuilder builder = new CheckBoxBuilder(new CheckBoxParametersHelper(params));

        addComponent(id, builder.getElement());
    }

	//метод для добавления компонента с определенными программистом параметрами
	protected void addDateComboBoxChooser(String id, HashMap<Parameter, Object> params)
	{
		DateComboBoxChooserBuilder builder = new DateComboBoxChooserBuilder(new DateComboBoxChooserParametersHelper(params));

		addComponent(id, builder.getElement());
	}

	//метод, возвращающий по id элемента сам элемент из списка 'components'
    protected <T extends JComponent> T getComponentById(String id)
    {
        return (T)components.get(id);
    }
}
