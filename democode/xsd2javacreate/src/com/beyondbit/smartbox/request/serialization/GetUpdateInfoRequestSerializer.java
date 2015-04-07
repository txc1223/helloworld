package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.GetUpdateInfoRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class GetUpdateInfoRequestSerializer {

	public static void AppendChildElement(Document doc, GetUpdateInfoRequest obj, Element parentElement) {
		Element clientElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:client");
		clientElement.setTextContent(obj.getClient() + "");
		parentElement.appendChild(clientElement);

		Element deviceIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:deviceId");
		deviceIdElement.setTextContent(obj.getDeviceId() + "");
		parentElement.appendChild(deviceIdElement);

	}

}