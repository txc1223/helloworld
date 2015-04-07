package txc.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SocketTest extends Activity {
	private EditText et;
	private Button btn;
	private TextView tv,tv2;
	private Socket s;
	private BufferedReader br=null;
	private PrintWriter pw;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.socket_test);
		et=(EditText)findViewById(R.id.socket_et);
		btn=(Button)findViewById(R.id.socket_btn);
		tv=(TextView)findViewById(R.id.socket_tv);
		tv2=(TextView)findViewById(R.id.socket_tv2);
		showDialog();
		try {
			createSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		handler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				//super.handleMessage(msg);
				tv.append(msg.getData().getString("message")+"\n");
				
			}
		};
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String str=send(et.getText().toString());
				String tv2Text=tv2.getText().toString();
				String etText=et.getText().toString();
				pw.println(tv2Text+":"+etText);
				//tv.setText(str);
				pw.flush();
				et.setText("");
			}
		});
		new Thread(){
			public void run() {
				while(true){
					String str="";
					try {
						str = br.readLine();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Message msg=new Message();
					Bundle data=new Bundle();
					data.putString("message", str);
					msg.setData(data);
					handler.sendMessage(msg);
					
				}
			}
		}.start();
	}
	//对话框得到用户名
	private void showDialog(){
		AlertDialog.Builder builder=new Builder(this);
		builder.setTitle("请输入姓名");
		final EditText et1=new EditText(this);
		builder.setView(et1);
		builder.setPositiveButton("确定", new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				tv2.setText(et1.getText().toString());
			}
		});
		builder.setNegativeButton("取消",new AlertDialog.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.show();
	}
	private void createSocket() throws IOException{
		s=new Socket("192.168.1.3",8189);
		pw=new PrintWriter(s.getOutputStream());
		System.out.println(pw.toString()+"----pw----");
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(br.toString()+"----bu----");
	}
	private String send(String mesg){
		try {
			pw.print(mesg);
			pw.flush();
			String str=br.readLine();
			System.out.println(str);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果异常则返回空
		return null;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0,0,0,"退出");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case 0:
			exit();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	//退出
	private void exit(){
		pw.print(tv2.getText()+":%EXIT%");
		pw.flush();
		
		try {
			Thread.sleep(800);
			s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.finish();
	}
}
