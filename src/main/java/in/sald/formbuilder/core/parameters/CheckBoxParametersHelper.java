package in.sald.formbuilder.core.parameters;

import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParameterHelper;

import java.util.HashMap;

public class CheckBoxParametersHelper extends ParameterHelper implements ICheckBoxParametersHelper
{
	public CheckBoxParametersHelper(HashMap map)
	{
		super(map);
	}

	@Override
	public boolean getDefaultSelectionStatus()
	{
		Object defSelectionStatus = map.get(Parameter.CHECKBOX_DEFAULT_SELECTION_STATUS);

		return defSelectionStatus != null && Boolean.valueOf(defSelectionStatus.toString());
	}
}
