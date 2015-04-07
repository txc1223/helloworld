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
		// һ��Ҫ��_id����� ��ʾ���Բ���ʾ_id
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
		menu.add(0, 0, 0, "�����ϵ��");
		menu.add(0, 1, 1, "�˳�");
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
		View view = inflater.inflate(R.layout.add_contact_dialog, null);// ��Ԫ��
		//Ҫ�ڶԻ��򲼾�����ID																// ���Կ�
		et01 = (EditText) view.findViewById(R.id.contact_name_et);
		et02 = (EditText) view.findViewById(R.id.contact_tel_et);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("�����ϵ��");

		builder.setView(view);
		builder.setPositiveButton("���", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				String name = et01.getText().toString();
				String tel = et02.getText().toString();
				helper.insertContact(name, tel);
				refreshUI();
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.show();
	}
//��ѯ����ŵ�listview��
	private void refreshUI() {
		// ���²�ѯ
		cursor1.requery();
		CursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.database_item, cursor1,
				new String[] { "name", "tel" }, new int[] { R.id.contact_name,
						R.id.contact_tel });
		lv.setAdapter(adapter);
	}
	private void createSelectDialog(final int index) {
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("��ѡ��Ҫִ�еĲ���");
		//messageѡ���뵥ѡ�Ի����ͻ����
		//builder.setMessage("��ѡ��");
		//ѡ���б�  ��ȥ��ѡ�ı��-1Ϊûѡ �����������رնԻ��� ������ȷ����ȡ�������裻
		builder.setSingleChoiceItems(new String[]{"ɾ��","�޸�"}, -1,
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.setPositiveButton("ȷ��",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Ҫ����
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
