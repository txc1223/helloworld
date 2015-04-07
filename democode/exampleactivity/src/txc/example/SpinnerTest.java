package txc.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerTest extends Activity {
	private Spinner sp_01;
	private Spinner sp_02;
	private String[] text = { "����", "����1", "����2", "����3", "����4" };
	private String[][] cities = { { "1" }, { "2", "3" }, { "4", "5" },
			{ "6", "7" }, { "8", "9" } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_test);
		Intent intent=getIntent();
		String title=intent.getStringExtra("title");
		this.setTitle(title);
		sp_01 = (Spinner) findViewById(R.id.spinner01);
		sp_02 = (Spinner) findViewById(R.id.spinner02);
		setArrayAdpter();
		//ͨ��ı��һ���б� �ı�ڶ��������б�
		sp_01.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				setAdapterForSP2(arg2);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}
	private void setAdapterForSP2(int index) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < cities[index].length; i++) {
			list.add(cities[index][i]);
		}
		ArrayAdapter adapter3 = new ArrayAdapter(SpinnerTest.this,
				android.R.layout.simple_spinner_item, list);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_02.setAdapter(adapter3);
	}
	private void setArrayAdpter() {
		List<String> list1 = new ArrayList<String>();
		list1.add("11");
		list1.add("111");
		list1.add("112");
		list1.add("113");
		list1.add("114");
		ArrayAdapter adapter1 = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, list1);
		adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
		sp_01.setAdapter(adapter1);
		setAdapterForSP2(0);
	}
}
