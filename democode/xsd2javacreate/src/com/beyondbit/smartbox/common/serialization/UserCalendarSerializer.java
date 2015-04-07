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
import com.beyondbit.smartbox.common.UserCalendar;
import com.beyondbit.smartbox.common.CalendarList;
import com.beyondbit.smartbox.common.serialization.CalendarListSerializer;

public class UserCalendarSerializer {

	public static void AppendChildElement(Document doc, UserCalendar obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element CalendarListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CalendarList");
		CalendarListSerializer.AppendChildElement(doc, obj.getCalendarList(), CalendarListElement);
		parentElement.appendChild(CalendarListElement);

	}

}