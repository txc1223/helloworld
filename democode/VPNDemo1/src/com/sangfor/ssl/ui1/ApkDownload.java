package com.sangfor.ssl.ui1;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class ApkDownload {
	private static final String TAG = "ApkDownload";
	private File saveFile;// 文件保存路径
	private URL downUrl;
	private boolean finish = false;
	private ApkDownloadManager downloader;

	public ApkDownload(ApkDownloadManager downloader, URL downUrl, File saveFile) {
		this.downUrl = downUrl;
		this.saveFile = saveFile;
		this.downloader = downloader;

		startDownload();
	}

	private void startDownload() {
		// 未下载完成
		try {
			HttpURLConnection http = (HttpURLConnection) downUrl.openConnection();
			http.setConnectTimeout(5 * 1000);
			http.setRequestMethod("GET");
			// 下载开始位置
			long startPos = 0;
			// 下载结束位置
//			long endPos = fileSize - 1;
			// 设置获取实体数据的范围
//			http.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);

			InputStream inStream = http.getInputStream();

			byte[] buffer = new byte[1024];
			int offset = 0;
			print(" start download from position " + startPos);
			RandomAccessFile file = new RandomAccessFile(this.saveFile, "rwd");
			file.seek(startPos);
			while ((offset = inStream.read(buffer, 0, 1024)) != -1) {
				file.write(buffer, 0, offset);
				int size=downloader.append(offset);
				print(" position1 ==" + size);
			}
			file.close();
			inStream.close();
			print("download finish");
			// 标记是否完成
			this.finish = true;
		} catch (Exception e) {

			print("Exception " + ":" + e);
		}
	}


	private static void print(String msg) {
		Log.i(TAG, msg);
	}

	/**
	 * 下载是否完成
	 * 
	 * @return
	 */
	public boolean isFinish() {
		return finish;
	}

}
