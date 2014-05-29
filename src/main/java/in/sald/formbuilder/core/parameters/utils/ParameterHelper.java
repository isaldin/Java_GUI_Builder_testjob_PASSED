package in.sald.formbuilder.core.parameters.utils;

import org.apache.log4j.Logger;

import java.util.HashMap;

//класc, для доступа к определенным программистом параметрам через getter'ы
public class ParameterHelper
{
    private static Logger log = Logger.getLogger(ParameterHelper.class);
    protected HashMap map = new HashMap();
    private static String DEFAULT_TEXT = "Please define label";

    public ParameterHelper(HashMap map)
    {
        this.map = map;
    }

    public int getWidth()
    {
        return getIntegerValue(Parameter.WIDTH);
    }
    
    public int getHeight()
    {
        return getIntegerValue(Parameter.HEIGHT);
    }
    
    public String getText()
    {
        Object label = map.get(Parameter.TEXT);
        
        return label != null && !label.equals("") ? label.toString() : DEFAULT_TEXT;
    }
    
    protected int getIntegerValue(Parameter parameter)
    {
        Object result = map.get(parameter);
        int height = -1;

        if(result != null && !result.equals(""))
        {
            try
            {
                height = Integer.valueOf(result.toString());
            }
            catch(NumberFormatException e)
            {
                log.error("Parse integer error.", e);
            }
        }

        return height;
    }
}
