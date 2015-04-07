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
//public class SearchLocActivity extends MapActivity {// 要继承MapActivity
//	private EditText dLongEdit, dLatEdit;
//
//	private MapView mapView;
//
//	private Button btn01;
//	private Button btn02;
//	private Button btn03;
//	private Button btn04;
//	// 初始的经纬度坐标，天安门广场的坐标  默认值
//	private double dLong = 116.41234;
//	private double dLat = 39.91234;
//	private MapController controller;  //实现对地图的更新 控制以及相应的移动
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
//		//得到controller地图控制器
//		controller=mapView.getController();
//		refreshMap();
//		
//		btn01.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				if(dLongEdit.getText().toString().trim().equals("")||
//						dLatEdit.getText().toString().trim().equals("")){
//					Toast.makeText(SearchLocActivity.this, "无效经纬度", 2000).show();
//					return;
//				}
//				//获得文本框内坐标  然后刷新
//				dLong=Double.parseDouble(dLongEdit.getText().toString().trim());
//				dLat=Double.parseDouble(dLatEdit.getText().toString().trim());
//				refreshMap();
//			}
//		});
//		btn02.setOnClickListener(new OnClickListener() {
//			//模式转换  实现卫星街道查询
//			@Override
//			public void onClick(View v) {
//				Button btn=(Button)v;
//				if(btn.getText().equals("卫星")){
//					mapView.setSatellite(true);
//					btn.setText("街道");
//				}else if(btn.getText().equals("街道")){
//					mapView.setSatellite(false);
//					btn.setText("卫星");
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
//		//经纬度乘以10的6次方  构建geopoint对象
//		GeoPoint point =new GeoPoint((int)(dLat*1E6),(int)(dLong*1E6));
//		controller.animateTo(point);  //移动到该坐标
//		controller.setZoom(zoomLevel);//从1到约22的整数  数字越大 放大的越大
//		//创建覆盖层
//		Overlay imageOverlay=new ImageOverlay(dLong, dLat, this);
//		//等到当前的图层
//		List<Overlay> overlays=mapView.getOverlays();
//		//把原来的位置图层清理掉
//		overlays.clear();
//		//加入新的覆盖层
//		overlays.add(imageOverlay);
//	}
//
//	@Override
//	protected boolean isRouteDisplayed() {
//		return false;
//	}
//}
