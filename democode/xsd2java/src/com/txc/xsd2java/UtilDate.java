/*
 * Copyright (c)Beyondbit Internet Software Co., Ltd. 
 * 
 * This software is the confidential and proprietary information of 
 * Beyondbit Internet Software  Co., Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it 
 * only in accordance with the terms of the license agreement you 
 * entered into with Beyondbit Internet Software Co., Ltd.
 */

package com.txc.xsd2java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Zhangjr Date 2006-9-12 <br>
 *         Description: <br>
 *         时间操作工具类
 */

public class UtilDate {

	/**
	 * 获得系统当前时间的字符串表示
	 * 
	 * @return
	 */
	public static final String getNowStr() {

		//		Calendar c = Calendar.getInstance();
		//		c.getTime(); //Wed Mar 12 10:11:21 CST 2008    输出这种形式

		Calendar c = Calendar.getInstance(Locale.CHINESE);
		return format(c.getTime());//输出这种形式 2008-03-12 10:11:21 
	}

	/**
	 * 获得系统当前时间
	 * 
	 * @return
	 */
	public static final Date getNow() {
		return new Date();
	}

	/**
	 * 取得4位数的年份
	 * 
	 * @param date Date
	 * @return String 4位数的年份
	 */
	public static final String getYear4(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}

	/**
	 * 取得2位数的年份
	 * 
	 * @param date Date
	 * @return 2位数的年份
	 */
	public static final String getYear2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yy");
		return format.format(date);
	}

	/**
	 * 取得月分
	 * 
	 * @param date Date
	 * @return String 月分
	 */
	public static final String getMonth(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("MM");
		return format.format(date);
	}

	/**
	 * 取得日期
	 * 
	 * @param date Date
	 * @return String 日期
	 */
	public static final String getDay(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd");
		return format.format(date);
	}

	/**
	 * 取得小时
	 * 
	 * @param date Date
	 * @return String 小时
	 */
	public static final String getHours(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("hh");
		return format.format(date);
	}

	/**
	 * 取得分钟
	 * 
	 * @param date Date
	 * @return String 分钟
	 */
	public static final String getMinutes(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("mm");
		return format.format(date);
	}

	/**
	 * 取得秒
	 * 
	 * @param date Date
	 * @return 秒
	 */
	public static final String getSeconds(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("ss");
		return format.format(date);
	}

	/**
	 * 格式化日期为字符串, 默认格式为"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date Date
	 * @return
	 */
	public static final String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化日期为字符串
	 * 
	 * @param date Date
	 * @param pattern 格式
	 * @return String 格式化日期后的字符串
	 */
	public static final String format(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 把字符串转换为日期
	 * 
	 * @param str 日期字符串
	 * @param pattern 格式
	 * @return Date 日期
	 * @throws ParseException 异常
	 */
	public static final Date parseDate(String str, String pattern) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(str);
	}

	/**
	 * 取得小时的小数形式，如果12:30即为12.5,13:15为13.25
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static double getDoubleHour(Date date) {
		int hour = date.getHours();
		int min = date.getMinutes();
		return hour + min / 60.0;
	}

	/**
	 * 当期日期的星期一
	 * 
	 * @param d
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getCurrentMondayOfWeek(Date d) {
		int day = d.getDay();
		int n = day == 0 ? -6 : -day + 1;
		Date monday = UtilCalendar.addDays(d, n);
		return monday;
	}

	/**
	 * 当期日期的星期天
	 * 
	 * @param d
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getCurrentSundayOfWeek(Date d) {
		int day = d.getDay();
		int n = day == 0 ? 0 : 7 - day;
		Date sunday = UtilCalendar.addDays(d, n);
		return sunday;
	}

	/**
	 * 当前日期所在周的星期一，时分秒为0:00:00
	 * 
	 * @param cal
	 * @return
	 */
	public static Date getCurrentMondayOfWeekByCut(Calendar cal) {
		Date d = getCurrentMondayOfWeek(cal.getTime());
		Date cutDate = cutDate(d);
		return cutDate;
	}

	/**
	 * 当前日期所在周的星期一，时分秒为0:00:00
	 * 
	 * @param cal
	 * @return
	 */
	public static Date getNextMondayOfWeekByCut(Calendar cal) {
		Date d = getCurrentMondayOfWeek(cal.getTime());
		Date cutDate = UtilDate.cutDate(d);
		return UtilCalendar.addDays(cutDate, 7);
	}

	/**
	 * 截取日期,保留年月日，去掉时分秒
	 * 
	 * @param d
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date cutDate(Date d) {
		return new Date(d.getYear(), d.getMonth(), d.getDate());
	}

	public static void main(String[] args) {

	}
}
