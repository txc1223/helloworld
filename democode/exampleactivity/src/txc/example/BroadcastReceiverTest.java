package txc.example;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastReceiverTest extends Activity {
	private Button start;
	private Button stop;
	private TextView tv;
	private BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_receiver);
		receiver = new MyBroadcastReceiver();
		start = (Button) findViewById(R.id.start_broadcastreciver);
		stop = (Button) findViewById(R.id.stop_broadcastreciver);
		tv = (TextView) findViewById(R.id.message_broadcast);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent =new Intent("txc.test1");
//				sendBroadcast(intent);
				startReceiver();
			}
		});
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopReceiver();
			}
		});
	}

	private void startReceiver() {
		IntentFilter filter = new IntentFilter();
		filter.addAction("txc.test1");
		//filter.setPriority(1);  //设置优先级 数字越大 优先级越高
		this.registerReceiver(receiver, filter);
		//注册短消息广播接收器代码
//		IntentFilter filter = new IntentFilter();
//		//短信过滤名
//		filter.addAction("android.provider.Telephony.SMS_RECEIVED");
//		this.registerReceiver(receiver, filter);
	}

	private void stopReceiver() {
		this.unregisterReceiver(receiver);
	}

	private class MyBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			System.out.println(context.getClass().getClassLoader().getClass().getName()+"---getClassLoader--");
			System.out.println(context.getClass().getName()+"--getClass---");
			String str=intent.getStringExtra("values");
			tv.append(str+"\n");
		}	
	}

}
