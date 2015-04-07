package com.beyondbit.xsd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.beyondbit.util.UtilFileInsert;

public class UtilFileCreate {
	private String outDir;

	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	public void GenerateUtilFile() {
		 File file=createFile("MyNode.java");
		 File file1=createFile("UtilTextContent.java");
		 File file2=createFile("ISODateFormat.java");
		 copyFile("/java/MyNode.txt", file.getPath());
		 copyFile("/java/UtilTextContent.txt", file1.getPath());
		 copyFile("/java/ISODateFormat.txt", file2.getPath());
	}

	// 创建文件

	private File createFile(String name) {
		File picFileDir = new File(outDir + "\\util");// 仅创建路径的File对象
		if (!picFileDir.exists()) {
			picFileDir.mkdirs();// 如果路径不存在就先创建路径
		}
		// else {
		// picFileDir.delete();
		// picFileDir.mkdirs();
		// }
		File f = new File(picFileDir, name);// 然后再创建路径和文件的File对象
		try {
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			} else {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}
	public  void copyFile(String oldPath, String newPath) {
		try {
			// int bytesum = 0;
			int byteread = 0;
//			oldPath=this.getClass().getResource(oldPath).getFile();
			InputStream inStream =this.getClass().getResourceAsStream(oldPath);
			System.out.println(oldPath+"-------------oldPath");
//			File oldfile = new File(oldPath);
//			if (oldfile.exists()) { // 文件存在时
			if (inStream!=null) { // 文件存在时
				System.out.println("-------------有输入流");
//				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				
				FileOutputStream fs = new FileOutputStream(newPath);
				
				byte[] buffer = new byte[1444];
				// int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					// bytesum += byteread; //字节数 文件大小
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}
}
