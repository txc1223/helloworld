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
//	 * 地图上的覆盖层
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
//		//得到坐标的图片
//		bitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
//	}
////画布  组件  遮盖的模式  毫秒数（重复绘画）
//	public boolean draw(Canvas canvas, MapView mapView, boolean shadow,
//			long when) {
//		// TODO Auto-generated method stub
//		if(shadow==false){
//			//把地理坐标投影到屏幕上
//			Projection projection=mapView.getProjection();
//			GeoPoint geoPoint= new GeoPoint((int)(dLat*1E6),(int)(dLong*1E6));
//			//屏幕坐标
//			Point point=new Point();
//			//利用投影方法  转换2个值  使Point里有了XY坐标
//			projection.toPixels(geoPoint, point);
//			Rect src=new Rect(0,0,50,50); //图的大小
//			//定义图标中点
//			Rect dst=new Rect(point.x-25,point.y-25,point.x+25,point.y+25);		//目标区域 
//			//第2个参数代表显示bitmap的哪部分，第3个参数是屏幕上现在在哪个区域里；坐标为左上角到右下角
//			//paint不用 ；
//			Paint paint=new Paint();
//			//画布开画
//			canvas.drawBitmap(bitmap,src ,dst,paint );
//		}
//		return super.draw(canvas, mapView, shadow, when);
//	}
//
//}
