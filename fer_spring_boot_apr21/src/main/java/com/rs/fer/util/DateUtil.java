package com.rs.fer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getCurrentDate() {

		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(new Date());
	}

	public static String getCurrentDateAndTime() {
		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}
	
	public static String getCurrentDate(String format) {

		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}
	
}
