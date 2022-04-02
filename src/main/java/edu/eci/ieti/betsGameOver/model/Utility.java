package edu.eci.ieti.betsGameOver.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utility {
	
	public static String getCurrentDefaultDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		return formatter.format(date);
	}
	
	public static String getCurrentTZDate(String format) {
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //sdf.setTimeZone(TimeZone.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        return sdf.format(calendar.getTime());
	}
}