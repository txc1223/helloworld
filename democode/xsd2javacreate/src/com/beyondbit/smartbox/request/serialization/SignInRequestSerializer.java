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
import com.beyondbit.smartbox.request.SignInRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class SignInRequestSerializer {

	public static void AppendChildElement(Document doc, SignInRequest obj, Element parentElement) {
		Element userUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:userUid");
		userUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(userUidElement);

		Element userPwdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:userPwd");
		userPwdElement.setTextContent(obj.getUserPwd() + "");
		parentElement.appendChild(userPwdElement);

		Element clientElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:client");
		clientElement.setTextContent(obj.getClient() + "");
		parentElement.appendChild(clientElement);

		Element deviceIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:deviceId");
		deviceIdElement.setTextContent(obj.getDeviceId() + "");
		parentElement.appendChild(deviceIdElement);

	}

}