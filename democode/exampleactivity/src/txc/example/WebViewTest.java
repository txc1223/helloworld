package txc.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewTest extends Activity {
	private EditText et;
	private Button btn;
	private WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewtest);
		et=(EditText)findViewById(R.id.web_urlconnection_et);
		btn=(Button)findViewById(R.id.web_urlconnection_btn);
		wv=(WebView)findViewById(R.id.web_urlconnection_wv);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				wv.loadUrl(et.getText().toString().trim());
				//处理用户请求
				wv.setWebViewClient(new WebViewClient());
			}
		});
	}
}
