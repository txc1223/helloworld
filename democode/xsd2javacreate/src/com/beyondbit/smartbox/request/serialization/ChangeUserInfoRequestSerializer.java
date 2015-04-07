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
import com.beyondbit.smartbox.request.ChangeUserInfoRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class ChangeUserInfoRequestSerializer {

	public static void AppendChildElement(Document doc, ChangeUserInfoRequest obj, Element parentElement) {
		Element UserMobilePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserMobilePhone");
		UserMobilePhoneElement.setTextContent(obj.getUserMobilePhone() + "");
		parentElement.appendChild(UserMobilePhoneElement);

		Element UserOfficePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserOfficePhone");
		UserOfficePhoneElement.setTextContent(obj.getUserOfficePhone() + "");
		parentElement.appendChild(UserOfficePhoneElement);

		Element UserFaxElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserFax");
		UserFaxElement.setTextContent(obj.getUserFax() + "");
		parentElement.appendChild(UserFaxElement);

		Element UserExtPhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserExtPhone");
		UserExtPhoneElement.setTextContent(obj.getUserExtPhone() + "");
		parentElement.appendChild(UserExtPhoneElement);

		Element UserOfficeRoomElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserOfficeRoom");
		UserOfficeRoomElement.setTextContent(obj.getUserOfficeRoom() + "");
		parentElement.appendChild(UserOfficeRoomElement);

	}

}