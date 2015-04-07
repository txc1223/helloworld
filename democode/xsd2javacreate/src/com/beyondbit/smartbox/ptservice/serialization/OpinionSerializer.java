package com.beyondbit.smartbox.ptservice.serialization;

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
import com.beyondbit.smartbox.ptservice.Opinion;

public class OpinionSerializer {

	public static void AppendChildElement(Document doc, Opinion obj, Element parentElement) {
		Element TitleElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Title");
		TitleElement.setTextContent(obj.getTitle() + "");
		parentElement.appendChild(TitleElement);

		Element UserElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:User");
		UserElement.setTextContent(obj.getUser() + "");
		parentElement.appendChild(UserElement);

		Element OrgElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Org");
		OrgElement.setTextContent(obj.getOrg() + "");
		parentElement.appendChild(OrgElement);

		Element TimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Time");
		TimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getTime().getTime()));
		parentElement.appendChild(TimeElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

	}

}