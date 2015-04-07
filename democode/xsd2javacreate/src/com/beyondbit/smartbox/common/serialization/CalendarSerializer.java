package com.beyondbit.smartbox.common.serialization;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.beyondbit.smartbox.MyNode;
import com.beyondbit.smartbox.UtilTextContent;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.DetailCalendar;

public class CalendarSerializer {

	public static void AppendChildElement(Document doc, Calendar obj, Element parentElement) {
		Element ItemIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ItemID");
		ItemIDElement.setTextContent(obj.getItemID() + "");
		parentElement.appendChild(ItemIDElement);

		Element SubjectElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Subject");
		SubjectElement.setTextContent(obj.getSubject() + "");
		parentElement.appendChild(SubjectElement);

		Element StartElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Start");
		StartElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getStart().getTime()));
		parentElement.appendChild(StartElement);

		Element EndElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:End");
		EndElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getEnd().getTime()));
		parentElement.appendChild(EndElement);

		Element IsAllDayEventElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsAllDayEvent");
		IsAllDayEventElement.setTextContent(obj.getIsAllDayEvent() + "");
		parentElement.appendChild(IsAllDayEventElement);

		Element IsMeetingRequestElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsMeetingRequest");
		IsMeetingRequestElement.setTextContent(obj.getIsMeetingRequest() + "");
		parentElement.appendChild(IsMeetingRequestElement);

		Element IsReadOnlyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsReadOnly");
		IsReadOnlyElement.setTextContent(obj.getIsReadOnly() + "");
		parentElement.appendChild(IsReadOnlyElement);

		Element UserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserName");
		UserNameElement.setTextContent(obj.getUserName() + "");
		parentElement.appendChild(UserNameElement);

		Element AttendeesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Attendees");
		AttendeesElement.setTextContent(obj.getAttendees() + "");
		parentElement.appendChild(AttendeesElement);

		Element AttendeNamesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AttendeNames");
		AttendeNamesElement.setTextContent(obj.getAttendeNames() + "");
		parentElement.appendChild(AttendeNamesElement);

		Element OtherAttendeesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OtherAttendees");
		OtherAttendeesElement.setTextContent(obj.getOtherAttendees() + "");
		parentElement.appendChild(OtherAttendeesElement);

		Element LocationElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Location");
		LocationElement.setTextContent(obj.getLocation() + "");
		parentElement.appendChild(LocationElement);

		Element ExtendField1Element = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ExtendField1");
		ExtendField1Element.setTextContent(obj.getExtendField1() + "");
		parentElement.appendChild(ExtendField1Element);

		Class<? extends Calendar> cls = obj.getClass();

		if (cls.equals(DetailCalendar.class)) {
			DetailCalendarSerializer.AppendChildElement(doc, (DetailCalendar) obj, parentElement);
		}
	}
	public static Calendar parseChildElement(MyNode n) {
		List<MyNode>  nodeL = n.getMyNodeList();
		System.out.println("开始=================Calendar========================\r\n");
		com.beyondbit.smartbox.common.Calendar c = new com.beyondbit.smartbox.common.Calendar();
		for (int j = 0; j < nodeL.size(); j++) {
			MyNode n1 = nodeL.get(j);
			System.out.print("字段名=" + n1.getName());
			System.out.println("字段值=" + n1.getTextContent());

			if (n1.equalsName("c:ItemID")&& n1.equalsNameSpace("http://www.beyondbit.com/smartbox/common/")) {
				c.setItemID(n1.getTextContent());
			} else if (n1.equalsName("c:Subject")&& n1.equalsNameSpace("http://www.beyondbit.com/smartbox/common/")) {
				c.setSubject(n1.getTextContent());
			} else if (n1.equalsName("Start")) {
				c.setStart(UtilTextContent.toCalendar(n1.getTextContent()));
			} else if (n1.equalsName("End")) {
				c.setEnd(UtilTextContent.toCalendar(n1.getTextContent()));
			} else if (n1.equalsName("IsAllDayEvent")) {
				c.setIsAllDayEvent(n1.getTextContent());
			} else if (n1.equalsName("IsMeetingRequest")) {
				c.setIsMeetingRequest(n1.getTextContent());
			} else if (n1.equalsName("IsReadOnly")) {
				c.setIsReadOnly(n1.getTextContent());
			} else if (n1.equalsName("UserName")) {
				c.setUserName(n1.getTextContent());
			} else if (n1.equalsName("Attendees")) {
				c.setAttendees(n1.getTextContent());
			} else if (n1.equalsName("AttendeNames")) {
				c.setAttendeNames(n1.getTextContent());
			} else if (n1.equalsName("OtherAttendees")) {
				c.setOtherAttendees(n1.getTextContent());
			} else if (n1.equalsName("Location")) {
				c.setLocation(n1.getTextContent());
			} else if (n1.equalsName("ExtendField1")) {
				c.setExtendField1(n1.getTextContent());
			}

		}
		return c;

	}

}