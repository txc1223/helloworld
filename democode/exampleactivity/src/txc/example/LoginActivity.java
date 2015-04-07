package txc.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText et01,et02;
	private Button btn01,btn02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		et01=(EditText)findViewById(R.id.username_et);
		et02=(EditText)findViewById(R.id.password_et);
		btn01=(Button)findViewById(R.id.login_btn);
		btn02=(Button)findViewById(R.id.cancel_btn);
		btn01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
//					String result=sendGetRequest(et01.getText().toString().trim(),
//							et02.getText().toString().trim()).trim();
					String result=sendPostRequest(et01.getText().toString().trim(),
							et02.getText().toString().trim()).trim();
					if(result.equals("logn_ok")){
						Intent intent=new Intent(LoginActivity.this,RootActivity.class);
						startActivity(intent);
						LoginActivity.this.finish();
					}
				} catch (Exception e) {
					Log.e("LoginActivity", e.toString());
				}
			}
		});
	}
	private String sendGetRequest(String userNmae,String password) throws Exception{
		String url="http://192.168.1.3:8088/login_servlet/login?username="
			+userNmae+"&password="+password;
		String respStr=null;
		HttpClient client=new DefaultHttpClient();
		HttpGet request=new HttpGet(url);
		HttpResponse resp=client.execute(request);
		//状态编码200为正常
		if(resp.getStatusLine().getStatusCode()==200){
			//解析resp成字符串
			respStr=EntityUtils.toString(resp.getEntity());
			Toast.makeText(this, respStr, 2000).show();
			//得到图像输入流!!!
//			InputStream is=resp.getEntity().getContent();
//			Bitmap map=BitmapFactory.decodeStream(is);
//			ImageView iv=null;
//			iv.setImageBitmap(map);
			//用webview得到图像
//			WebView wv;
//			wv.loadUrl(url);
			return respStr;
		}
		return "request_err";
	}
private String sendPostRequest(String userNmae,String password) throws Exception{
	String respStr=null;
	HttpClient client=new DefaultHttpClient();
	
	//post操作方式  封装参数部分不一样
	HttpPost request=new HttpPost("http://192.168.1.3:8088/login_servlet/login");
	//设置post的参数
	List<NameValuePair> params=new ArrayList<NameValuePair>();
	NameValuePair nvp1=new BasicNameValuePair("username", userNmae);
	NameValuePair nvp2=new BasicNameValuePair("password", password);
	params.add(nvp1);
	params.add(nvp2);
	//编码到数据包里
	request.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
	
	
	HttpResponse resp=client.execute(request);
	if(resp.getStatusLine().getStatusCode()==200){
		//解析resp成字符串
		respStr=EntityUtils.toString(resp.getEntity());
		Toast.makeText(this, respStr, 2000).show();
		return respStr;
	}
	return "request_err";
}
}
