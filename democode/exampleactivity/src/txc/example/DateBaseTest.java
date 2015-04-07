package txc.example;

import txc.utils2.MyDBHelper;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DateBaseTest extends Activity {
	private ListView lv;
	private MyDBHelper helper;
	private Cursor cursor1;
	private EditText et01;
	private EditText et02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datebasetest);
		lv = (ListView) findViewById(R.id.datebase_text_lv);
		helper = new MyDBHelper(this, 1);
		// SQLiteDatabase db=helper.getReadableDatabase();
		SQLiteDatabase db1 = helper.getWritableDatabase();
		// Cursor cursor=db1.query("contact", new String[]{"name","tel"}, null,
		// null, null, null, null);
		// 一定要把_id查出来 显示可以不显示_id
		cursor1 = db1.rawQuery("select _id,name,tel from contact where _id>?",
				new String[] { "0" });
		refreshUI();
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				createSelectDialog(arg2);
				return false;
			}
		});
		// cursor1.move(offset);

		// if(cursor1.getCount()>0){
		// cursor1.moveToFirst();
		// do{
		// String name=cursor1.getString(0);
		// String tel=cursor1.getString(1);
		// Log.i("output","name:"+name+"tel:"+tel);
		// }while(cursor1.moveToNext());
		// }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "添加联系人");
		menu.add(0, 1, 1, "退出");
		menu.add(0, 2, 2, "--");

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			createAddContactDialog();
			break;
		case 1:
			this.finish();
			break;
		case 2:

			break;

		}
		return super.onOptionsItemSelected(item);
	}

	private void createAddContactDialog() {
		LayoutInflater inflater = getLayoutInflater();
		View view = inflater.inflate(R.layout.add_contact_dialog, null);// 根元素
		//要在对话框布局上找ID																// 可以空
		et01 = (EditText) view.findViewById(R.id.contact_name_et);
		et02 = (EditText) view.findViewById(R.id.contact_tel_et);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("添加联系人");

		builder.setView(view);
		builder.setPositiveButton("添加", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				String name = et01.getText().toString();
				String tel = et02.getText().toString();
				helper.insertContact(name, tel);
				refreshUI();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.show();
	}
//查询结果放到listview里
	private void refreshUI() {
		// 重新查询
		cursor1.requery();
		CursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.database_item, cursor1,
				new String[] { "name", "tel" }, new int[] { R.id.contact_name,
						R.id.contact_tel });
		lv.setAdapter(adapter);
	}
	private void createSelectDialog(final int index) {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("请选择要执行的操作");
		//message选项与单选对话框冲突！！
		//builder.setMessage("请选择");
		//选择列表  进去后被选的编号-1为没选 监听器用来关闭对话框 若果有确定和取消则不用设；
		builder.setSingleChoiceItems(new String[]{"删除","修改"}, -1,
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.setPositiveButton("确定",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//要销毁
						dialog.dismiss();
						switch(which){
						case 0:
							
							break;
						case 1:
							break;
						}
					}
				});
		builder.create().show();
	}
}
