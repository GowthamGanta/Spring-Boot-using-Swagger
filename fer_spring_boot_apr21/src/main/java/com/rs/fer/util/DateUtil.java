package com.rs.fer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getCurrentDate() {
		return getCurrentDate("dd/MM/yyyy");
	}

	public static String getCurrentDateAndTime() {
		return getCurrentDate("dd/MM/yyyy HH:mm:ss");
	}
	
	public static String getCurrentDate(String format) {

		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}
	
	

}
