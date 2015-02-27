package com.example.helloworld.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.helloworld.R;







/**
 * AppUpdate.java<br/>
 * Date:2011-12-28 <br/>
 * Author:XiaoXia <br/>
 * Version:v1.0 <br/>
 * Title: apk更新类
 */
public class Downloader {
	// 已经下载的大小
	private int count = -1;
	// 文件大小
	private int length = -1;
	// 保存的名字
	private String downLoadName;
	// 保存的File对象
	private File file = null;
	// 下载线程是否停止
	private boolean isStop = false;
	// android 通知
	private Notification notification;
	private NotificationManager notificationManager;
	// Notification id 
	private int id = 1111;
	// activity对象
	//private Activity activity;
	Context context;
	
	private int downloadFlag = 0;
	
	// 版本
	//private int version;
	// 下载的url
	private String url;
	// 提示对话框
//	private AlertDialog dialog = null;*/
	private OnDownloadRateChangeListener changeListener;
	
	private Thread downloadThread;
	private Thread uiThread;
	
	//private PluginInfo pluginInfo;
	
	
	

	/*public PluginDownload(Activity activity, final int version, String url,String apkName) {

		//this.activity = activity;
		//this.version = version;
		this.url = url;
		downLoadName = apkName  + ".apk";
		initNotifi();
		//startDownlod();
	}*/
	
	public Downloader(Context context,  String path) {
		this.context = context;
//		pluginInfo = pi;
		//this.version = version;
		this.url = path;
		
		downLoadName = path.substring(path.lastIndexOf("/")) ;
		initNotifi();		
		//startDownlod();
	}
	

	private void initNotifi() {
		// 初始化notification的一些信息，包括，显示的文字，进度条以及百分比
		notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notification = new Notification(R.drawable.ic_launcher, "正在下载...", System.currentTimeMillis());
		notification.icon = R.drawable.ic_launcher;
		notification.contentView = new RemoteViews(((Context) context).getApplicationContext().getPackageName(), R.layout.app_update_notification);
		notification.contentView.setProgressBar(R.id.progressBar1, 100, 0, false);
		notification.contentView.setTextViewText(R.id.textView1, "已下载(0%)");
		notification.contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, this.getClass()), 0);
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 * @param file
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private void download(String url, File file) throws MalformedURLException, IOException {
		// http下载,配置一下
		HttpURLConnection urlConnection = (HttpURLConnection) (new URL(url)).openConnection();
		urlConnection.setRequestMethod("GET");
		// urlConnection.setDoOutput(true);//将导致请求以post方式提交,即使设置了httpCon.setRequestMethod("GET");
		urlConnection.connect();
		FileOutputStream fileOutput;
		InputStream inputStream;
		fileOutput = new FileOutputStream(file);
		inputStream = urlConnection.getInputStream();
		length = urlConnection.getContentLength(); // 文件的总大小
		byte[] buffer = new byte[1024];
		int bufferLength = 0;
		count = 0; // 已经下载的大小，用于判断下载进度
		while ((bufferLength = inputStream.read(buffer)) > 0) {
			fileOutput.write(buffer, 0, bufferLength);
			count = count + bufferLength;
		}
		fileOutput.close();
		
	}
	
	public void setOnDownloadRateChangeListener(OnDownloadRateChangeListener listener){
		this.changeListener = listener;
	}

	/**
	 * 获取 下载文件的位置，在有sdcard的情况，放在/sdcard/Smartbox/update/smartbox.apk
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	private File getDownloadFile(String name) throws Exception {
		// 判断是否有sdcard
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File path = new File(Environment.getExternalStorageDirectory().getPath() + "/minhang/update");
			if (!path.exists()) {
				path.mkdirs();
			}
			return new File(path, name);
		} else {
			throw new Exception("无sdcard?");
		}
	}

	/**
	 * 已经下载的百分比
	 * 
	 * @return 返回百分比，如果是45%，则返回为45
	 */
	private int downLoadRate() {
		if (length == -1 || length == 0 || count == -1 || count == 0) {
			return 0;
		} else {
			return (int) (100 * (count * 1.0 / length));
		}
	}

	/**
	 * 更新的主接口
	 * 
	 * @throws Exception
	 */
/*	public void updateApp() {
		try {
			// 判断是否已经显示
			if (dialog == null || !dialog.isShowing()) {
				final PackageManager pm = activity.getPackageManager();
				PackageInfo piSelf = pm.getPackageInfo(activity.getPackageName(), 0);
				if (piSelf.versionCode >= version) {// 如果当前版本比服务的版本大或者相等，则不要更新
					return;
				}
				Builder builder = new Builder(activity);
				builder.setTitle(activity.getString(R.string.update_title));
				builder.setMessage(activity.getString(R.string.update_message));
				// 取消下载
				builder.setNegativeButton(activity.getString(R.string.update_cancel), new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				// 确定下载
				builder.setPositiveButton(activity.getString(R.string.update_ok), new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						doUpdate();
					}
				});
	
				dialog = builder.create();
				dialog.show();
			}
		} catch (Exception e) {
			
		}
	}*/

	/**
	 * 开始下载
	 */
	public void startDownlod() {
		// 1、获取应该保存文件的路径
		// 2、如果文件存在，则说明已经下过了，
		// 3、如果这个文件是apk文件，则判断是否可以安装，否则的话则删除文件
		// 4、启动一个下载线程下载文件
		// 5、启动一个刷新线程，然后通过handler通知主线程的notification更新进度条
		// 6、如果下载线程，完成下载，则通知界面，否是安装下载的文件
		//pluginInfo.changeStatus(PluginInfo.INSTALLING);		
		downloadFlag = 0;
		
			try {
				file = getDownloadFile(downLoadName);
			} catch (Exception e) {
				Log.e("test_download", "",e);
			}
			/*	if (file.exists()) {
								PackageManager pm = activity.getPackageManager();
				PackageInfo piNew = pm.getPackageArchiveInfo(file.getPath(), 0);
				if (piNew != null) {
					if (piNew.versionCode == version) {// 本地的文件与服务器的版本相等，说明已经下载了，
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
						activity.startActivity(intent);
						return;
					} else {// 本地的文件与服务器的版本不相符，删除本地文件
						file.delete();
					}*/
				
			
		 
		// 下载线程
			downloadThread = new Thread() {
			public void run() {
				try {
					download(url, file);
				} catch (MalformedURLException e) {
					Log.e("minhang","",e);
				} catch (IOException e) {
					Log.e("minhang","",e);
				}
			}
		};
		downloadThread.start();
		// 更新notification线程
		uiThread = new Thread() {
			public void run() {
				isStop = false;
				notificationManager.notify(id, notification);
				while (!isStop) {
					Message msg = new Message();
					// 获取下载进度
					msg.arg1 = downLoadRate();
					
					if (msg.arg1 != 100) {//不等于100，没有下载完，继续更新界面
						handler.sendMessage(msg);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {// 否则下载完成，提示完成下载，提示否是安装此程序
						isStop = true;
						handler.sendMessage(msg);
					}					

				}
			}
		};
		
		uiThread.start();
	}
	
	public void stopDownload(){
		downloadThread.stop();
		uiThread.stop();
		notificationManager.cancel(id);
		//pluginInfo.changeStatus(PluginInfo.INTERUPT);
	}

	private File getDownLoadFile() {
		return file;
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			// 更新界面
			notification.contentView.setProgressBar(R.id.progressBar1, 100, msg.arg1, false);
			notification.contentView.setTextViewText(R.id.textView1, "已下载(" + msg.arg1 + "%)");
			notificationManager.notify(id, notification);
			// 完成下载，则跳转到系统提供的，安装程序的界面
			if (msg.arg1 == 100) {
				//pluginInfo.changeStatus(PluginInfo.DOWNLOADED);
				notificationManager.cancel(id);
				Toast.makeText(context, "下载完毕", 1000).show();
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setDataAndType(Uri.fromFile(getDownLoadFile()), "application/vnd.android.package-archive");
				context.startActivity(intent);
				//PhoneApplication.getDefault().saveTempInfo();				
			}
			
		}
	};
	
	public interface OnDownloadRateChangeListener{
		void onCurrentRateChange(int currentRate);
	}
}