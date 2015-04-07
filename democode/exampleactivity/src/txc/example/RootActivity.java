package txc.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RootActivity extends Activity {
	//private Button [] btns;
	private ListView listView=null;
	private Class[] cc={ListViewTest.class,GridViewTest.class,PullToRefreshGridViewActivity.class,SpinnerTest.class,OtherViewTest.class,
			MessageHandlerTest.class,MenuAndDialogTest.class,AnimationTest.class,FramAnimationTest.class,
			FileAccessTest.class,DateBaseTest.class,SocketTest.class,LoginActivity.class,
			URLConnectionTest.class,WebViewTest.class,TelephonyServiceTest.class,
			ReadContactActivity.class,ServiceTest.class,
			BroadcastReceiverTest.class,//GoogleMapAPITest.class,
			SensorTest.class,CustomSelectTest.class};
	private String[] btn_strs={
			"ListViewTest","GridViewTest测试","PullToRefreshGridViewActivity测试","SpinnerTest测试","OtherViewTest测试","MessageHandlerTest测试"
			,"MenuAndDialogTest测试","AnimationTest测试","FramAnimationTest测试","FileAccessTest测试",
			"DateBaseTest测试","SocketTest测试","LoginActivity测试","URLConnectionTest测试",
			"WebViewTest测试","TelephonyServiceTest测试","ReadContactActivity测试","ServiceTest测试",
			"BroadcastReceiverTest测试",//"GoogleMapAPITest����",
			"SensorTest测试","CustomSelectTest测试"
	};
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.rootactivity);
	listView=(ListView)findViewById(R.id.rootlistview);
	listView.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
		Intent intent=new Intent(getApplicationContext(),cc[arg2]);
		intent.putExtra("title", btn_strs[arg2]);
		startActivity(intent);
		}
	});
	List<String> list=new ArrayList<String>();
	for (int i = 0; i < btn_strs.length; i++) {
		list.add(btn_strs[i]);
	}
	ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
	listView.setAdapter(adapter);
}
}
