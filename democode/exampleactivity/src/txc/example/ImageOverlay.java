//package txc.example;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Point;
//import android.graphics.Rect;
//
//import com.google.android.maps.GeoPoint;
//import com.google.android.maps.MapView;
//import com.google.android.maps.Overlay;
//import com.google.android.maps.Projection;
//
//public class ImageOverlay extends Overlay {
//	/**
//	 * ��ͼ�ϵĸ��ǲ�
//	 * 
//	 */
//	private double dLong;
//	private double dLat;
//	private Bitmap bitmap;
//	private Context context;
//	public ImageOverlay(double dLong, double dLat,Context context) {
//		super();
//		this.dLong = dLong;
//		this.dLat = dLat;
//		this.context = context;
//		//�õ������ͼƬ
//		bitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
//	}
////����  ���  �ڸǵ�ģʽ  ���������ظ��滭��
//	public boolean draw(Canvas canvas, MapView mapView, boolean shadow,
//			long when) {
//		// TODO Auto-generated method stub
//		if(shadow==false){
//			//�ѵ�������ͶӰ����Ļ��
//			Projection projection=mapView.getProjection();
//			GeoPoint geoPoint= new GeoPoint((int)(dLat*1E6),(int)(dLong*1E6));
//			//��Ļ����
//			Point point=new Point();
//			//����ͶӰ����  ת��2��ֵ  ʹPoint������XY����
//			projection.toPixels(geoPoint, point);
//			Rect src=new Rect(0,0,50,50); //ͼ�Ĵ�С
//			//����ͼ���е�
//			Rect dst=new Rect(point.x-25,point.y-25,point.x+25,point.y+25);		//Ŀ������ 
//			//��2������������ʾbitmap���Ĳ��֣���3����������Ļ���������ĸ����������Ϊ���Ͻǵ����½�
//			//paint���� ��
//			Paint paint=new Paint();
//			//��������
//			canvas.drawBitmap(bitmap,src ,dst,paint );
//		}
//		return super.draw(canvas, mapView, shadow, when);
//	}
//
//}
