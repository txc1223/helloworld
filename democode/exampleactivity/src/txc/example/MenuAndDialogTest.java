package txc.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuAndDialogTest extends Activity {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menudialog);
//		Button btn=new Button(this);
//		LinearLayout ll=new LinearLayout(this);
//		ll.setOrientation(LinearLayout.HORIZONTAL);
		btn1 = (Button) findViewById(R.id.button31);
		btn2 = (Button) findViewById(R.id.button32);
		btn3 = (Button) findViewById(R.id.button33);
		btn4 = (Button) findViewById(R.id.button34);
		btn5 = (Button) findViewById(R.id.button35);
		btn6 = (Button) findViewById(R.id.button36);
		btn7 = (Button) findViewById(R.id.button37);
		btn8 = (Button) findViewById(R.id.button38);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_01();
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_02();
			}
		});
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_03();
			}
		});
		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_04();
			}
		});
		btn5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_05();
			}
		});
		btn6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_06();
			}
		});
		btn7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_07();
			}
		});
		btn8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createDialog_08();
			}
		});
	}

	private void createDialog_02() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("选择对话框");
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MenuAndDialogTest.this, "确定被点击", 0).show();
					}
				});
		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MenuAndDialogTest.this, "取消被点击", 0).show();
					}
				});
		builder.setMessage("这是一个选择对话框！");
		builder.create().show();
	}
	private void createDialog_01() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("消息对话框");
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
		builder.setMessage("这是一个消息对话框！");
		builder.create().show();
	}
	private void createDialog_03() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("输入对话框");
		final EditText et=new EditText(this);
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MenuAndDialogTest.this, "输入的值为："+et.getText(), 0).show();
					}
				});
		builder.setView(et);
		builder.setMessage("请输入参数");
		builder.create().show();
	}
	private void createDialog_04() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("单选对话框");
		
		
		//message选项与单选对话框冲突！！
		//builder.setMessage("请选择");
		//选择列表  进去后被选的编号-1为没选 监听器用来关闭对话框 若果有确定和取消则不用设；
		builder.setSingleChoiceItems(new String[]{"zhang3","li4","wang5","zhao6"}, -1,
				new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
		builder.create().show();
	}
	private void createDialog_05() {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("多选对话框");
		builder.setMultiChoiceItems(new String[]{"zhangsan","li4","wang5","zhao6"}, 
				new boolean[]{true,false,true,false}, new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						
					}
				});
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
		//builder.setMessage("这是一个多选对话框！");
		builder.create().show();
	}
	private void createDialog_06() {
		ProgressDialog pd=new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setTitle("环形进度条对话框");
		pd.setIcon(R.drawable.ic_launcher);
		pd.setProgress(40);
		pd.setCancelable(true);
		pd.setButton("canel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		pd.show();
	}
	private void createDialog_07() {
		 final ProgressDialog pd=new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setTitle("水平进度条对话框");
		pd.setIcon(R.drawable.ic_launcher);
		new Thread(){
			public void run() {
				for (int i = 0; i <=100; i++) {
					pd.setProgress(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		pd.setProgress(60);
		//pd.setCancelable(true);
		pd.show();
	}
	private void createDialog_08() {
		LayoutInflater inflater=getLayoutInflater();
		View view= inflater.inflate(R.layout.mydialog, null);//根元素 可以空
		new AlertDialog.Builder(this).setTitle("自定义对话框").setView(view).show();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(getApplicationContext(), item.getTitle() + "被点击", 1)
					.show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), item.getTitle() + "被点击", 1)
					.show();
			break;
		case 3:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 组编号 组件号 排列号 内容
		menu.add(0, 1, 1, "帮助");
		menu.add(0, 2, 2, "关于");
		menu.add(0, 3, 3, "退出");
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
}
