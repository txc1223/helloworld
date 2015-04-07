package com.sangfor.ssl.ui1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.util.Log;

public class ApkDownloadManager {

	private static final String TAG = "ApkDownloadManager";
	private final int MAP_KEY = 0x1;
	private Context context;
	
	private int downloadSize = 0;// 已下载文件长度
	
	private long fileSize = 0;// 原始文件长度
	
	private ApkDownload apkDownload;
	
	private File saveFile;// 本地保存文件
	// 下载路径
	private String downloadUrl;

	private long updateTime = 0;//数据库更新时间，否则数据库读写太频繁，下载速度慢
	
	public static final long TIME_LAG = 2000;//时间间隔
	
	public static final long TIME_OUT = 10000;
	private long detaTime = 0;//超时时间
	

	public long getDetaTime() {
		return detaTime;
	}

	/**
	 * 获取文件大小
	 * 
	 * @return
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * 获取下载文件
	 * 
	 * @return
	 */
	public File getSaveFile() {
		return saveFile;
	}

	/**
	 * 累计已下载大小
	 * 
	 * @param size
	 */
	protected synchronized int append(int size) {
		downloadSize += size;
		return downloadSize;
	}


	private long parseContentRange(String contentRange) throws IOException {
		String[] strs = contentRange.trim().split(" ");
		String rangeInfo = strs[strs.length - 1];
		int i2 = rangeInfo.indexOf('/');
		return Long.parseLong(rangeInfo.substring(i2 + 1));
	}

	/**
	 * 文件下载构造器
	 * 
	 * @param downloadUrl
	 *            下载路径
	 * @param fileSaveDir
	 *            文件保存目录
	 * @param threadNum
	 *            下载线程数
	 * @throws Exception
	 */
	public ApkDownloadManager(Context context, String downloadUrl, File fileSaveDir) throws Exception {
		try {
			this.detaTime = 0;
			this.context = context;
			this.downloadUrl = downloadUrl;
			URL url = new URL(this.downloadUrl);
			print("downloadUrl== "+downloadUrl);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Range", "bytes=0-0");
//			conn.setRequestProperty("Referer", "http://,,,");
			conn.connect();
			print("getResponseCode() == "+conn.getResponseCode()+"\nconn.getResponseMessage()=="+conn.getResponseMessage());
			if (conn.getResponseCode() == 206) {
				this.fileSize = parseContentRange(conn.getHeaderField("Content-Range"));

				String filename = getFileName(conn);

				// 构建保存文件
				this.saveFile = new File(fileSaveDir, filename);
			} else {
				throw new IOException("server not support ");
			}
		} catch (Exception e) {
			print(e.toString());
			// throw new RuntimeException("don't connection this url");
			throw new Exception("don't connection this url");
		}
	}

	/**
	 * 获取文件名
	 */
	private String getFileName(HttpURLConnection conn) {
		String filename = this.downloadUrl.substring(this.downloadUrl.lastIndexOf('/') + 1);
		if (filename == null || "".equals(filename.trim())) {// 如果获取不到文件名称
			for (int i = 0;; i++) {
				String mine = conn.getHeaderField(i);
				if (mine == null)
					break;
				if ("content-disposition".equals(conn.getHeaderFieldKey(i).toLowerCase())) {
					Matcher m = Pattern.compile(".*filename=(.*)").matcher(mine.toLowerCase());
					if (m.find())
						return m.group(1);
				}
			}
			filename = UUID.randomUUID() + ".tmp";// 默认取一个文件名
		}
		return filename;
	}

	/**
	 * 开始下载文件
	 * 
	 * @param onDownloadRateChangeListener
	 *            监听下载数量的变化,如果不需要了解实时下载的数量,可以设置为null
	 * @return 已下载文件大小
	 * @throws Exception
	 */
	public int download() throws Exception {
		try {
			// 创建本地文件
			RandomAccessFile randOut = new RandomAccessFile(this.saveFile, "rw");
			if (this.fileSize > 0)
				randOut.setLength(this.fileSize);
			randOut.close();
			
			URL url = new URL(this.downloadUrl);
			
			
			// 判断线程是否已经完成下载,否则继续下载
			if (this.downloadSize < this.fileSize) {
				apkDownload = new ApkDownload(this, url, this.saveFile);
			} else {
			}
			
		} catch (Exception e) {
			print(e.toString());
			throw new Exception("file download fail");
		}
		
		return this.downloadSize;
	}

	private static void print(String msg) {
		Log.i(TAG, msg);
	}
	
}
