package txc.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class GridViewTest extends Activity {
	private GridView gv;
	private String[] strs={"bottom_bar","btn_default","btn_default_small","btn_dialog","btn_dropdown",
			"btn_minus","btn_plus","btn_radio"};
	private int[] img={android.R.drawable.bottom_bar,android.R.drawable.btn_default,
			android.R.drawable.btn_default_small,android.R.drawable.btn_dialog,
			android.R.drawable.btn_dropdown,android.R.drawable.btn_minus,
			android.R.drawable.btn_plus,android.R.drawable.btn_radio};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewtest);
		Intent intent=getIntent();
		String title=intent.getStringExtra("title");
		this.setTitle(title);
		gv = (GridView) findViewById(R.id.grid1);
		setAdapter();
		setListener();
	}

	private void setAdapter() {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < strs.length; i++) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("name", strs[i]);
			map.put("img", img[i]);
			list.add(map);
		}
		SimpleAdapter sa=new SimpleAdapter(getApplicationContext(),list,R.layout.gridviewitem,new String[]{"name","img"},
				new int[]{R.id.text,R.id.img});
		gv.setAdapter(sa);
	}
	private void setListener(){
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				System.out.println(arg2+"======");
				Toast.makeText(getApplicationContext(), strs[arg2]+"±»µã»÷ÁË", 0).show();
			}
		});
	}
}
