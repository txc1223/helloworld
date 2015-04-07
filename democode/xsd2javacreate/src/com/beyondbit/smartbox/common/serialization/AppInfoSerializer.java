package com.beyondbit.smartbox.common.serialization;

import java.io.ByteArrayOutputStream; 
import java.text.SimpleDateFormat; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.bootstrap.DOMImplementationRegistry; 
import org.w3c.dom.ls.DOMImplementationLS; 
import org.w3c.dom.ls.LSOutput; 
import org.w3c.dom.ls.LSSerializer; 
import com.beyondbit.smartbox.common.AppInfo;

public class AppInfoSerializer {

	public static void AppendChildElement(Document doc, AppInfo obj, Element parentElement) {
		Element AppCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AppCode");
		AppCodeElement.setTextContent(obj.getAppCode() + "");
		parentElement.appendChild(AppCodeElement);

		Element AppNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AppName");
		AppNameElement.setTextContent(obj.getAppName() + "");
		parentElement.appendChild(AppNameElement);

		Element AppHomeUrlElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AppHomeUrl");
		AppHomeUrlElement.setTextContent(obj.getAppHomeUrl() + "");
		parentElement.appendChild(AppHomeUrlElement);

	}

}