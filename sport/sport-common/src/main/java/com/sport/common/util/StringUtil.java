package com.sport.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static String dateToStringTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time; 
	}
	
	public static String dateToStringDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		return time; 
	}
}
