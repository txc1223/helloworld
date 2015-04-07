package txc.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FileAccessTest extends Activity {
	private Button btn01;
	private Button btn02;
	private Button btn03;
	private Button btn04;
	private Button btn05;
	private Button btn06;
	private ImageView img01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_access_test);
		btn01 = (Button) findViewById(R.id.file_access_btn_01);
		btn02 = (Button) findViewById(R.id.file_access_btn_02);
		btn03 = (Button) findViewById(R.id.file_access_btn_03);
		btn04 = (Button) findViewById(R.id.file_access_btn_04);
		btn05 = (Button) findViewById(R.id.file_access_btn_05);
		btn06 = (Button) findViewById(R.id.file_access_btn_06);
		img01 = (ImageView) findViewById(R.id.file_access_img_01);
		btn01.setOnClickListener(listener);
		btn02.setOnClickListener(listener);
		btn03.setOnClickListener(listener);
		btn04.setOnClickListener(listener);
		btn05.setOnClickListener(listener);
		btn06.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.file_access_btn_01:
				readAssetsFile();
				break;
			case R.id.file_access_btn_02:
				readSystemFile();
				break;
			case R.id.file_access_btn_03:
				writeSystemFile();
				break;
			case R.id.file_access_btn_04:
				readSDCardFile();
				break;
			case R.id.file_access_btn_05:
				writeSDCardFile();
				break;
			case R.id.file_access_btn_06:
				readSDCardImage();
				break;
			}
		}
	};
//访问assets文件夹下的文件
	private void readAssetsFile() {
		AssetManager as=this.getAssets();
		BufferedReader br;
		try {
			InputStream is=as.open("bir1"+File.separator+"text1");
			br=new BufferedReader(new InputStreamReader(is));
			StringBuffer sb=new StringBuffer();
			String str=null;
			while((str=br.readLine())!=null){
				sb.append(str+"\n");
			}
			br.close();
			Toast.makeText(this, sb.toString(), 2000).show();
		} catch (IOException e) {
			Log.e("FileAccessTest", e.toString());
			//e.printStackTrace();
		}
	}

	private void readSystemFile() {
		FileInputStream fis=null;
		BufferedReader br;
		//默认路径data/data/xxx本工程/files 
		try {
			fis=this.openFileInput("file02.txt");
			br=new BufferedReader(new InputStreamReader(fis));
			StringBuffer sb=new StringBuffer();
			String str=null;
			while((str=br.readLine())!=null){
				sb.append(str+"\n");
			}
			br.close();
			Toast.makeText(this, sb.toString(), 2000).show();
		} catch (Exception e) {
			Log.e("FileAccessTest", e.toString());
		}
	}

	private void writeSystemFile() {
		FileOutputStream fos=null;
		PrintWriter pw=null;
		try {
			//追加模式  模式可以累加
			//fos=this.openFileOutput("file02.txt", Context.MODE_APPEND);
			//私有
			fos=this.openFileOutput("file02.txt", Context.MODE_PRIVATE);
			pw=new PrintWriter(fos);
			pw.println("我的应用程序创建的文件：file02.txt");
			pw.flush();
			Toast.makeText(this, "complite", 2000).show();
			//全局可读
			//	fos=this.openFileOutput("file02.txt", Context.MODE_WORLD_READABLE);
				//全局可写
			//	fos=this.openFileOutput("file02.txt", Context.MODE_WORLD_WRITEABLE);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
			//fos.close();
		}
		
	}

	private void readSDCardFile() {
		FileInputStream fis=null;
		BufferedReader br;
		try {
			fis=new FileInputStream("/mnt/sdcard/android.txt.txt");
			br=new BufferedReader(new InputStreamReader(fis,"gbk"));
			StringBuffer sb=new StringBuffer();
			String str=null;
			int i=0;
			while((str=br.readLine())!=null){
				sb.append(str+"\n");
				i++;
				if(i>=3)
					break;
			}
			br.close();
			Toast.makeText(this, sb.toString(), 2000).show();
		} catch (Exception e) {
			Log.e("FileAccessTest", e.toString());
		}
	}

	private void writeSDCardFile() {
		FileOutputStream fos=null;
	}
	private void readSDCardImage() {
		FileInputStream fis=null;
		Bitmap bm;
		try {
			fis=new FileInputStream("mnt/sdcard/DCIM/Camera/Koala.jpg");
			bm=BitmapFactory.decodeStream(fis);
			img01.setImageBitmap(bm);
			img01.invalidate();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
