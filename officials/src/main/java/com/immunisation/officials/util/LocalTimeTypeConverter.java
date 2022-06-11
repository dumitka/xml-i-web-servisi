package com.immunisation.officials.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTypeConverter {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	
	public static LocalTime parseTime(String value) {
		return (LocalTime) formatter.parse(value);
	}
	
	public static String printTime(LocalTime value) {
		if(value != null) {
			return formatter.format(value);
		} else {
			return null;
		}
	}
	
}

