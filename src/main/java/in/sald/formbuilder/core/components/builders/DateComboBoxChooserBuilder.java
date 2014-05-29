package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.components.custom.DateComboBoxChooser;
import in.sald.formbuilder.core.parameters.DateComboBoxChooserParametersHelper;

public class DateComboBoxChooserBuilder extends CommonPartBuilder
{
	private static DateComboBoxChooser dateChooser;

	public DateComboBoxChooserBuilder(DateComboBoxChooserParametersHelper helper)
	{
		super(helper, dateChooser = new DateComboBoxChooser());

		dateChooser.setCurrentDay(helper.isSetCurrentDate());

		if(helper.getDate() != null)
		{
			dateChooser.setDate(helper.getDate());
		}
	}

	@Override
	public DateComboBoxChooser getElement()
	{
		return dateChooser;
	}
}
