package com.bbs.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class test {
	
	public static void main(String[] args) {
		test as = new test();
		try {
			System.out.println(as.time());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String time() throws ParseException{
		
		Date now= new Date();
		
		String time= DateHelper.fromDateToString(now);
		
		Calendar  c=Calendar.getInstance();
		
		Integer year = c.get(Calendar.YEAR);
		Integer month = c.get(Calendar.MONTH);
		Integer date = c.get(Calendar.DATE);
		Integer hour = c.get(Calendar.HOUR_OF_DAY);
		Integer minute = c.get(Calendar.MINUTE);
		Integer second=c.get(Calendar.SECOND);
		
		System.out.println(year+"-"+(month+1)+"-"+date+" "+hour+":"+minute+":"+second);
		return time;
		
		
	}
}
