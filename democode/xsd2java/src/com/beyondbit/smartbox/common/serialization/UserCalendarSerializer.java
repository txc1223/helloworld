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
import com.beyondbit.smartbox.common.UserCalendar;
import com.beyondbit.smartbox.common.CalendarList;
import com.beyondbit.smartbox.common.serialization.CalendarListSerializer;

public class UserCalendarSerializer {

	public static void AppendChildElement(Document doc, UserCalendar obj, Element parentElement,Class clazz) {
		if(obj.getUserUid()!=null){
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
			UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);
		}

		if(obj.getHasCalendarList()){
		Element CalendarListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CalendarList");
			CalendarListSerializer.AppendChildElement(doc, obj.getCalendarList(), CalendarListElement,CalendarList.class);
		parentElement.appendChild(CalendarListElement);
		}

	}
	public static UserCalendar parseChildElement(UserCalendar userCalendar,String typeName,MyNode node,String typeNameSpace) {
		if (userCalendar == null)
			userCalendar = new UserCalendar();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("UserUid") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userCalendar.setUserUid(n.getTextContent());
			continue;
			}
			//CalendarList;
			if (n.equalsName("CalendarList") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userCalendar.setCalendarList((CalendarList)CalendarListSerializer.parseChildElement(null,"CalendarList",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
			}
		}
		return userCalendar;
	}

}