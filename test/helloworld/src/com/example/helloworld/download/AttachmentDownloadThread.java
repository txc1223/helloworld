package com.example.helloworld.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.example.helloworld.util.MD5;

public class AttachmentDownloadThread extends Thread {

	// private volatile AttachmentDownloadThread thread;
	public static final int DOWNLOAD_OK = 0x1;
	public static final int DOWNLOAD_FAILURE = 0x0;
	public static final int DOWNLOAD_FAIL_OPEN = 0x2;
	private Context context;
	private String url;
	private String fileName;
	private OnDownloadRateChangeListener listener;
	private boolean isFinish = false;

	public AttachmentDownloadThread(Context context, String url, OnDownloadRateChangeListener onDownloadRateChangeListener) {
		this.context = context;
		this.url = url;

		String end = url.substring(url.lastIndexOf("."), url.length()).toLowerCase();
		this.fileName = MD5.getMD5(url) + end;
		this.listener = onDownloadRateChangeListener;
		// url_prefix = "http://192.168.200.142:10080/Download.ashx";
	}

	public void run() {
		Intent intent=null;
		try {
			HttpURLConnection urlConnection = (HttpURLConnection) (new URL(url)).openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			FileOutputStream fileOutput;
			InputStream inputStream;
			File file = getDownloadFile(fileName);
			if (!file.exists()) {
				fileOutput = new FileOutputStream(file);
				inputStream = urlConnection.getInputStream();
				byte[] buffer = new byte[1024];
				int bufferLength = 0;
				isFinish = false;
				long count = 0; // 已经下载的大小，用于判断下载进度
				while ((bufferLength = inputStream.read(buffer)) > 0) {
					if (Thread.currentThread().isInterrupted()) {
						Log.i("txc", "Thread is interrupt");
						deleteFile(file.getPath());
						return;
					}
					fileOutput.write(buffer, 0, bufferLength);

					count = count + bufferLength;
				}
				fileOutput.close();
				isFinish = true;
				if (listener != null) {
					listener.onCurrentRateChange(isFinish, DOWNLOAD_OK);
				}
				Log.i("txc", "-complete-----------------");
			}
			intent = OpenFile.openFile(file.getPath());
			Log.i("txc", getDownloadFile(fileName).getPath());
			

		} catch (Exception e) {
			try {
				isFinish = true;
				if (listener != null) {
					Log.i("txc", "====DOWNLOAD_FAILURE");
					listener.onCurrentRateChange(isFinish, DOWNLOAD_FAILURE);
				}
				deleteFile(getDownloadFile(fileName).getPath());

			} catch (Exception e1) {
			}
			Log.e("error", "", e);
		}
		try {
			context.startActivity(intent);
		} catch (Exception e) {
			try {
				if (listener != null) {
					Log.i("txc", "====DOWNLOAD_FAIL_OPEN");
					listener.onCurrentRateChange(isFinish, DOWNLOAD_FAIL_OPEN);
				}
			} catch (Exception e1) {
			}
			Log.e("error", "", e);
		}
	}

	private File getDownloadFile(String name) throws Exception {
		// 判断是否有sdcard
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File path = new File(Environment.getExternalStorageDirectory().getPath() + "/minhang/download");
			if (!path.exists()) {
				path.mkdirs();
			}
			return new File(path, name);
		} else {
			throw new Exception("无sdcard?");
		}
	}

	private boolean deleteFile(String path) {
		File file = new File(path);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			return file.delete();
		}

		return false;
	}

	public interface OnDownloadRateChangeListener {
		void onCurrentRateChange(boolean isFinish, int status);
	}

}
