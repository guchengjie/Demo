package com.bbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:SS";
	
	public static Date fromStringToDate(String time) throws ParseException{
		
		SimpleDateFormat fmt = new SimpleDateFormat(TIME_PATTERN);
		
		return fmt.parse(time);
	}
	
	public static String fromDateToString(Date time) throws ParseException{
		
		SimpleDateFormat fmt = new SimpleDateFormat(TIME_PATTERN);
		
		return fmt.format(time);
		
	}
}
