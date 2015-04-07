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
	//���ٶȴ�����  �
	private TextView tv1;
	private SensorManager manager;
	// ������������
	private SensorEventListener listener = new SensorEventListener() {
		// ֵ�仯ʱ����
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			// ��ǰ���������µ�ֵ ����Ǽ��ٶȴ����� 3��ֵ
			// 0 1 2ֵΪx y z�����ϵļ��ٶ� ��Ļ������Ļ��ΪY ��ΪX x������ y�����¸� ��ֱΪZ �����¸�
			String str = "X" + event.values[0] + "\nY:" + event.values[1]
					+ "\nZ:" + event.values[2];
			tv1.setText(str);

		}

		// ���ȱ仯ʱ����
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
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_PROXIMITY);//��������Ҫ������
		if (sensors.size() > 0) {
			Sensor sen = sensors.get(0);
			// rate ������ listener������  3����Ƶ��
			manager.registerListener(listener, sen,
					SensorManager.SENSOR_DELAY_GAME);
			// SensorManager.SENSOR_DELAY_FASTEST û���ӳ� �������
			// SensorManager.SENSOR_DELAY_GAME; �ȽϿ� 20ms
			// SensorManager.SENSOR_DELAY_NORMAL; ��ͨ�Ĳ���Ƶ�� 200ms
			// SensorManager.SENSOR_DELAY_UI; �ʺ����û����� 80ms
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//����ʱҪȡ��
		manager.unregisterListener(listener);
	}
}
