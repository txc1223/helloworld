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
import com.beyondbit.smartbox.common.OrgCalendar;
import com.beyondbit.smartbox.common.CalendarList;
import com.beyondbit.smartbox.common.serialization.CalendarListSerializer;

public class OrgCalendarSerializer {

	public static void AppendChildElement(Document doc, OrgCalendar obj, Element parentElement) {
		Element OrgCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgCode");
		OrgCodeElement.setTextContent(obj.getOrgCode() + "");
		parentElement.appendChild(OrgCodeElement);

		Element CalendarListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CalendarList");
		CalendarListSerializer.AppendChildElement(doc, obj.getCalendarList(), CalendarListElement);
		parentElement.appendChild(CalendarListElement);

	}

}