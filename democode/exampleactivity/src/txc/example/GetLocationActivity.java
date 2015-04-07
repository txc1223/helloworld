//package txc.example;
//
//import java.util.List;
//
//import android.content.Context;
//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.widget.TextView;
//
//import com.google.android.maps.GeoPoint;
//import com.google.android.maps.MapActivity;
//import com.google.android.maps.MapController;
//import com.google.android.maps.MapView;
//
//public class GetLocationActivity extends MapActivity {
//	private TextView tv1,tv2,tv3;
//	private MapView mapView;
//	private LocationManager manager;
//	private Location location;  //当前位置
//	private MapController controller;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.getlocation);
//		tv1=(TextView)findViewById(R.id.getlocation_tv01);
//		tv2=(TextView)findViewById(R.id.getlocation_tv02);
//		tv3=(TextView)findViewById(R.id.getlocation_tv03);
//		mapView=(MapView)findViewById(R.id.getlocation_map01);
//		
//		controller=mapView.getController();
//		//通过调用当前活动服务   传进类型 得到LocationManager  使用他实现定位
//		manager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
//		String provider=getProviderStr();
//		//得到最后一个已知的位置 上次定位的位置
//		location=manager.getLastKnownLocation(provider);
//		//刷新下上次的位置
//		refreshMap1(location);
//		//更新位置 
//		LocationListener listener=new LocationListener() {
//			//当提供器状态变化
//			@Override
//			public void onStatusChanged(String provider, int status, Bundle extras) {
//				// TODO Auto-generated method stub
//				
//			}
//			//当提供器可用
//			@Override
//			public void onProviderEnabled(String provider) {
//				// TODO Auto-generated method stub
//				
//			}
//			//当提供器不可用
//			@Override
//			public void onProviderDisabled(String provider) {
//				// TODO Auto-generated method stub
//				
//			}
//			//地理位置变化时调用方法
//			@Override
//			public void onLocationChanged(Location location) {
//				// TODO Auto-generated method stub
//				refreshMap1(location);
//			}
//		};
//		//位置更新请求  有更新就改变   2000刷新时间  10M最小改变距离  listener监听器  监听位置的变化
//		manager.requestLocationUpdates(provider, 2000, 10, listener);
//	}
//	//得到位置提供器的名字
//	private String getProviderStr(){
//		//手机里有多个方式可以定位 卫星定位  移动网络定位 用Criteria得到这个参数标准由系统选用哪个定位
//		Criteria criteria=new Criteria();//用来得到locationprovider的一组参数标准  
//		criteria.setAccuracy(Criteria.ACCURACY_FINE);//精度标准
//		criteria.setAltitudeRequired(false);   //要不要得到高度值
//		criteria.setCostAllowed(true);     //定义可不可以花钱；
//		
////		List<String> allPro=manager.getAllProviders();   得到所有provider的名字
////		manager.getProvider("GPS");
//		
//		
//		//参数1 给他定义的参数标准， 参数2如果只有一个满足 是不是要选这个   得到位置提供器的名称
//		String str=manager.getBestProvider(criteria, true);
//		System.out.println("位置提供器的名字"+str);
//		return str;
//	}
//	private void refreshMap1(Location location){
//		//有可能location为空值  第一次找位置或缓存丢失
//		if(location==null)
//			return;
//		//location转geopoint
//		GeoPoint point=new GeoPoint((int)(location.getLatitude()*1E6),
//				(int)(location.getLongitude()*1E6));
//		controller.setZoom(16);
//		controller.animateTo(point);//移动到point点
//		//显示经纬度
//		tv1.setText(location.getLongitude()+"");
//		tv2.setText(location.getLatitude()+"");
//		
//	}
//	@Override
//	protected boolean isRouteDisplayed() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
