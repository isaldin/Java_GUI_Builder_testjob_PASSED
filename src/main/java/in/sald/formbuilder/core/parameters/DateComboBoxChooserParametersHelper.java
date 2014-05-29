package in.sald.formbuilder.core.parameters;

import com.sun.tools.javac.resources.javac;
import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParameterHelper;

import java.sql.Date;
import java.util.HashMap;

public class DateComboBoxChooserParametersHelper extends ParameterHelper implements IDateComboBoxChooserParametersHelper
{
	public DateComboBoxChooserParametersHelper(HashMap map)
	{
		super(map);
	}

	@Override
	public boolean isSetCurrentDate()
	{
		Object isSet = map.get(Parameter.DATE_CB_CHOOSER_SET_CURRENT_DATE);

		return isSet != null && Boolean.valueOf(isSet.toString());
	}

	@Override
	public Date getDate()
	{
		Object date = map.get(Parameter.DATE_CB_CHOOSER_DATE);

		if(date instanceof java.util.Date)
		{
			date = new java.sql.Date(((java.util.Date) date).getTime());
		}

		return date != null ? (java.sql.Date)date : null;
	}
}
