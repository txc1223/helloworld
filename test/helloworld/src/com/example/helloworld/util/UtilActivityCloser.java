package com.example.helloworld.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import android.app.Activity;

/**
 * @author xialifan 用来统一关闭Activity的工具类
 */
public class UtilActivityCloser {
	private static UtilActivityCloser instance = null;
	private static Set<Activity> activitys = null;

	private UtilActivityCloser() {
		activitys = new HashSet<Activity>();
	}

	public static UtilActivityCloser getInstance() {
		if (instance == null) {
			instance = new UtilActivityCloser();

		}

		return instance;
	}
	
	public void add(Activity activity){
		activitys.add(activity);
	}
	
	public void remove(Activity activity){
		activitys.remove(activity);
	}
	
	public void finshAllActivity(){
		for(Activity act:activitys){
			act.finish();
		}
	}

}
