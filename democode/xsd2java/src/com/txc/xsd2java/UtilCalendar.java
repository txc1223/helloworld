package com.txc.xsd2java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * DateUitl.java<br/>
 * Date:2011-8-11 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:日历工具类,日历操作类，包括，日历加法，减法等
 */
@SuppressWarnings({ "deprecation" })
public class UtilCalendar {

	/**
	 * 加上n小时，n为负数的时候就是减去n小时
	 * 
	 * @param date
	 * @param n
	 */

	public static Date addMinutes(Date date, int n) {
		return new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes() + n, date.getSeconds());
	}

	/**
	 * 加上n小时，n为负数的时候就是减去n小时
	 * 
	 * @param date
	 * @param n
	 */

	public static Date addHours(Date date, int n) {
		return new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours() + n, date.getMinutes(), date.getSeconds());
	}

	/**
	 * 加上n小时，n为负数的时候就是减去n小时
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static void addHours(Calendar cal, int n) {
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + n);
	}

	/**
	 * 加上n天，n为负数的时候就是减去n天
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addDays(Date date, int n) {
		return new Date(date.getYear(), date.getMonth(), date.getDate() + n, date.getHours(), date.getMinutes(), date.getSeconds());
	}
	/**
	 * 加上n天，n为负数的时候就是减去n天
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static void addDays(Calendar cal, int n) {
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + n);
	}

	/**
	 * 加上n月,n为负数时候即为前去n月
	 * 
	 * @param cal
	 * @param n
	 */
	public static void addMonths(Calendar cal, int n) {
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + n);
	}

	/**
	 * 该月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int daysOfMonth(Date date) {
		int count = 0;
		switch (date.getMonth() + 1){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				count = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				count = 30;
				break;
			case 2:
				count = isLeapYear(date.getYear()) ? 29 : 28;
				break;
		}
		return count;
	}

	/**
	 * 该月的天数,月份范围是(1~12)
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int daysOfMonth(int year, int month) {
		int count = 0;
		switch (month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				count = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				count = 30;
				break;
			case 2:
				count = isLeapYear(year) ? 29 : 28;
				break;
		}
		return count;
	}

	/**
	 * 是否是闰年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 是否是闰年
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLeapYear(Date date) {
		int year = date.getYear();
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}


	/**
	 * 比较两个日期的大小,按年和月比较
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareDateByMonth(Date d1, Date d2) {
		int res = 0;
		res = d1.getYear() - d2.getYear();
		if (res == 0) {
			res = d1.getMonth() - d2.getMonth();
		}
		return res;
	}

	public static int compareDateYMD(Date d1, Date d2) {
		int res = 0;
		res = d1.getYear() - d2.getYear();
		if (res == 0) {
			res = d1.getMonth() - d2.getMonth();
			if (res == 0) {
				res = d1.getDate() - d2.getDate();
			}
		}
		return res;
	}

	/**
	 * 判断是否是今天
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isToday(Date d) {
		Date today = new Date();

		int a = d.getYear() - today.getYear();
		int b = d.getMonth() - today.getMonth();
		int c = d.getDate() - today.getDate();
		if (a == 0 && b == 0 && c == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否是工作日
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isWeekDay(Date d) {
		if (d.getDay() == 0 || d.getDay() == 6) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 日期的日显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toDayString(Calendar cal) {
		// return new SimpleDateFormat("yyyy年M月d日").format(cal.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 日期的日显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toDayString(Date d) {
		// return new SimpleDateFormat("yyyy年M月d日").format(cal.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(d);
	}

	/**
	 * 日期的日显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toDayString(Date d, String format) {
		// return new SimpleDateFormat("yyyy年M月d日").format(cal.getTime());
		return new SimpleDateFormat(format).format(d);
	}

	/**
	 * 日期的星期显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toWeekString(Calendar cal) {
		int n = cal.get(Calendar.DAY_OF_WEEK);
		n = n == 1 ? 7 : n - 1;
		Date d1 = addDays(cal.getTime(), -n + 1);
		Date d2 = addDays(cal.getTime(), 7 - n);
		return new SimpleDateFormat("yyyy-MM-dd").format(d1) + "~" + new SimpleDateFormat("yyyy-MM-dd").format(d2);
	}

	/**
	 * 日期的星期显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toWeekString(Calendar cal, String format) {
		int n = cal.get(Calendar.DAY_OF_WEEK);
		n = n == 1 ? 7 : n - 1;
		Date d1 = addDays(cal.getTime(), -n + 1);
		Date d2 = addDays(cal.getTime(), 7 - n);
		return new SimpleDateFormat(format).format(d1) + "~" + new SimpleDateFormat(format).format(d2);
	}

	/**
	 * 日期的月显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toMonthString(Calendar cal) {
		return new SimpleDateFormat("yyyy-MM").format(cal.getTime());
	}

	/**
	 * 日期的月显示形式
	 * 
	 * @param cal
	 * @return
	 */
	public static String toMonthString(Calendar cal, String format) {
		return new SimpleDateFormat(format).format(cal.getTime());
	}

	//	/**
	//	 * 当前日期所在周的星期一，时分秒不变
	//	 * 
	//	 * @param cal
	//	 * @return
	//	 */
	//	@Deprecated
	//	public static Calendar getCurrentMondayOfWeek(Calendar cal) {
	//		int n = cal.get(Calendar.DAY_OF_WEEK);
	//		n = n == 1 ? 7 : n - 1;
	//		Date d1 = addDays(cal.getTime(), -n + 1);
	//		Calendar c = Calendar.getInstance();
	//		c.setTime(d1);
	//		return c;
	//	}
	//	
	//	/**
	//	 * 当前日期所在周的星期日
	//	 * 
	//	 * @param cal
	//	 * @return
	//	 */
	//	@Deprecated
	//	public static Calendar getCurrentSunDayOfWeek(Calendar cal) {
	//		int n = cal.get(Calendar.DAY_OF_WEEK);
	//		n = n == 1 ? 7 : n - 1;
	//		Date d2 = addDays(cal.getTime(), 7 - n);
	//		Calendar c = Calendar.getInstance();
	//		c.setTime(d2);
	//		return c;
	//	}

	/**
	 * 当前日期所在月的第一天
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar getFristDayOfMonth(Calendar cal) {
		cal.set(Calendar.DATE, 1);
		return cal;
	}

	/**
	 * 当前日期所在月的最后一天
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar getLastDayOfMonth(Calendar cal) {
		cal.set(Calendar.DATE, UtilCalendar.daysOfMonth(cal.getTime()));
		return cal;
	}

	/**
	 * 传入的日期是否是上午
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isAm(Date date) {
		int hour = date.getHours();
		if (hour < 12) {
			return true;
		} else if (hour > 12) {
			return false;
		} else {
			return false;
		}
	}

	/**
	 * 传入的日期是否是上午
	 * 
	 * @param cal
	 * @return
	 */
	public static boolean isAm(Calendar cal) {
		return isAm(cal.getTime());
	}

	/**
	 * Date-->Calendar ,如果为空，则返回为null
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar date2Calendar(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		}
	}

}