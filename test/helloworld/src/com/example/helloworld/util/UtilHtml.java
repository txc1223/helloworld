package com.example.helloworld.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: HTML相关的正则表达式工具类
 * </p>
 * <p>
 * Description: 包括过滤HTML标记，转换HTML标记，替换特定HTML标记
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * @author guojiandong
 * @version 1.0
 * @createtime 2011-8-11
 */
public class UtilHtml {

	private final static String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签

	//	private final static String regxpForImgTag = "<\\s*img\\s+([^>]*)\\s*>"; // 找出IMG标签
	//	private final static String regxpForImaTagSrcAttrib = "src=\"([^\"]+)\""; // 找出IMG标签的SRC属性

	/**
	 * 
	 * 基本功能：替换标记以正常显示
	 * <p>
	 * 
	 * @param input
	 * @return String
	 */
	public static String replaceTag(String input) {

		if (!hasSpecialChars(input)) {
			return input;
		}

		StringBuffer filtered = new StringBuffer(input.length());
		char c;
		for (int i = 0; i <= input.length() - 1; i++) {
			c = input.charAt(i);
			switch (c){
				case '<':
					filtered.append("&lt;");
					break;
				case '>':
					filtered.append("&gt;");
					break;
				case '"':
					filtered.append("&quot;");
					break;
				case '&':
					filtered.append("&amp;");
					break;
				default:
					filtered.append(c);
			}
		}

		return (filtered.toString());
	}

	/**
	 * 
	 * 基本功能：判断标记是否存在
	 * <p>
	 * 
	 * @param input
	 * @return boolean
	 */
	public static boolean hasSpecialChars(String input) {
		boolean flag = false;
		if ((input != null) && (input.length() > 0)) {
			char c;
			for (int i = 0; i <= input.length() - 1; i++) {
				c = input.charAt(i);
				switch (c){
					case '>':
						flag = true;
						break;
					case '<':
						flag = true;
						break;
					case '"':
						flag = true;
						break;
					case '&':
						flag = true;
						break;
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * 基本功能：过滤所有以"<"开头以">"结尾的标签
	 * <p>
	 * 
	 * @param str
	 * @return String
	 */
	public static String filterHtml(String str) {
		Pattern pattern = Pattern.compile(regxpForHtml);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 
	 * 基本功能：过滤指定标签
	 * <p>
	 * 
	 * @param str
	 * @param tag 指定标签
	 * @return String
	 */
	public static String fiterHtmlTag(String str, String tag) {
		String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 
	 * 基本功能：替换指定的标签
	 * <p>
	 * 
	 * @param str
	 * @param beforeTag 要替换的标签
	 * @param tagAttrib 要替换的标签属性值
	 * @param startTag 新标签开始标记
	 * @param endTag 新标签结束标记
	 * @return String
	 * @如：替换img标签的src属性值为[img]属性值[/img]
	 */
	public static String replaceHtmlTag(String str, String beforeTag, String tagAttrib, String startTag, String endTag) {
		String regxpForTag = "<\\s*" + beforeTag + "\\s+([^>]*)\\s*>";
		String regxpForTagAttrib = tagAttrib + "=\"([^\"]+)\"";
		Pattern patternForTag = Pattern.compile(regxpForTag);
		Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);
		Matcher matcherForTag = patternForTag.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = matcherForTag.find();
		while (result) {
			StringBuffer sbreplace = new StringBuffer();
			Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
			if (matcherForAttrib.find()) {
				matcherForAttrib.appendReplacement(sbreplace, startTag + matcherForAttrib.group(1) + endTag);
			}
			matcherForTag.appendReplacement(sb, sbreplace.toString());
			result = matcherForTag.find();
		}

		matcherForTag.appendTail(sb);
		return sb.toString();
	}

	/**
	 * <pre>
	 * &amp;lt;转化 &lt;
	 * &amp;gt;转化 &gt;
	 * 如:  &amp;lt;img src = "xxx.jpg" /&amp;gt;
	 *  &lt;img src = "xxx.jpg" /&gt;
	 * </pre>
	 * @param html
	 * @return
	 */
	public static String replaceHtmlLeftRight(String html) {
		if (html == null) {
			html = "";
		}
		String temp = html.replace("&lt;", "<");
		return temp.replace("&gt;", ">");
	}

	
	/**
	 * 将Html源码中老的字符串替换为新的字符串，正则替换数据
	 * 
	 * @param res
	 *            源码字符串
	 * @param oldRes
	 *            老的字符串
	 * @param newRes
	 *            新的字符串
	 * @return 修改过的字符串
	 */
	public static String replaceFromHtml(String res, String oldRes, String newRes) {
		String newString = Pattern.compile(oldRes, Pattern.LITERAL).matcher(res).replaceAll(newRes);
		return newString;
	}
	
	public static void main(String[] args) {
		String html = "&lt;P class=MsoNormal style=\"MARGIN: 0cm 0cm 0pt; TEXT-INDENT: 28.5pt; LINE-HEIGHT: 22pt; mso-line-height-rule: exactly\"&gt;&lt;SPAN style=\"FONT-SIZE: 14pt; COLOR: black; FONT-FAMILY: 宋体; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt\"&gt;单位统一发车前往曹杨社区阳光之家，以关爱智障青少年为重点，开展结对送温暖活动。&lt;SPAN lang=EN-US&gt;&lt;?xml:namespace prefix = o ns = \"urn:schemas-microsoft-com:office:office\" /&gt;&lt;o:p&gt;&lt;/o:p&gt;&lt;/SPAN&gt;&lt;/SPAN&gt;&lt;/P&gt;";
		//		System.out.println(html);
		//		String a = replaceHtmlLeftRight(html);
		//		System.out.println(a);
		//		String h = filterHtml(a);
		//		System.out.println(h);
		System.out.println(UtilHtml.filterHtml(UtilHtml.replaceHtmlLeftRight(html)));
	}
}
