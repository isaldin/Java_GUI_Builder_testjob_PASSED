package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.parameters.CheckBoxParametersHelper;

import javax.swing.*;

public class CheckBoxBuilder extends CommonPartBuilder
{
	private static JCheckBox element;

	public CheckBoxBuilder(CheckBoxParametersHelper helper)
	{
		super(helper, element = new JCheckBox());

		element.setSelected(helper.getDefaultSelectionStatus());
		element.setText(helper.getText());
	}

	@Override
	public JCheckBox getElement()
	{
		return element;
	}
}
