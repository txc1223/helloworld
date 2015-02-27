package com.example.helloworld.util;

import java.text.NumberFormat;
import java.util.Locale;

public class UtilString {
	public static String dateStringtoString(String s) {
		String dates = "";
		try {
			dates = s.substring(0, 10);
		} catch (Exception e) {
			dates = s;
		}
		return dates;
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param value
	 *            字符串
	 * @return boolean true: 为空 false: 不为空
	 */
	public static boolean isEmpty(String value) {
		return (value == null || value.equals("") || value.trim().equals("")) ? true : false;
	}

	/**
	 * 钱转String 543210000000000.01
	 * 
	 * ￥543,210,000,000,000.01
	 */
	public static String numberFormatMoney(double value) {
		NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
		return usFormat.format(value);
	}

}
