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
import com.beyondbit.smartbox.common.SmsPersonV2;

public class SmsPersonV2Serializer {

	public static void AppendChildElement(Document doc, SmsPersonV2 obj, Element parentElement) {
		Element AccountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Account");
		AccountElement.setTextContent(obj.getAccount() + "");
		parentElement.appendChild(AccountElement);

		Element MobileElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Mobile");
		MobileElement.setTextContent(obj.getMobile() + "");
		parentElement.appendChild(MobileElement);

		Element DisplayNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DisplayName");
		DisplayNameElement.setTextContent(obj.getDisplayName() + "");
		parentElement.appendChild(DisplayNameElement);

	}

}