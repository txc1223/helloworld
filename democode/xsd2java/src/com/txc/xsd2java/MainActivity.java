package com.txc.xsd2java;

import java.util.Calendar;
import java.util.GregorianCalendar;

import util.ISODateFormat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView wb=(WebView)findViewById(R.id.webview);
		wb.loadUrl("http://www.zbggwhy.com/zbCulture_WebSite/UploadPath/no_admin_pic.jpg");
//		QueryMagazineRequest magazineRequest =new QueryMagazineRequest();
//		magazineRequest.setPageSize(5);
//		magazineRequest.setPageNumber(0);
//		// 获得最近1年的时间
//		Date startTime = UtilCalendar.addDays(new Date(), -365);
//		Calendar cStart = Calendar.getInstance();
//		cStart.setTime(startTime);
//		magazineRequest.setViewStartTime(cStart);
//
//		Calendar cEnd = Calendar.getInstance();
//		cEnd.setTime(new Date());
//		magazineRequest.setViewEndTime(cEnd);
////		String strTz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT);
//		System.out.println(UtilTextContent.date2String(new Date()));
//		
////		QueryHomeAppRequest a = new QueryHomeAppRequest();
//		System.out.println(RequestSerializer.serialize(magazineRequest));
		Calendar startTime = GregorianCalendar.getInstance();
		startTime.setTime(UtilDate.cutDate(UtilDate.getCurrentMondayOfWeek(Calendar.getInstance().getTime())));
		String s=new ISODateFormat().format(startTime.getTime());
		System.out.println(s);
		System.out.println("===============onCreate");
		onNewIntent(getIntent());
	}
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		System.out.println("===============onNewIntent");
	}
}
