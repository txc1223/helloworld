package txc.example;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService01 extends Service {
	private boolean isRunning = true;
	private MediaPlayer player = null;
/**
 * 自定义的绑定器 
 * @author txc
 *
 */
	public class MyBinder extends Binder {
	//自己实现  让activity得到service对象
		public MyService01 getService() {
			return MyService01.this;
		}
	}
//返回值返给onServiceConnected(ComponentName name, IBinder binder) 的ibinder参数
	@Override
	public IBinder onBind(Intent arg0) {
		System.out.println("onbind------");
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		// 音频数据
		player = MediaPlayer.create(this, R.raw.a6);
		player.start();
		player.setLooping(true);
		System.out.println("onCreate------");
		new Thread() {
			public void run() {
				int i = 0;
				while (isRunning) {
					System.out.println("服务运行中i===" + i);
					i++;
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand------");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		player.stop();
		System.out.println("onDestroy------");
		isRunning = false;

	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind------");
		return super.onUnbind(intent);
	}

	public void pause() {
		player.pause();
	}

	public void play() {
		// player.
	}
}
