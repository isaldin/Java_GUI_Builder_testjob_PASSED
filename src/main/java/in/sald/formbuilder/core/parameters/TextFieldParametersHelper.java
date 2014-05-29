package in.sald.formbuilder.core.parameters;

import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParameterHelper;

import java.util.HashMap;

public class TextFieldParametersHelper extends ParameterHelper implements ITextFieldParametersHelper
{
	public TextFieldParametersHelper(HashMap params)
	{
		super(params);
	}

	@Override
	public int getColumns()
	{
		return getIntegerValue(Parameter.TEXTFIELD_COLUMNS);
	}
}
