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
import com.beyondbit.smartbox.common.CalendarList;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class CalendarListSerializer {

	public static void AppendChildElement(Document doc, CalendarList obj, Element parentElement,Class clazz) {
		for(Calendar calendarObj : obj.getCalendar()){
			Element CalendarElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Calendar");
			CalendarSerializer.AppendChildElement(doc, calendarObj, CalendarElement,Calendar.class);
			parentElement.appendChild(CalendarElement);
		}

	}
	public static CalendarList parseChildElement(CalendarList calendarList,String typeName,MyNode node,String typeNameSpace) {
		ArrayList<Calendar> calendarListData=new ArrayList<Calendar> ();
		if (calendarList == null)
			calendarList = new CalendarList();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//Calendar;
		if (n.equalsName("Calendar") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
		calendarListData.add((Calendar)CalendarSerializer.parseChildElement(null,"Calendar",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
		}

		}
		calendarList.setCalendar(calendarListData.toArray(new Calendar[calendarListData.size()]));
		return calendarList;
	}

}