package txc.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class URLConnectionTest extends Activity {
	private EditText et;
	private TextView tv;
	private Button btn;
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.url_connection_test);
		et=(EditText)findViewById(R.id.urlconnection_et);
		tv=(TextView)findViewById(R.id.urlconnection_tv);
		btn=(Button)findViewById(R.id.urlconnection_btn);
		iv=(ImageView)findViewById(R.id.urlconnection_iv);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					URL url=new URL(et.getText().toString().trim());
					HttpURLConnection conn=(HttpURLConnection)url.openConnection();
					//建立连接 判断状态
					conn.connect();
					//文本资源
				//	getTextData(conn);
					//得到图片资源
						getBitmap(conn);
					//关闭连接
					conn.disconnect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
	}
	private void getTextData(HttpURLConnection conn) throws IOException{
		if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
			//文本数据
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str=null;
			while((str=br.readLine())!=null){
				tv.append(str+"\n");
			}
		}else{
			tv.setText("connect_err");
			Toast.makeText(URLConnectionTest.this, "err", 2000).show();
		}
	}
	private void getBitmap(HttpURLConnection conn) throws Exception{
		if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
			Bitmap map=BitmapFactory.decodeStream(conn.getInputStream());
			iv.setImageBitmap(map);
		}else{
			iv.setImageResource(R.drawable.ic_launcher);
		}
	}
}
