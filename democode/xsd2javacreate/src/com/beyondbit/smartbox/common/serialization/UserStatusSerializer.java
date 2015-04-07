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
import com.beyondbit.smartbox.common.UserStatus;
import com.beyondbit.smartbox.common.StatusType;
import com.beyondbit.smartbox.common.serialization.StatusTypeSerializer;

public class UserStatusSerializer {

	public static void AppendChildElement(Document doc, UserStatus obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Status");
		StatusTypeSerializer.AppendChildElement(doc, obj.getStatus(), StatusElement);
		parentElement.appendChild(StatusElement);

		Element DescriptionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Description");
		DescriptionElement.setTextContent(obj.getDescription() + "");
		parentElement.appendChild(DescriptionElement);

	}

}