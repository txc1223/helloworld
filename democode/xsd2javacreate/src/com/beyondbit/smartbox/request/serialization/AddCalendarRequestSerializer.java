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
import com.beyondbit.smartbox.request.AddCalendarRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.DetailCalendar;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.DetailCalendarSerializer;

public class AddCalendarRequestSerializer {

	public static void AppendChildElement(Document doc, AddCalendarRequest obj, Element parentElement) {
		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
		CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
		parentElement.appendChild(CalendarTypeElement);

		Element DetailCalendarElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DetailCalendar");
		DetailCalendarSerializer.AppendChildElement(doc, obj.getDetailCalendar(), DetailCalendarElement);
		parentElement.appendChild(DetailCalendarElement);

	}
	
	public static AddCalendarRequest der(Element doc, AddCalendarRequest obj, Element parentElement) {
		AddCalendarRequest a=new AddCalendarRequest();
		a.setCalendarType(doc.getElementsByTagName("CalendarType").item(0).getTextContent());
		return a;
		
//		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
//		CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
//		parentElement.appendChild(CalendarTypeElement);
//
//		Element DetailCalendarElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DetailCalendar");
//		DetailCalendarSerializer.AppendChildElement(doc, obj.getDetailCalendar(), DetailCalendarElement);
//		parentElement.appendChild(DetailCalendarElement);

	}

}