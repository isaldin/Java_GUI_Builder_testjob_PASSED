package in.sald.formbuilder.core.parameters.utils;

//enum, в который помещаются все параметры, доступные для компонентов
public enum Parameter
{
    //общие параметры
	TEXT,
    WIDTH,
    HEIGHT,

	//параметры для JTextArea
    TEXTAREA_ROWS,
    TEXTAREA_COLUMNS,

	//параметры для JCheckBox
	CHECKBOX_DEFAULT_SELECTION_STATUS,

	//параметры для JTextField
	TEXTFIELD_COLUMNS,

	//параметры для кастомного компонента DateComboBoxChooser
	DATE_CB_CHOOSER_SET_CURRENT_DATE,
	DATE_CB_CHOOSER_DATE,
}
