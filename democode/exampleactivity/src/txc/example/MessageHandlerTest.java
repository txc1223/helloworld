package txc.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MessageHandlerTest extends Activity {
	private TextView tv;
	private ProgressBar pb;
	private String[] texts={"正在启动程序。。。","正在连接服务器。。。。",
			"正在更新数据。。。","正在加载本地缓存。。。",
			"正在比较数据版本。。。","正在备份日志。。。","正在开始程序。。。"};
	private Handler handler;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.messagehandler);
	tv=(TextView)findViewById(R.id.testview);
	pb=(ProgressBar)findViewById(R.id.progressbar);
	handler=new Handler(){
		@Override
		public void handleMessage(android.os.Message msg) {
			Bundle bun=msg.getData();
			int i=bun.getInt("value");
			tv.setText(texts[i/15]);
		}
	};
	new Thread(){
		public void run() {
			for (int i = 0; i <=100; i++) {
				pb.setProgress(i);
				Message message=new Message();
				Bundle bun=new Bundle();
				bun.putInt("value", i);
				message.setData(bun);
				handler.sendMessage(message);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}.start();
}

}
