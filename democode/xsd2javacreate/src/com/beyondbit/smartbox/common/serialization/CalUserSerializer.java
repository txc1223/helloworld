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
import com.beyondbit.smartbox.common.CalUser;

public class CalUserSerializer {

	public static void AppendChildElement(Document doc, CalUser obj, Element parentElement) {
		Element OrgIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgId");
		OrgIdElement.setTextContent(obj.getOrgId() + "");
		parentElement.appendChild(OrgIdElement);

		Element UserIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserId");
		UserIdElement.setTextContent(obj.getUserId() + "");
		parentElement.appendChild(UserIdElement);

		Element UserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserName");
		UserNameElement.setTextContent(obj.getUserName() + "");
		parentElement.appendChild(UserNameElement);

		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
		SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);

	}

}