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
		// �õ�����������
		manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		// �õ����еĴ������б�
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
		StringBuffer buffer = new StringBuffer();
		buffer.append("��ǰ�ֻ��ܹ���" + sensors.size() + "�ֻ���������������:  \n");
		int i = 0;
		for (Sensor sensor : sensors) {
			i++;
			String tempStr = "���������ƣ�" + sensor.getName() + "\n��Ӧ��"
					+ sensor.getVendor() + "\n�豸�汾�ţ�" + sensor.getVersion()
					+ "\n";
			switch (sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER: // ���ٶȴ�����
				buffer.append(i + ":���ٶȴ�����\n" + tempStr);
				break;

			case Sensor.TYPE_GYROSCOPE: // �����Ǵ�����
				buffer.append(i + ":�����Ǵ�����\n" + tempStr);
				break;
			case Sensor.TYPE_ORIENTATION: // ���򴫸���
				buffer.append(i + ":���򴫸���\n" + tempStr);
				break;
			case Sensor.TYPE_LIGHT: // ���ߴ�����
				buffer.append(i + ":���ߴ�����\n" + tempStr);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD: // �ų�������
				buffer.append(i + ":�ų�������\n" + tempStr);
				break;
			case Sensor.TYPE_PRESSURE: // ѹ��������
				buffer.append(i + ":ѹ��������\n" + tempStr);
				break;
			case Sensor.TYPE_PROXIMITY: // �ӽ�������
				buffer.append(i + ":�ӽ�������\n" + tempStr);
				break;
			case Sensor.TYPE_TEMPERATURE: // �¶ȴ�����
				buffer.append(i + ":�¶ȴ�����\n" + tempStr);
				break;
			default:
				buffer.append(i + ":δ֪������\n" + tempStr);
			}
		}
		tv.setText(buffer.toString());
	}
}
