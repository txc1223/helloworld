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
import com.beyondbit.smartbox.common.IMCache;

public class IMCacheSerializer {

	public static void AppendChildElement(Document doc, IMCache obj, Element parentElement) {
		Element SenderUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SenderUid");
		SenderUidElement.setTextContent(obj.getSenderUid() + "");
		parentElement.appendChild(SenderUidElement);

		Element SendTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendTime");
		SendTimeElement.setTextContent(obj.getSendTime() + "");
		parentElement.appendChild(SendTimeElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

	}

}