package com.using;

import in.sald.formbuilder.core.FormBuilder;
import in.sald.formbuilder.core.components.custom.DateComboBoxChooser;
import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParametersMap;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MyFormBuilder extends FormBuilder
{
	public MyFormBuilder(HashMap parameters)
	{
		super(parameters);

		//добавление JCheckBox с лэйблом "Simple checkbox" c состоянием "On"
		addCheckBox(
				"cbx",
				new ParametersMap()
						.add(Parameter.WIDTH, 77)
						.add(Parameter.HEIGHT, 77)
						.add(Parameter.TEXT, "Simple checkbox")
						.add(Parameter.CHECKBOX_DEFAULT_SELECTION_STATUS, true)
						.map());

		//добавление кнопки с текстом "Add"
		addButton(
				"btnAdd",
				new ParametersMap()
						.add(Parameter.TEXT, "Add")
						.map());

		//добавление JTextArea со следующими параметрами: 7 строк, 25 колонок, текст "Hi!"
		addTextArea(
				"testTA",
				new ParametersMap()
						.add(Parameter.TEXTAREA_ROWS, 7)
						.add(Parameter.TEXTAREA_COLUMNS, 25)
						.add(Parameter.TEXT, "Hi!")
						.map());

		//добавление JTextField c шириной в 24 колонки и текстом "Hi!"
		addTextEdit(
				"textEdit",
				new ParametersMap()
						.add(Parameter.TEXTFIELD_COLUMNS, 24)
						.add(Parameter.TEXT, "Hi!")
						.map()
		);

		//добавление кастомного компонента DateComboBoxChooser с установкой текущей даты для отображения
		addDateComboBoxChooser(
				"dateChooser",
				new ParametersMap()
						.add(Parameter.DATE_CB_CHOOSER_SET_CURRENT_DATE, true)
						.map()
		);

		//добавление кастомного компонента DateComboBoxChooser с установкой произвольной даты для отображения
		addDateComboBoxChooser(
				"dateChooser2",
				new ParametersMap()
						.add(Parameter.DATE_CB_CHOOSER_DATE, new DateTime(1987, 3, 11, 0, 0).toDate())
						.map()
		);
	}

	//в данном методе "вешаются" листенеры для компонентов
	@Override
	protected void initListeners()
	{
		final JButton btn = getComponentById("btnAdd");
		final JCheckBox checkBox = getComponentById("cbx");
		final DateComboBoxChooser dateChooser = getComponentById("dateChooser");

		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				JOptionPane.showMessageDialog(form, dateChooser.getDate());
			}
		});

		checkBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				btn.setText(((JCheckBox)actionEvent.getSource()).isSelected() ? "Hi!" : "Bye!");
			}
		});
	}
}
