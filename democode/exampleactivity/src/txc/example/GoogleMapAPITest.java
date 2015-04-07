//package txc.example;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//
//public class GoogleMapAPITest extends Activity {
//	private Button btn1, btn2, btn3;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.google_mapapi_test);
//		btn1 = (Button) findViewById(R.id.google_btn01_location);
//		btn2 = (Button) findViewById(R.id.google_btn02_location);
//		btn3 = (Button) findViewById(R.id.google_btn03_location);
//		btn1.setOnClickListener(listener);
//		btn2.setOnClickListener(listener);
//		btn3.setOnClickListener(listener);
//	}
//	OnClickListener listener = new OnClickListener() {
//		@Override
//		public void onClick(View v) {
//			Intent intent = null;
//			switch (v.getId()) {
//			case R.id.google_btn01_location:
//				intent = new Intent(GoogleMapAPITest.this,SearchLocActivity.class);
//				break;
//			case R.id.google_btn02_location:
//				intent = new Intent(GoogleMapAPITest.this,GetLocationActivity.class);
//				break;
//			case R.id.google_btn03_location:
//				intent = new Intent(GoogleMapAPITest.this,LocationListenerActivity.class);
//				break;
//			}
//			if(intent!=null){
//				startActivity(intent);
//			}
//		}
//	};
//	
//}
