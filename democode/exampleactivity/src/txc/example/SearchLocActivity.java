//package txc.example;
//
//import java.util.List;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.maps.GeoPoint;
//import com.google.android.maps.MapActivity;
//import com.google.android.maps.MapController;
//import com.google.android.maps.MapView;
//import com.google.android.maps.Overlay;
//
//public class SearchLocActivity extends MapActivity {// Ҫ�̳�MapActivity
//	private EditText dLongEdit, dLatEdit;
//
//	private MapView mapView;
//
//	private Button btn01;
//	private Button btn02;
//	private Button btn03;
//	private Button btn04;
//	// ��ʼ�ľ�γ�����꣬�찲�Ź㳡������  Ĭ��ֵ
//	private double dLong = 116.41234;
//	private double dLat = 39.91234;
//	private MapController controller;  //ʵ�ֶԵ�ͼ�ĸ��� �����Լ���Ӧ���ƶ�
//	
//	private int zoomLevel=16;
//	
//	
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.searchlocation);
//		dLongEdit = (EditText) findViewById(R.id.dlong_et1);
//		dLatEdit = (EditText) findViewById(R.id.dlat_et1);
//		btn01 = (Button) findViewById(R.id.searh_btn1);
//		btn02 = (Button) findViewById(R.id.mode_btn1);
//		btn03 = (Button) findViewById(R.id.zoom_in_btn1);
//		btn04 = (Button) findViewById(R.id.zoom_out_btn1);
//
//		mapView = (MapView) findViewById(R.id.map_view1);
//		//�õ�controller��ͼ������
//		controller=mapView.getController();
//		refreshMap();
//		
//		btn01.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				if(dLongEdit.getText().toString().trim().equals("")||
//						dLatEdit.getText().toString().trim().equals("")){
//					Toast.makeText(SearchLocActivity.this, "��Ч��γ��", 2000).show();
//					return;
//				}
//				//����ı���������  Ȼ��ˢ��
//				dLong=Double.parseDouble(dLongEdit.getText().toString().trim());
//				dLat=Double.parseDouble(dLatEdit.getText().toString().trim());
//				refreshMap();
//			}
//		});
//		btn02.setOnClickListener(new OnClickListener() {
//			//ģʽת��  ʵ�����ǽֵ���ѯ
//			@Override
//			public void onClick(View v) {
//				Button btn=(Button)v;
//				if(btn.getText().equals("����")){
//					mapView.setSatellite(true);
//					btn.setText("�ֵ�");
//				}else if(btn.getText().equals("�ֵ�")){
//					mapView.setSatellite(false);
//					btn.setText("����");
//				}
//			}
//		});
//		btn03.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				zoomLevel++;
//				if(zoomLevel>mapView.getMaxZoomLevel()){
//					zoomLevel=mapView.getMaxZoomLevel();
//				}
//				controller.setZoom(zoomLevel);
//			}
//		});
//		btn04.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				zoomLevel--;
//				if(zoomLevel<1){
//					zoomLevel=1;
//				}
//				controller.setZoom(zoomLevel);
//			}
//		});
//	}
//
//	private void refreshMap() {
//		//��γ�ȳ���10��6�η�  ����geopoint����
//		GeoPoint point =new GeoPoint((int)(dLat*1E6),(int)(dLong*1E6));
//		controller.animateTo(point);  //�ƶ���������
//		controller.setZoom(zoomLevel);//��1��Լ22������  ����Խ�� �Ŵ��Խ��
//		//�������ǲ�
//		Overlay imageOverlay=new ImageOverlay(dLong, dLat, this);
//		//�ȵ���ǰ��ͼ��
//		List<Overlay> overlays=mapView.getOverlays();
//		//��ԭ����λ��ͼ�������
//		overlays.clear();
//		//�����µĸ��ǲ�
//		overlays.add(imageOverlay);
//	}
//
//	@Override
//	protected boolean isRouteDisplayed() {
//		return false;
//	}
//}
