/** 
 * @Class: CustomSelectActivity.java
 * @description:TODO
 * @version:V1.0 
 * @author:txc
 * @mail:txc1223@163.com  
 * @date:2012-5-16 下午02:09:22 
 * 
 */
package txc.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

/**
 * 自定义的一个下拉菜单组建
 * @Class: CustomSelectActivity.java
 * @description:TODO
 * @version:V1.0
 * @author:txc
 * @mail:txc1223@163.com
 * @date:2012-5-16 下午02:09:22
 * 
 */

public class CustomSelectTest extends Activity {
	private txc.commponent.CustomSelect selectCalendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_select);
		selectCalendar = (txc.commponent.CustomSelect) findViewById(R.id.tvMyTitle);
		// 设置适配器
		selectCalendar.setAdapter(new ArrayAdapter<String>(this, R.layout.calendar_day_list_item, new String[] { "我的选项1", "我的选项2" })); // 日程主界面的标题事件
		// 設置寬度
		selectCalendar.setCustomSelectwidth(150);
		selectCalendar.setOnIitemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			}
		});
	}
}
