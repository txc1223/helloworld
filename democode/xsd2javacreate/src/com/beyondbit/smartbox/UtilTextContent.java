package com.beyondbit.smartbox;

import java.util.Date;

import android.util.Base64;

public class UtilTextContent {
	public static void main(String[] args) {
		Date startTime = UtilCalendar.addDays(new Date(), -365);
		System.out.println(date2String(startTime));
	}
	public static java.util.Calendar toCalendar(String textContent) {
		Date d = null;
		try {
			d = new ISODateFormat().parse(textContent);
			System.out.println(textContent + "-----转------" + d);
			if (d == null) {
			} else {
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.setTime(d);
				return cal;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String date2String(Date d) {
		String date=null;
		try {
			ISODateFormat s=new ISODateFormat();
			date=s.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static byte[] toBytes(String textContent) {
		return Base64.decode(textContent, Base64.NO_WRAP);
	}

	public static int toInt(String textContent) {
		return Integer.parseInt(textContent);
	}

	public static boolean toBoolean(String textContent) {
		return Boolean.parseBoolean(textContent);
	}

	public static long toLong(String textContent) {
		return Long.parseLong(textContent);
	}

	public static double toDouble(String textContent) {
		return Double.parseDouble(textContent);
	}
}
