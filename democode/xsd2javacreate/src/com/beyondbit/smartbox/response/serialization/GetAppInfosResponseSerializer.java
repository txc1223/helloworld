package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.GetAppInfosResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.AppInfoList;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.AppInfoListSerializer;

public class GetAppInfosResponseSerializer {

	public static void AppendChildElement(Document doc, GetAppInfosResponse obj, Element parentElement) {
		Element AppInfoListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:AppInfoList");
		AppInfoListSerializer.AppendChildElement(doc, obj.getAppInfoList(), AppInfoListElement);
		parentElement.appendChild(AppInfoListElement);

	}

}