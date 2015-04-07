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
import com.beyondbit.smartbox.request.SendIMCacheRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class SendIMCacheRequestSerializer {

	public static void AppendChildElement(Document doc, SendIMCacheRequest obj, Element parentElement) {
		Element RecieverUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:RecieverUid");
		RecieverUidElement.setTextContent(obj.getRecieverUid() + "");
		parentElement.appendChild(RecieverUidElement);

		Element SendTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:SendTime");
		SendTimeElement.setTextContent(obj.getSendTime() + "");
		parentElement.appendChild(SendTimeElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

	}

}