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
//	private Location location;  //��ǰλ��
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
//		//ͨ�����õ�ǰ�����   �������� �õ�LocationManager  ʹ����ʵ�ֶ�λ
//		manager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
//		String provider=getProviderStr();
//		//�õ����һ����֪��λ�� �ϴζ�λ��λ��
//		location=manager.getLastKnownLocation(provider);
//		//ˢ�����ϴε�λ��
//		refreshMap1(location);
//		//����λ�� 
//		LocationListener listener=new LocationListener() {
//			//���ṩ��״̬�仯
//			@Override
//			public void onStatusChanged(String provider, int status, Bundle extras) {
//				// TODO Auto-generated method stub
//				
//			}
//			//���ṩ������
//			@Override
//			public void onProviderEnabled(String provider) {
//				// TODO Auto-generated method stub
//				
//			}
//			//���ṩ��������
//			@Override
//			public void onProviderDisabled(String provider) {
//				// TODO Auto-generated method stub
//				
//			}
//			//����λ�ñ仯ʱ���÷���
//			@Override
//			public void onLocationChanged(Location location) {
//				// TODO Auto-generated method stub
//				refreshMap1(location);
//			}
//		};
//		//λ�ø�������  �и��¾͸ı�   2000ˢ��ʱ��  10M��С�ı����  listener������  ����λ�õı仯
//		manager.requestLocationUpdates(provider, 2000, 10, listener);
//	}
//	//�õ�λ���ṩ��������
//	private String getProviderStr(){
//		//�ֻ����ж����ʽ���Զ�λ ���Ƕ�λ  �ƶ����綨λ ��Criteria�õ����������׼��ϵͳѡ���ĸ���λ
//		Criteria criteria=new Criteria();//�����õ�locationprovider��һ�������׼  
//		criteria.setAccuracy(Criteria.ACCURACY_FINE);//���ȱ�׼
//		criteria.setAltitudeRequired(false);   //Ҫ��Ҫ�õ��߶�ֵ
//		criteria.setCostAllowed(true);     //����ɲ����Ի�Ǯ��
//		
////		List<String> allPro=manager.getAllProviders();   �õ�����provider������
////		manager.getProvider("GPS");
//		
//		
//		//����1 ��������Ĳ�����׼�� ����2���ֻ��һ������ �ǲ���Ҫѡ���   �õ�λ���ṩ��������
//		String str=manager.getBestProvider(criteria, true);
//		System.out.println("λ���ṩ��������"+str);
//		return str;
//	}
//	private void refreshMap1(Location location){
//		//�п���locationΪ��ֵ  ��һ����λ�û򻺴涪ʧ
//		if(location==null)
//			return;
//		//locationתgeopoint
//		GeoPoint point=new GeoPoint((int)(location.getLatitude()*1E6),
//				(int)(location.getLongitude()*1E6));
//		controller.setZoom(16);
//		controller.animateTo(point);//�ƶ���point��
//		//��ʾ��γ��
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
