package com.beyondbit.main;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.beyondbit.xsd.UtilFileCreate;
import com.beyondbit.xsd.XSDCreate;
import com.beyondbit.xsd.XSDParser;
import com.beyondbit.xsd.XSDSerGen;

public class XmlResourceMergerTask extends Task {
	private XSDParser parser;
	private String inDirPath;
	private String outDirPath;


	public String getInDirPath() {
		return inDirPath;
	}

	public void setInDirPath(String inDirPath) {
		this.inDirPath = inDirPath;
	}

	public String getOutDirPath() {
		return outDirPath;
	}

	public void setOutDirPath(String file) {
		this.outDirPath = file;
	}

	@Override
	public void execute() throws BuildException {
//		String dir1 = "E:\\mycode\\Beyondbit.Android.SmartBox.ServiceSchemas\\Schemas\\Include\\";
		// String dir1 =
		// "E:\\mycode\\Beyondbit.Android.SmartBox.Schemas\\Schemas\\Include\\";
//		String dir2 = "E:\\mycode\\Beyondbit.Android.SmartBox.ServiceSchemas\\Schemas\\Schemas\\";
		parser = new XSDParser();
		LoadFile(new File(inDirPath));
		LoadFile(new File(inDirPath));

		// parser.printType();

		XSDSerGen gen = new XSDSerGen();
		gen.setOutDir(outDirPath);
		gen.genSerClass(parser.getXsdInfo());

		XSDCreate create = new XSDCreate();
		create.setOutDir(outDirPath);
		create.GenerateJavaFile(parser.getXsdInfo());
		
		UtilFileCreate u=new UtilFileCreate();
		u.setOutDir(outDirPath);
		u.GenerateUtilFile();
	}

	private  void LoadFile(File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				LoadFile(child);
			}
		}

		if (file.isFile()) {
			String fileName = file.getName();
			if (fileName.toLowerCase().endsWith(".xsd")) {
				parser.parse(file.getPath());
			}
		}
	}
}
