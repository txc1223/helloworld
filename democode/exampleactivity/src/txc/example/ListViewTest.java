package txc.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewTest extends Activity {
	private ListView lv;
	private String[] strs = { "zhang3", "li4", "wang5", "zhao6", "zhang3", "li4", "wang5", "zhao6", "zhang3", "li4", "wang5", "zhao6", "zhang3", "li4", "wang5", "zhao6" };
	private String[] phones = { "1111111111", "22222222222", "33333333333", "4444444444","1111111111", "22222222222", "33333333333", "4444444444" ,"1111111111", "22222222222", "33333333333", "4444444444","1111111111", "22222222222", "33333333333", "4444444444"};
	private int[] imgs = { android.R.drawable.alert_dark_frame, android.R.drawable.alert_light_frame, android.R.drawable.arrow_down_float, android.R.drawable.arrow_up_float, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		this.setTitle(title);
		lv = (ListView) findViewById(R.id.listview);
		setArrayAdapter();
		// setSimpleAdapter();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), strs[arg2] + "被选择", 0).show();
			}
		});
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

				Toast.makeText(getApplicationContext(), strs[arg2] + "刷listadapter", 0).show();
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < strs.length; i++) {
					list.add(strs[i]);
				}
				ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
				lv.setAdapter(adapter);
				// TODO Auto-generated method stub
				return false;
			}
		});
	}

	private void setArrayAdapter() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		// 不用设置下拉布局
		ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
		lv.setAdapter(adapter);
	}

	private void setSimpleAdapter() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < strs.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", strs[i]);
			map.put("phones", phones[i]);
			map.put("img", imgs[0]);
			data.add(map);
		}
		SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.complexlist, new String[] { "name", "phones", "img" }, new int[] { R.id.text1, R.id.text2, R.id.img });
		lv.setAdapter(sa);
	}
}
