package com.txc.gridview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Toast.makeText(MainActivity.this, "¸ü¶à", 1).show();
			adapter.addItem();
		};
	};
	DataAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyGridView gv = (MyGridView) findViewById(R.id.MainGridViewGrid);
		final ScrollView sv = (ScrollView) findViewById(R.id.MainGridViewScroll);
		final LinearLayout ll = (LinearLayout) findViewById(R.id.MainGridViewScrollLinear);
		adapter = new DataAdapter(this);
		gv.setAdapter(adapter);
		sv.setOverScrollMode(View.OVER_SCROLL_NEVER);
		sv.setOnTouchListener(new OnTouchListener() {

			private int lastY = 0;

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_UP) {
					lastY = sv.getScrollY();
					if (lastY == (ll.getHeight() - sv.getHeight())) {
						// LLF.setVisibility(View.VISIBLE);
						addMoreData();
					}
				}
				return false;
			}
		});
	}

	private void addMoreData() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Bundle b = new Bundle();
				try {
					Thread.sleep(1000);
					b.putBoolean("addMoreData", true);
				} catch (Exception e) {
				} finally {
					Message msg = handler.obtainMessage();
					msg.setData(b);
					handler.sendMessage(msg);
				}
			}
		}).start();
	}
}
