package com.example.helloworld.util;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


/**
 * 此方法在此处使用可能会有问题，尽量避免使用
 */
public class UtilDimen {


	private static Display display;

	/**
	 * 屏幕宽度(px)
	 */
	private static int SCREEN_WIDTH_PX;
	/**
	 * 屏幕宽度(dp)
	 */
	private static int SCREEN_WIDTH_DP;

	/**
	 * 屏幕高度
	 */
	private static int SCREEN_HEIGHT_PX;
	/**
	 * 屏幕高度(dp)
	 */
	private static int SCREEN_HEIGHT_DP;

	/**
	 * 屏幕密度
	 */
	private static float DENSITY;

	/**
	 * 屏幕密度DPI
	 */
	private static int DENSITYDPI;

	private static void initDisplay(Context context){
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		display = wm.getDefaultDisplay();
//		DisplayMetrics metric = new DisplayMetrics();
//		display.getMetrics(metric);
//		SCREEN_WIDTH_PX = metric.widthPixels; // 屏幕宽度（像素）
//		SCREEN_HEIGHT_PX = metric.heightPixels; // 屏幕高度（像素）
//		DENSITY = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
//		DENSITYDPI = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240)
//		SCREEN_HEIGHT_DP = (int) (SCREEN_HEIGHT_PX / DENSITY);
//		SCREEN_WIDTH_DP = (int) (SCREEN_WIDTH_PX / DENSITY);
	}
	
	public static float px2dp(int px,Context context) {
		initDisplay(context);
		
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		DENSITY = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		
		return px / DENSITY;
	}

	public static float dp2px(int dp,Context context) {
		initDisplay(context);
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		DENSITY = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		return dp * DENSITY;
	}

	public static int getSCREEN_WIDTH_PX(Context context) {
		initDisplay(context);
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		SCREEN_WIDTH_PX = metric.widthPixels; // 屏幕宽度（像素）
		return SCREEN_WIDTH_PX;
	}

	public static int getSCREEN_WIDTH_DP(Context context) {
		initDisplay(context);
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		SCREEN_WIDTH_PX = metric.widthPixels; // 屏幕宽度（像素）
		DENSITY = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		SCREEN_WIDTH_DP = (int) (SCREEN_WIDTH_PX / DENSITY);
		return SCREEN_WIDTH_DP;
	}

	public static int getSCREEN_HEIGHT_PX(Context context) {
		initDisplay(context);
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		SCREEN_HEIGHT_PX = metric.heightPixels; // 屏幕高度（像素）
		return SCREEN_HEIGHT_PX;
	}

	public static int getSCREEN_HEIGHT_DP(Context context) {
		initDisplay(context);
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);
		SCREEN_HEIGHT_PX = metric.heightPixels; // 屏幕高度（像素）
		DENSITY = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		SCREEN_HEIGHT_DP = (int) (SCREEN_HEIGHT_PX / DENSITY);
		return SCREEN_HEIGHT_DP;
	}

	
}