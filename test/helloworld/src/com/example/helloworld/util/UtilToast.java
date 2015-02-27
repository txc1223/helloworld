package com.example.helloworld.util;

import android.content.Context;
import android.widget.Toast;



/**
 * UtilToast.java<br/>
 * Date:2011-9-14 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:Toast工具类
 */
public class UtilToast {

	public static void show(Context context,String text) {
		Toast.makeText(context, text, 2000).show();
	}

	public static void show(Context context,int textRes) {
		Toast.makeText(context, textRes, 2000).show();
	}

	public static void show(Context context,String text, int t) {
		Toast.makeText(context, text, t).show();
	}

	public static void show(Context context,int textRes, int t) {
		Toast.makeText(context, textRes, t).show();
	}
}