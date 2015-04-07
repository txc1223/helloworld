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
import com.beyondbit.smartbox.request.SendOfflineFileRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class SendOfflineFileRequestSerializer {

	public static void AppendChildElement(Document doc, SendOfflineFileRequest obj, Element parentElement) {
		Element ToElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:To");
		ToElement.setTextContent(obj.getTo() + "");
		parentElement.appendChild(ToElement);

		Element DisplayNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DisplayName");
		DisplayNameElement.setTextContent(obj.getDisplayName() + "");
		parentElement.appendChild(DisplayNameElement);

		Element SizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Size");
		SizeElement.setTextContent(obj.getSize() + "");
		parentElement.appendChild(SizeElement);

	}

}