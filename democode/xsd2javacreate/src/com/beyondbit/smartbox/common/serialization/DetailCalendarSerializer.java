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
import com.beyondbit.smartbox.common.DetailCalendar;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class DetailCalendarSerializer {

	public static void AppendChildElement(Document doc, DetailCalendar obj, Element parentElement) {
		Element InstanceTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:InstanceType");
		InstanceTypeElement.setTextContent(obj.getInstanceType() + "");
		parentElement.appendChild(InstanceTypeElement);

		Element UserIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserID");
		UserIDElement.setTextContent(obj.getUserID() + "");
		parentElement.appendChild(UserIDElement);

		Element BodyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Body");
		BodyElement.setTextContent(obj.getBody() + "");
		parentElement.appendChild(BodyElement);

		Element OtherAttendeesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OtherAttendees");
		OtherAttendeesElement.setTextContent(obj.getOtherAttendees() + "");
		parentElement.appendChild(OtherAttendeesElement);

		Element RecurringElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Recurring");
		RecurringElement.setTextContent(obj.getRecurring() + "");
		parentElement.appendChild(RecurringElement);

		Element DeptIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptId");
		DeptIdElement.setTextContent(obj.getDeptId() + "");
		parentElement.appendChild(DeptIdElement);

		Element DeptNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptName");
		DeptNameElement.setTextContent(obj.getDeptName() + "");
		parentElement.appendChild(DeptNameElement);

		Element CatagoriesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Catagories");
		CatagoriesElement.setTextContent(obj.getCatagories() + "");
		parentElement.appendChild(CatagoriesElement);

		Element IsReminderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsReminder");
		IsReminderElement.setTextContent(obj.getIsReminder() + "");
		parentElement.appendChild(IsReminderElement);

		Element ReminderOffsetElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReminderOffset");
		ReminderOffsetElement.setTextContent(obj.getReminderOffset() + "");
		parentElement.appendChild(ReminderOffsetElement);

		Element ReminderTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReminderType");
		ReminderTypeElement.setTextContent(obj.getReminderType() + "");
		parentElement.appendChild(ReminderTypeElement);

	}

}