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
import com.beyondbit.smartbox.common.UserMap;

public class UserMapSerializer {

	public static void AppendChildElement(Document doc, UserMap obj, Element parentElement) {
		Element UserMapUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserMapUid");
		UserMapUidElement.setTextContent(obj.getUserMapUid() + "");
		parentElement.appendChild(UserMapUidElement);

		Element UserMapPwdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserMapPwd");
		UserMapPwdElement.setTextContent(obj.getUserMapPwd() + "");
		parentElement.appendChild(UserMapPwdElement);

	}

}