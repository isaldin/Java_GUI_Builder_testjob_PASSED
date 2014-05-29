package in.sald.formbuilder.core.parameters.utils;

import java.util.HashMap;

//класс для хранения параметров при инициализации компонента в FormBuilder'е
public class ParametersMap
{
    private HashMap<Parameter, Object> map;

	public ParametersMap()
	{
		map = new HashMap<Parameter, Object>();
	}

	public ParametersMap add(Parameter key, Object value)
    {
        map.put(key, value);

        return this;
    }

    public HashMap<Parameter, Object> map()
    {
        return map;
    }
}
