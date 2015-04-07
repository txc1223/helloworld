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
import com.beyondbit.smartbox.request.ViewCallBoardRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class ViewCallBoardRequestSerializer {

	public static void AppendChildElement(Document doc, ViewCallBoardRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element IPElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:IP");
		IPElement.setTextContent(obj.getIP() + "");
		parentElement.appendChild(IPElement);

	}

}