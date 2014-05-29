package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.parameters.TextFieldParametersHelper;

import javax.swing.*;

public class TextFieldBuilder extends CommonPartBuilder
{
	private static JTextField element;

	public TextFieldBuilder(TextFieldParametersHelper helper)
	{
		super(helper, element = new JTextField());

		element.setText(helper.getText());
		element.setColumns(helper.getColumns());
	}

	@Override
	public JTextField getElement()
	{
		return element;
	}
}
