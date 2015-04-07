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
import com.beyondbit.smartbox.common.DetailCalendar;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class DetailCalendarSerializer {

	public static void AppendChildElement(Document doc, DetailCalendar obj, Element parentElement,Class clazz) {
		if(obj.getInstanceType()!=null){
		Element InstanceTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:InstanceType");
			InstanceTypeElement.setTextContent(obj.getInstanceType() + "");
		parentElement.appendChild(InstanceTypeElement);
		}

		if(obj.getUserID()!=null){
		Element UserIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserID");
			UserIDElement.setTextContent(obj.getUserID() + "");
		parentElement.appendChild(UserIDElement);
		}

		if(obj.getBody()!=null){
		Element BodyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Body");
			BodyElement.setTextContent(obj.getBody() + "");
		parentElement.appendChild(BodyElement);
		}

		if(obj.getRecurring()!=null){
		Element RecurringElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Recurring");
			RecurringElement.setTextContent(obj.getRecurring() + "");
		parentElement.appendChild(RecurringElement);
		}

		if(obj.getDeptId()!=null){
		Element DeptIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptId");
			DeptIdElement.setTextContent(obj.getDeptId() + "");
		parentElement.appendChild(DeptIdElement);
		}

		if(obj.getDeptName()!=null){
		Element DeptNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptName");
			DeptNameElement.setTextContent(obj.getDeptName() + "");
		parentElement.appendChild(DeptNameElement);
		}

		if(obj.getCatagories()!=null){
		Element CatagoriesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Catagories");
			CatagoriesElement.setTextContent(obj.getCatagories() + "");
		parentElement.appendChild(CatagoriesElement);
		}

		if(obj.getIsReminder()!=null){
		Element IsReminderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsReminder");
			IsReminderElement.setTextContent(obj.getIsReminder() + "");
		parentElement.appendChild(IsReminderElement);
		}

		if(obj.getHasReminderOffset()){
		Element ReminderOffsetElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReminderOffset");
			ReminderOffsetElement.setTextContent(obj.getReminderOffset() + "");
		parentElement.appendChild(ReminderOffsetElement);
		}

		if(obj.getReminderType()!=null){
		Element ReminderTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReminderType");
			ReminderTypeElement.setTextContent(obj.getReminderType() + "");
		parentElement.appendChild(ReminderTypeElement);
		}

	}
	public static DetailCalendar parseChildElement(DetailCalendar detailCalendar,String typeName,MyNode node,String typeNameSpace) {
		if (detailCalendar == null)
			detailCalendar = new DetailCalendar();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("InstanceType") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setInstanceType(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UserID") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setUserID(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Body") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setBody(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Recurring") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setRecurring(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("DeptId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setDeptId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("DeptName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setDeptName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("Catagories") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setCatagories(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("IsReminder") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setIsReminder(n.getTextContent());
			continue;
			}
			//int;
			if (n.equalsName("ReminderOffset") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setReminderOffset(UtilTextContent.toInt(n.getTextContent()));
			continue;
			}
			//string;
			if (n.equalsName("ReminderType") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			detailCalendar.setReminderType(n.getTextContent());
			continue;
			}
		}
		return detailCalendar;
	}

}