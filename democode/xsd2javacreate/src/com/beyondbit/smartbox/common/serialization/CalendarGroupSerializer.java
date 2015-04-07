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
import com.beyondbit.smartbox.common.CalendarGroup;

public class CalendarGroupSerializer {

	public static void AppendChildElement(Document doc, CalendarGroup obj, Element parentElement) {
		Element GroupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupId");
		GroupIdElement.setTextContent(obj.getGroupId() + "");
		parentElement.appendChild(GroupIdElement);

		Element GroupNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupName");
		GroupNameElement.setTextContent(obj.getGroupName() + "");
		parentElement.appendChild(GroupNameElement);

	}

}