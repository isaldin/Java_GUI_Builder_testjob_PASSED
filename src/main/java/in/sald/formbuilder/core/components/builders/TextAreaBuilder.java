package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.parameters.TextAreaParametersHelper;

import javax.swing.*;

public class TextAreaBuilder extends CommonPartBuilder
{
	private static JTextArea textArea;
	
	public TextAreaBuilder(TextAreaParametersHelper helper)
	{
		super(helper, textArea = new JTextArea());

		textArea.setRows(helper.getRows());
		textArea.setColumns(helper.getColumns());
		textArea.setText(helper.getText());
	}

	@Override
	public JTextArea getElement()
	{
		return textArea;
	}
}
