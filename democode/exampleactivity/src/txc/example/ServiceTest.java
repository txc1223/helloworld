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
		//实现2个方法 可以把activity中的数据给service  活动可以控制service
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		//生命周期 第一次连接服务的时候调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			// TODO Auto-generated method stub
			System.out.println("=====onServiceConnected(ComponentName name, IBinder binder)");
			//得到service对象 就可以调用sevice的公开方法，这样就可以控制service
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
		//Context.BIND_AUTO_CREATE编译好的常量值 执行绑定时如果被绑定的对象不存在则 自动创建这个服务
		//创建服务后调用onbind方法  返回出来的ibinder对象 使activity得到该对象 绑定完成后activity调用conn
		//conn的onserviceconnected的方法  这个方法就可以得到serveice
		this.bindService(intent, conn, Context.BIND_AUTO_CREATE);//conn服务连接对象要自己创建
		//1 根据intent 找到service 
		//如果没有service实例 就判断Context.BIND_AUTO_CREATE  这个常量可以创建service
		//创建好后调用service的oncreate方法 再调用onbind方法 得到ibinder对象
		//绑定好后 调用conn的onserviceconnected的方法  这个方法就可以得到serveice
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
