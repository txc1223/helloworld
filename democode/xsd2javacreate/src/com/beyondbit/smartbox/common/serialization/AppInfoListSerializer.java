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
import com.beyondbit.smartbox.common.AppInfoList;
import com.beyondbit.smartbox.common.AppInfo;
import com.beyondbit.smartbox.common.serialization.AppInfoSerializer;

public class AppInfoListSerializer {

	public static void AppendChildElement(Document doc, AppInfoList obj, Element parentElement) {
		for(AppInfo appInfoObj : obj.getAppInfo()){
			Element AppInfoElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AppInfo");
			AppInfoSerializer.AppendChildElement(doc, appInfoObj, AppInfoElement);
			parentElement.appendChild(AppInfoElement);
		}

	}

}