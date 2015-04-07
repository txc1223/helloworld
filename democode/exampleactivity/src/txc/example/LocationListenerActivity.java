package txc.example;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LocationListenerActivity extends Activity {
	private TextView tv1;
	private EditText phoneEt;
	private Button startBtn, stopBtn;
	private String[] phoneNumbers;
	private BroadcastReceiver receiver;
	private Location location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_listener);
		tv1 = (TextView) findViewById(R.id.location_tv1);
		phoneEt = (EditText) findViewById(R.id.location_phone_et);
		startBtn = (Button) findViewById(R.id.location_start_btn);
		stopBtn = (Button) findViewById(R.id.location_stop_btn);
		startBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phones = phoneEt.getText().toString().trim();
				phoneNumbers = phones.split(",");
				receiver = new SMSReceiverGoogle();
				IntentFilter filter = new IntentFilter();
				filter.addAction("android.provider.Telephony.SMS_RECEIVED");
				LocationListenerActivity.this
						.registerReceiver(receiver, filter);
				startBtn.setEnabled(false);
			}
		});

		stopBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocationListenerActivity.this.unregisterReceiver(receiver);
				startBtn.setEnabled(true);
			}
		});
	}
//得到位置  把位置用短信方式发送
	private Location getCurrentLocation() {
		
		return null;
	}

	class SMSReceiverGoogle extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Bundle bun = intent.getExtras();
			if (bun != null) {
				Object[] mypdus = (Object[]) bun.get("pdus");// pdus广播短消息出来的参数名
																// 键值对 值为一个数组
				SmsMessage[] messages = new SmsMessage[mypdus.length];
				for (int i = 0; i < messages.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[]) mypdus[i]);
				}
				for (SmsMessage mess : messages) {
					// 得到地址和内容
					String from = mess.getDisplayOriginatingAddress();
					for (int i = 0; i < phoneNumbers.length; i++) {
						if (from.contains(phoneNumbers[i])) {
							String body = mess.getMessageBody();
							// mess.getTimestampMillis();
							SmsManager manager = SmsManager.getDefault();
							 manager.sendTextMessage("5556", null, from + ":"
							 + body,
							 null, null);
						}
					}
				}
			}
		}
	}
}
