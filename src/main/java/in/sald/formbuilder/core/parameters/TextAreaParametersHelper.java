package in.sald.formbuilder.core.parameters;

import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParameterHelper;

import java.util.HashMap;

public class TextAreaParametersHelper extends ParameterHelper implements ITextAreaParametersHelper
{
    public TextAreaParametersHelper(HashMap map)
    {
        super(map);
    }

    @Override
    public int getRows()
    {
        return getIntegerValue(Parameter.TEXTAREA_ROWS);
    }

    @Override
    public int getColumns()
    {
        return getIntegerValue(Parameter.TEXTAREA_COLUMNS);
    }
}
