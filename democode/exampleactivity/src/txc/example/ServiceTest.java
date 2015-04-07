package txc.example;

import txc.example.MyService01.MyBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceTest extends Activity {
	private Button start;
	private Button stop;
	private Button bind;
	private Button unbind;
	private MyService01 service;
	private boolean isBound=false;

	private ServiceConnection conn=new ServiceConnection() {
		//ʵ��2������ ���԰�activity�е����ݸ�service  ����Կ���service
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		//�������� ��һ�����ӷ����ʱ�����
		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			// TODO Auto-generated method stub
			System.out.println("=====onServiceConnected(ComponentName name, IBinder binder)");
			//�õ�service���� �Ϳ��Ե���sevice�Ĺ��������������Ϳ��Կ���service
			service=((MyService01.MyBinder)binder).getService();
			isBound=true;
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.service_test);
		start = (Button) findViewById(R.id.start_service_btn);
		stop = (Button) findViewById(R.id.stop_service_btn);
		bind = (Button) findViewById(R.id.bind_service_btn);
		unbind = (Button) findViewById(R.id.unbind_service_btn);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				doStartService();
			}
		});
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				doStopService();
			}
		});
		doBindService();
//		bind.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				doBindService();
//			}
//		});
//		unbind.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				doUnbindService();
//			}
//		});

	}
	private void doStartService(){
		Intent intent=new Intent(this,MyService01.class);
		startService(intent);
	}
	private void doStopService(){
		Intent intent=new Intent(this,MyService01.class);
		stopService(intent);
	}
	private void doBindService(){
		Intent intent=new Intent(this,MyService01.class);
		//Context.BIND_AUTO_CREATE����õĳ���ֵ ִ�а�ʱ������󶨵Ķ��󲻴����� �Զ������������
		//������������onbind����  ���س�����ibinder���� ʹactivity�õ��ö��� ����ɺ�activity����conn
		//conn��onserviceconnected�ķ���  ��������Ϳ��Եõ�serveice
		this.bindService(intent, conn, Context.BIND_AUTO_CREATE);//conn�������Ӷ���Ҫ�Լ�����
		//1 ����intent �ҵ�service 
		//���û��serviceʵ�� ���ж�Context.BIND_AUTO_CREATE  ����������Դ���service
		//�����ú����service��oncreate���� �ٵ���onbind���� �õ�ibinder����
		//�󶨺ú� ����conn��onserviceconnected�ķ���  ��������Ϳ��Եõ�serveice
	}
	private void doUnbindService(){
		if(isBound){
		this.unbindService(conn);
		isBound=false;
		}
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		doUnbindService();
	}
}
