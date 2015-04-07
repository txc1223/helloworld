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
import com.beyondbit.smartbox.common.OAUser;

public class OAUserSerializer {

	public static void AppendChildElement(Document doc, OAUser obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element DeptElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Dept");
		DeptElement.setTextContent(obj.getDept() + "");
		parentElement.appendChild(DeptElement);

		Element UserIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserId");
		UserIdElement.setTextContent(obj.getUserId() + "");
		parentElement.appendChild(UserIdElement);

	}

}