package com.beyondbit.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import com.beyondbit.xsd.UtilFileCreate;
import com.beyondbit.xsd.XSDCreate;
import com.beyondbit.xsd.XSDParser;
import com.beyondbit.xsd.XSDSerGen;

public class TestMain {
	static XSDParser parser;

	public static void main(String[] args) {
		test1();
//		UtilFileCreate u=new UtilFileCreate();
//		u.setOutDir("E:\\mycode\\xsd2java\\src");
//		u.GenerateUtilFile();
	}

	private static void test3() {
		// <req:Request xsi:type='req:SignInRequest'
		// ..xmlns:req='http://www.beyondbit.com/smartbox/request'
		// ..xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
		// ....<req:userUid>xuli</req:userUid>
		// ....<req:userPwd>123456</req:userPwd>
		// ....<req:client>Phone/Android</req:client>
		// </req:Request>

		TestA testA = new TestA();
		testA.setA("AA");
		testA.setB("BB");
		testA.setC("CC");

		Document doc = newDocument();

		Element reqElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:Request");
		reqElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
				"xsi:type", "req:SignInRequest");

		Element userUidElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:userUid");
		userUidElement.setTextContent("xuli");
		reqElement.appendChild(userUidElement);

		Element userPwdElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:userPwd");
		userPwdElement.setTextContent("123456");
		reqElement.appendChild(userPwdElement);

		Element clientElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:client");
		clientElement.setTextContent("Phone/Android");
		reqElement.appendChild(clientElement);

		doc.appendChild(reqElement);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeDocument(doc, baos);

		try {
			String xml = new String(baos.toByteArray(), "UTF-8");

			System.out.print(xml);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeDocument(Node input, OutputStream output) {
		try {
			DOMImplementationLS ls = (DOMImplementationLS) DOMImplementationRegistry
					.newInstance().getDOMImplementation("LS");
			LSSerializer ser = ls.createLSSerializer();
			LSOutput out = ls.createLSOutput();
			out.setByteStream(output);
			ser.write(input, out);
		} catch (Exception e) { // DIAF Java
			throw new RuntimeException(e);
		}
	}

	private static Document newDocument() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return builder.newDocument();
	}

	private static void test2() {
		try {
			URI uri = new URI("http://www.beyondbit.com/smartbox/common");
			System.out.print("fragment : " + uri.getFragment() + "\r\n");
			System.out.print("authority : " + uri.getAuthority() + "\r\n");
			System.out.print("host : " + uri.getHost() + "\r\n");
			System.out.print("path : " + uri.getPath() + "\r\n");
			System.out.print("port : " + uri.getPort() + "\r\n");
			System.out.print("query : " + uri.getQuery() + "\r\n");
			System.out.print("raw authority : " + uri.getRawAuthority()
					+ "\r\n");
			System.out.print("raw fragment : " + uri.getRawFragment() + "\r\n");
			System.out.print("raw path : " + uri.getRawPath() + "\r\n");
			System.out.print("raw query : " + uri.getRawQuery() + "\r\n");
			System.out.print("raw scheme specific part : "
					+ uri.getRawSchemeSpecificPart() + "\r\n");
			System.out
					.print("raw user info : " + uri.getRawUserInfo() + "\r\n");
			System.out.print("scheme : " + uri.getScheme() + "\r\n");
			System.out.print("scheme scheme specific part : "
					+ uri.getSchemeSpecificPart() + "\r\n");
			System.out.print("user info : " + uri.getUserInfo() + "\r\n");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test1() {
		parser = new XSDParser();
//		/Beyondbit.Android.SmartBox.CalendarSchemas/Schemas
		//E:\mycode\Beyondbit.Android.SmartBox.ServiceSchemas\Schemas
		//E:\mycode\Beyondbit.Android.SmartBox.Schemas\Schemas
		//E:\mycode\Beyondbit.Android.SmartBox.MagazineSchemas\Schemas
		String dir1 = "E:\\mycode\\Beyondbit.Android.SmartBox.CalendarSchemas\\Schemas\\Include\\";
//		String dir1 = "E:\\mycode\\Beyondbit.Android.SmartBox.Schemas\\Schemas\\Include\\";
		String dir2 = "E:\\mycode\\Beyondbit.Android.SmartBox.CalendarSchemas\\Schemas\\Schemas\\";

		LoadFile(new File(dir1));
		LoadFile(new File(dir2));

		//parser.printType();
		
		XSDSerGen gen = new XSDSerGen();
		gen.setOutDir("E:\\mycode\\xsd2java\\src");
		gen.genSerClass(parser.getXsdInfo());
		
		XSDCreate create = new XSDCreate();
		create.setOutDir("E:\\mycode\\xsd2java\\src");
		create.GenerateJavaFile(parser.getXsdInfo());
		
//		UtilFileCreate u=new UtilFileCreate();
//		u.setOutDir("E:\\mycode\\xsd2java\\src");
//		u.GenerateUtilFile();
	}

	private static void LoadFile(File file) {
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
