package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.GetCustomCalendarGroupListResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.CalendarGroup;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.CalendarGroupSerializer;

public class GetCustomCalendarGroupListResponseSerializer {

	public static void AppendChildElement(Document doc, GetCustomCalendarGroupListResponse obj, Element parentElement) {
		for(CalendarGroup calendarGroupObj : obj.getCalendarGroup()){
			Element CalendarGroupElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:CalendarGroup");
			CalendarGroupSerializer.AppendChildElement(doc, calendarGroupObj, CalendarGroupElement);
			parentElement.appendChild(CalendarGroupElement);
		}

	}

}