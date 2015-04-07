package txc.utils2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
//������͵���oncrate����
	public MyDBHelper(Context context, int version) {
		super(context, "contacts_db", null, version);
	}

	// �����Զ����� ��ʼ������  db �ڹ������ͻᴴ���õ�
	@Override
	public void onCreate(SQLiteDatabase db) {
		//��һ���ֶ�Ҫ��_id ����
		String sql="create table contact("+"_id integer primary key autoincrement,"+
		"name text not null,tel text not null)";
		db.execSQL(sql);
		String insetSql1="insert into contact(name,tel) values(\"����\",\"13812334556\")";
		String insetSql2="insert into contact(name,tel) values(\"��4\",\"13812334444\")";
		String insetSql3="insert into contact(name,tel) values(\"��5\",\"13812334555\")";
		String insetSql4="insert into contact(name,tel) values(\"��6\",\"13812336666\")";
		db.execSQL(insetSql1);
		db.execSQL(insetSql2);
		db.execSQL(insetSql3);
		db.execSQL(insetSql4);
	}

	// ���µ�ʱ���Զ�����
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="drop table contact if exist";
		//ɾ���ٸ�ԭ ��ԭ����ֵ
		db.execSQL(sql);
		onCreate(db);
	}
	public void insertContact(String name,String tel){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues content=new ContentValues();
		content.put("name", name);
		content.put("tel", tel);
		db.insert("contact", null, content);
	}
	public void delte(String name,String tel){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues content=new ContentValues();
		content.put("name", name);
		content.put("tel", tel);
		db.insert("contact", null, content);
	}
	public void update(String name,String tel){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues content=new ContentValues();
		content.put("name", name);
		content.put("tel", tel);
		db.insert("contact", null, content);
	}
}
