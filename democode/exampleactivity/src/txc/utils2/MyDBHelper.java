package txc.utils2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
//创建完就调用oncrate方法
	public MyDBHelper(Context context, int version) {
		super(context, "contacts_db", null, version);
	}

	// 创建自动调用 初始化工作  db 在构造完后就会创建得到
	@Override
	public void onCreate(SQLiteDatabase db) {
		//第一个字段要是_id 整形
		String sql="create table contact("+"_id integer primary key autoincrement,"+
		"name text not null,tel text not null)";
		db.execSQL(sql);
		String insetSql1="insert into contact(name,tel) values(\"张三\",\"13812334556\")";
		String insetSql2="insert into contact(name,tel) values(\"张4\",\"13812334444\")";
		String insetSql3="insert into contact(name,tel) values(\"张5\",\"13812334555\")";
		String insetSql4="insert into contact(name,tel) values(\"张6\",\"13812336666\")";
		db.execSQL(insetSql1);
		db.execSQL(insetSql2);
		db.execSQL(insetSql3);
		db.execSQL(insetSql4);
	}

	// 更新的时候自动调用
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="drop table contact if exist";
		//删掉再复原 还原出厂值
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
