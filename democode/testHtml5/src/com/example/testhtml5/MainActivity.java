package com.example.testhtml5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		webView = (WebView) findViewById(R.id.wb);
		webView.getSettings().setJavaScriptEnabled(true);
		// webView.addJavascriptInterface(new JavaScriptInterface(),
		// "beyondbit");
		
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metric = new DisplayMetrics();
		display.getMetrics(metric);

		webView.setInitialScale((int) (100 * metric.density));
		
		webView.getSettings().setSupportZoom(false);
		webView.getSettings().setDefaultTextEncodingName("gbk");

		webView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_UP:
					if (!v.hasFocus()) {
						v.requestFocus();
					}
					break;
				}
				return false;
			}
		});

		// webView.setWebViewClient(new )
		webView.setWebViewClient(new WebViewClient() {

			public void onPageFinished(WebView view, String url) {

			};

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {

			};
		}

		);

		webView.loadUrl("file:///android_asset/testVideo.html");
		// webView.loadData("<html><body><input type=\"button\" value=\"test GPS\" onClick=\"javascript:alert(window.beyondbit.checkGPS());\"/></body></html>",
		// "html/text", "UTF-8");
		// webView.loadUrl("http://m.guahao.com/mobile/fastorder/home?isdisplayprocince=1&domain_sysname=m&guahaoServer=http%3A%2F%2Fm.guahao.com");

	}

}
