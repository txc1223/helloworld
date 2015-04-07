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
import com.beyondbit.smartbox.request.QueryCalendarsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryCalendarsRequestSerializer {

	public static void AppendChildElement(Document doc, QueryCalendarsRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element ViewStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewStartTime");
		ViewStartTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewStartTime().getTime()));
		parentElement.appendChild(ViewStartTimeElement);

		Element ViewEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewEndTime");
		ViewEndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewEndTime().getTime()));
		parentElement.appendChild(ViewEndTimeElement);

		Element SubjectElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Subject");
		SubjectElement.setTextContent(obj.getSubject() + "");
		parentElement.appendChild(SubjectElement);

		Element IsPreciseElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:IsPrecise");
		IsPreciseElement.setTextContent(obj.getIsPrecise() + "");
		parentElement.appendChild(IsPreciseElement);

		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
		CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
		parentElement.appendChild(CalendarTypeElement);

		Element DeptCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DeptCode");
		DeptCodeElement.setTextContent(obj.getDeptCode() + "");
		parentElement.appendChild(DeptCodeElement);

		Element PageSizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageSize");
		PageSizeElement.setTextContent(obj.getPageSize() + "");
		parentElement.appendChild(PageSizeElement);

		Element PageIndexElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageIndex");
		PageIndexElement.setTextContent(obj.getPageIndex() + "");
		parentElement.appendChild(PageIndexElement);

	}

}