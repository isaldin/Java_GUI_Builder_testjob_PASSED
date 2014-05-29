package in.sald.formbuilder.core.components.custom;

import net.miginfocom.swing.MigLayout;
import org.joda.time.DateTime;

import javax.swing.*;
import java.sql.Date;

//кастомный комплексный компонент для выбора даты, построенный на выпадающих списках
public class DateComboBoxChooser extends JComponent
{
	private static String[] monthArray = new String[]{
			"Jan",
			"Feb",
			"Mar",
			"Apr",
			"May",
			"Jun",
			"Jul",
			"Aug",
			"Sep",
			"Oct",
			"Nov",
			"Dec"
	};

	private JLabel
			lblDay = new JLabel("Day"),
			lblMonth = new JLabel("Month"),
			lblYear = new JLabel("Year");

	private JComboBox
			cbDay = new JComboBox(),
			cbMonth = new JComboBox(),
			cbYear = new JComboBox();

	public DateComboBoxChooser()
	{
		init();

		setLayout(new MigLayout());

		add(lblDay);
		add(lblMonth);
		add(lblYear, "wrap");

		add(cbDay);
		add(cbMonth);
		add(cbYear);
	}

	//инициализация списков отображения
	private void init()
	{
		for(int i = 1; i <= 31; i++)
		{
			cbDay.addItem(i);
		}

		for(String item : monthArray)
		{
			cbMonth.addItem(item);
		}

		for(int i = 1900; i <= new DateTime().getYear(); i++)
		{
			cbYear.addItem(i);
		}
	}

	//установка текущей даты в комбобоксы
	public void setCurrentDay(boolean isSetCurrentDay)
	{
		setDate(isSetCurrentDay ? new Date(System.currentTimeMillis()) : null);
	}
	
	public void setDate(java.util.Date date)
	{
		setDate(new Date(date.getTime()));
	}

	//установка произвольной даты в комбобоксы
	public void setDate(Date date)
	{
		if(date == null)
			return;

		DateTime dateTime = new DateTime(date);

		setDay(dateTime.getDayOfMonth());
		setMonth(dateTime.getMonthOfYear());
		setYear(dateTime.getYear());
	}
	
	//return selected date
	public Date getDate()
	{
		int day = (Integer)cbDay.getSelectedItem();
		int monthIndex = cbMonth.getSelectedIndex();
		int year = (Integer)cbYear.getSelectedItem();

		DateTime dateTime = new DateTime(year, monthIndex+1, day, 0, 0);

		return new Date(dateTime.toDate().getTime());
	}

	public void setYear(int year)
	{
		cbYear.setSelectedItem(year);
	}

	public void setMonth(int month)
	{
		cbMonth.setSelectedIndex(month-1);
	}

	public void setDay(int day)
	{
		cbDay.setSelectedItem(day);
	}
}
