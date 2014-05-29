package in.sald.formbuilder.core.components.builders;

import in.sald.formbuilder.core.parameters.utils.ParameterHelper;
import javax.swing.*;

public abstract class CommonPartBuilder implements ICommonPartBuilder
{
	public CommonPartBuilder(ParameterHelper helper, JComponent component)
	{
		if(helper.getWidth() > -1 && helper.getHeight() > -1)
		{
			component.setSize(helper.getWidth(), helper.getHeight());
		}
	}

	public abstract JComponent getElement();
}
