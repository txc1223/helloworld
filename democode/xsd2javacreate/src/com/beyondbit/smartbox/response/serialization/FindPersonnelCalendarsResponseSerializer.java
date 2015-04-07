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
import com.beyondbit.smartbox.response.FindPersonnelCalendarsResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class FindPersonnelCalendarsResponseSerializer {

	public static void AppendChildElement(Document doc, FindPersonnelCalendarsResponse obj, Element parentElement) {
		for(Calendar calendarObj : obj.getCalendar()){
			Element CalendarElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Calendar");
			CalendarSerializer.AppendChildElement(doc, calendarObj, CalendarElement);
			parentElement.appendChild(CalendarElement);
		}

	}

}