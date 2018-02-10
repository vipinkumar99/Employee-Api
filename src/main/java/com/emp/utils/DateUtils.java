package com.emp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String FIRST_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	public static final String SECOND_DATE_FORMAT = "yyyy/mm/dd hh:mm:ss";

	public static String dateConversion(Date date, String dateFormat) {
		// SimpleDateFormat newDateFormat = new SimpleDateFormat(dateFormat);
		// String createDate = newDateFormat.format(date);
		// return createDate;
		return new SimpleDateFormat(dateFormat).format(date);
	}

}