package txc.example;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorSummary extends Activity {
	private TextView tv;
	private SensorManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor_summary);
		tv = (TextView) findViewById(R.id.sensor_summary_tv);
		// 得到传感器服务
		manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		// 得到所有的传感器列表
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
		StringBuffer buffer = new StringBuffer();
		buffer.append("当前手机总共有" + sensors.size() + "手机传感器，他们是:  \n");
		int i = 0;
		for (Sensor sensor : sensors) {
			i++;
			String tempStr = "传感器名称：" + sensor.getName() + "\n供应商"
					+ sensor.getVendor() + "\n设备版本号：" + sensor.getVersion()
					+ "\n";
			switch (sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER: // 加速度传感器
				buffer.append(i + ":加速度传感器\n" + tempStr);
				break;

			case Sensor.TYPE_GYROSCOPE: // 陀螺仪传感器
				buffer.append(i + ":陀螺仪传感器\n" + tempStr);
				break;
			case Sensor.TYPE_ORIENTATION: // 方向传感器
				buffer.append(i + ":方向传感器\n" + tempStr);
				break;
			case Sensor.TYPE_LIGHT: // 光线传感器
				buffer.append(i + ":光线传感器\n" + tempStr);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD: // 磁场传感器
				buffer.append(i + ":磁场传感器\n" + tempStr);
				break;
			case Sensor.TYPE_PRESSURE: // 压力传感器
				buffer.append(i + ":压力传感器\n" + tempStr);
				break;
			case Sensor.TYPE_PROXIMITY: // 接近传感器
				buffer.append(i + ":接近传感器\n" + tempStr);
				break;
			case Sensor.TYPE_TEMPERATURE: // 温度传感器
				buffer.append(i + ":温度传感器\n" + tempStr);
				break;
			default:
				buffer.append(i + ":未知传感器\n" + tempStr);
			}
		}
		tv.setText(buffer.toString());
	}
}
