package com.example.helloworld.util;
/**
 * UtilText.java<br/>
 * Date:2011-9-28 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:文本工具类
 */
public class UtilText {
	/**
	 * 把一个数字转化为带有0的格式
	 * 如传入参数(123,4),则返回0123
	 * @param i 数字
	 * @param n 全部的位数
	 * @return 数字前补0的字符串
	 */
	public static String toFullString(int i, int n) {
		String ii = i + "";
		if (ii.length() == n) {
			return ii;
		} else {
			int t = n - ii.length();
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < t; j++) {
				sb.append("0");
			}
			return sb.toString() + ii;
		}
	}
}