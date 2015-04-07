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
import com.beyondbit.smartbox.request.DeleteCalendarRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class DeleteCalendarRequestSerializer {

	public static void AppendChildElement(Document doc, DeleteCalendarRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element ItemIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ItemId");
		ItemIdElement.setTextContent(obj.getItemId() + "");
		parentElement.appendChild(ItemIdElement);

		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
		CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
		parentElement.appendChild(CalendarTypeElement);

		Element InstanceTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:InstanceType");
		InstanceTypeElement.setTextContent(obj.getInstanceType() + "");
		parentElement.appendChild(InstanceTypeElement);

	}

}