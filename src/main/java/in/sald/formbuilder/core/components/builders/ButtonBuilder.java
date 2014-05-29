package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.parameters.ButtonParametersHelper;

import javax.swing.*;

//создание инстанса компонента, установка параметров
public class ButtonBuilder extends CommonPartBuilder
{
	private static JButton element;

	public ButtonBuilder(ButtonParametersHelper helper)
	{
		super(helper, element = new JButton());
		element.setText(helper.getText());
	}

	@Override
	public JButton getElement()
	{
		return element;
	}
}
