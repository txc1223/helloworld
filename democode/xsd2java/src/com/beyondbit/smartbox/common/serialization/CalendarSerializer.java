package com.beyondbit.smartbox.common.serialization;

import java.io.StringWriter; 
import java.io.ByteArrayInputStream; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.TimeZone;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NamedNodeMap; 
import util.MyNode; 
import util.UtilTextContent; 
import android.util.Base64; 
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.DetailCalendar;
import com.beyondbit.smartbox.common.serialization.DetailCalendarSerializer;

public class CalendarSerializer {

	public static void AppendChildElement(Document doc, Calendar obj, Element parentElement,Class clazz) {
		if(obj.getItemID()!=null){
		Element ItemIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ItemID");
			ItemIDElement.setTextContent(obj.getItemID() + "");
		parentElement.appendChild(ItemIDElement);
		}

		if(obj.getSubject()!=null){
		Element SubjectElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Subject");
			SubjectElement.setTextContent(obj.getSubject() + "");
		parentElement.appendChild(SubjectElement);
		}

		if(obj.getHasStart()){
		Element StartElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Start");
			StartElement.setTextContent(UtilTextContent.date2String(obj.getStart().getTime()));
		parentElement.appendChild(StartElement);
		}

		if(obj.getHasEnd()){
		Element EndElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:End");
			EndElement.setTextContent(UtilTextContent.date2String(obj.getEnd().getTime()));
		parentElement.appendChild(EndElement);
		}

		if(obj.getIsAllDayEvent()!=null){
		Element IsAllDayEventElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsAllDayEvent");
			IsAllDayEventElement.setTextContent(obj.getIsAllDayEvent() + "");
		parentElement.appendChild(IsAllDayEventElement);
		}

		if(obj.getIsMeetingRequest()!=null){
		Element IsMeetingRequestElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsMeetingRequest");
			IsMeetingRequestElement.setTextContent(obj.getIsMeetingRequest() + "");
		parentElement.appendChild(IsMeetingRequestElement);
		}

		if(obj.getIsReadOnly()!=null){
		Element IsReadOnlyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsReadOnly");
			IsReadOnlyElement.setTextContent(obj.getIsReadOnly() + "");
		parentElement.appendChild(IsReadOnlyElement);
		}

		if(obj.getUserName()!=null){
		Element UserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserName");
			UserNameElement.setTextContent(obj.getUserName() + "");
		parentElement.appendChild(UserNameElement);
		}

		if(obj.getAttendees()!=null){
		Element AttendeesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Attendees");
			AttendeesElement.setTextContent(obj.getAttendees() + "");
		parentElement.appendChild(AttendeesElement);
		}

		if(obj.getAttendeNames()!=null){
		Element AttendeNamesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:AttendeNames");
			AttendeNamesElement.setTextContent(obj.getAttendeNames() + "");
		parentElement.appendChild(AttendeNamesElement);
		}

		if(obj.getOtherAttendees()!=null){
		Element OtherAttendeesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OtherAttendees");
			OtherAttendeesElement.setTextContent(obj.getOtherAttendees() + "");
		parentElement.appendChild(OtherAttendeesElement);
		}

		if(obj.getLocation()!=null){
		Element LocationElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Location");
			LocationElement.setTextContent(obj.getLocation() + "");
		parentElement.appendChild(LocationElement);
		}

		if(obj.getExtendField1()!=null){
		Element ExtendField1Element = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ExtendField1");
			ExtendField1Element.setTextContent(obj.getExtendField1() + "");
		parentElement.appendChild(ExtendField1Element);
		}

		Class<? extends Calendar> cls = obj.getClass();

		if (cls.equals(DetailCalendar.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","com:"+obj.getClass().getSimpleName());
			DetailCalendarSerializer.AppendChildElement(doc, (DetailCalendar) obj, parentElement,null);
		}
	}
	public static Calendar parseChildElement(Calendar calendar,String typeName,MyNode node,String typeNameSpace) {
		if (calendar == null)
			calendar = new Calendar();
		if (typeName.equals("DetailCalendar")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/common")) {
			calendar= new DetailCalendar();
			DetailCalendarSerializer.parseChildElement((DetailCalendar)calendar,typeName,node,typeNameSpace);
		}
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("ItemID") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setItemID(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Subject") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setSubject(n.getTextContent());
			continue;
			}
			//dateTime;
			if (n.equalsName("Start") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setStart(UtilTextContent.toCalendar(n.getTextContent()));
			continue;
			}
			//dateTime;
			if (n.equalsName("End") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setEnd(UtilTextContent.toCalendar(n.getTextContent()));
			continue;
			}
			//string;
			if (n.equalsName("IsAllDayEvent") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setIsAllDayEvent(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("IsMeetingRequest") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setIsMeetingRequest(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("IsReadOnly") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setIsReadOnly(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UserName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setUserName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Attendees") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setAttendees(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("AttendeNames") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setAttendeNames(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("OtherAttendees") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setOtherAttendees(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Location") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setLocation(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("ExtendField1") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendar.setExtendField1(n.getTextContent());
			continue;
			}
		}
		return calendar;
	}

}