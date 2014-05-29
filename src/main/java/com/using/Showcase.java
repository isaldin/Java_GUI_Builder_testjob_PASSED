package com.using;

import in.sald.formbuilder.core.parameters.utils.Parameter;
import in.sald.formbuilder.core.parameters.utils.ParametersMap;

public class Showcase
{
	public static void main(String[] args)
	{
		MyFormBuilder myFormBuilder = new MyFormBuilder(
				new ParametersMap()
						.add(Parameter.WIDTH, 400)
						.add(Parameter.HEIGHT, 500)
						.map());

		myFormBuilder.showForm();
	}

}
