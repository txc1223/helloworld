package txc.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver02 extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		// TODO Auto-generated method stub
		String str=intent.getStringExtra("values");
		System.out.println("====myreceiver02 接收到广播消息"+str);
	}

}
