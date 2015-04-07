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
import com.beyondbit.smartbox.request.GetCustomCalendarGroupUserListRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class GetCustomCalendarGroupUserListRequestSerializer {

	public static void AppendChildElement(Document doc, GetCustomCalendarGroupUserListRequest obj, Element parentElement) {
		Element GroupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:GroupId");
		GroupIdElement.setTextContent(obj.getGroupId() + "");
		parentElement.appendChild(GroupIdElement);

	}

}