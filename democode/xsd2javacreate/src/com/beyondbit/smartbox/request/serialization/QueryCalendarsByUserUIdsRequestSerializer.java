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
import com.beyondbit.smartbox.request.QueryCalendarsByUserUIdsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryCalendarsByUserUIdsRequestSerializer {

	public static void AppendChildElement(Document doc, QueryCalendarsByUserUIdsRequest obj, Element parentElement) {
		Element UserUidsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUids");
		UserUidsElement.setTextContent(obj.getUserUids() + "");
		parentElement.appendChild(UserUidsElement);

		Element ViewStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewStartTime");
		ViewStartTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewStartTime().getTime()));
		parentElement.appendChild(ViewStartTimeElement);

		Element ViewEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewEndTime");
		ViewEndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewEndTime().getTime()));
		parentElement.appendChild(ViewEndTimeElement);

	}

}