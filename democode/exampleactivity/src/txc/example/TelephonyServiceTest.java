package txc.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelephonyServiceTest extends Activity {
	private EditText et1,et2;
	private Button btn1,btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telphony_service);
		et1=(EditText)findViewById(R.id.tel_ser_number);
		et2=(EditText)findViewById(R.id.tel_ser_sms);
		btn1=(Button)findViewById(R.id.tel_ser_btn1);
		btn2=(Button)findViewById(R.id.tel_ser_btn2);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//ֱ�Ӳ���绰
				//Intent intent=new Intent(Intent.ACTION_CALL);
				//��Ӳ���绰
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:"+et1.getText().toString()));
				startActivity(intent);
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager manager=SmsManager.getDefault();
				//Ŀ���ַ, �������ĵ�ַ , �ı�,  ����Щ�����͵Ĺ㲥 , �Է��յ��󷢸��㲥��Ӧ�ó���
				manager.sendTextMessage(et1.getText().toString(),null , et2.getText().toString(), 
						null, null);
				Toast.makeText(TelephonyServiceTest.this, 
						"�ɹ����Ͷ���Ϣ��"+et1.getText().toString(), 2000).show();
			}
		});
	}
}
