package txc.example;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityTest extends Activity {
	//加速度传感器  活动
	private TextView tv1;
	private SensorManager manager;
	// 传感器监听器
	private SensorEventListener listener = new SensorEventListener() {
		// 值变化时调用
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			// 当前传感器最新的值 如果是加速度传感器 3个值
			// 0 1 2值为x y z方向上的加速度 屏幕朝上屏幕长为Y 短为X x右正左负 y上正下负 垂直为Z 上正下负
			String str = "X" + event.values[0] + "\nY:" + event.values[1]
					+ "\nZ:" + event.values[2];
			tv1.setText(str);

		}

		// 精度变化时调用
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelertor_sensor);
		tv1 = (TextView) findViewById(R.id.accelertor_sensor_tv1);
		manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_PROXIMITY);//传感器主要该这里
		if (sensors.size() > 0) {
			Sensor sen = sensors.get(0);
			// rate 灵敏度 listener监听器  3采样频率
			manager.registerListener(listener, sen,
					SensorManager.SENSOR_DELAY_GAME);
			// SensorManager.SENSOR_DELAY_FASTEST 没有延迟 采样最快
			// SensorManager.SENSOR_DELAY_GAME; 比较快 20ms
			// SensorManager.SENSOR_DELAY_NORMAL; 普通的采样频率 200ms
			// SensorManager.SENSOR_DELAY_UI; 适合于用户界面 80ms
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//结束时要取消
		manager.unregisterListener(listener);
	}
}
