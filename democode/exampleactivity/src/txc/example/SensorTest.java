package txc.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SensorTest extends Activity {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.senesor_test);
		btn1 = (Button) findViewById(R.id.senesor_btn1);
		btn2 = (Button) findViewById(R.id.senesor_btn2);
		btn3 = (Button) findViewById(R.id.senesor_btn3);
		btn4 = (Button) findViewById(R.id.senesor_btn4);
		btn5 = (Button) findViewById(R.id.senesor_btn5);
		btn1.setOnClickListener(listener);
		btn2.setOnClickListener(listener);
		btn3.setOnClickListener(listener);
		btn4.setOnClickListener(listener);
		btn5.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {
		private Intent intent;
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.senesor_btn1:
				intent =new Intent(SensorTest.this,SensorSummary.class);
				startActivity(intent);
				break;

			case R.id.senesor_btn2:
				intent =new Intent(SensorTest.this,AccelertorSensorTest.class);
				startActivity(intent);
				break;
			case R.id.senesor_btn3:
				intent =new Intent(SensorTest.this,OrientationSensorTest.class);
				startActivity(intent);
				break;
			case R.id.senesor_btn4:
				intent =new Intent(SensorTest.this,LightSensorTest.class);
				startActivity(intent);
				break;
			case R.id.senesor_btn5:
				intent =new Intent(SensorTest.this,ProximityTest.class);
				startActivity(intent);
				break;
			}
		}
	};
	
}
