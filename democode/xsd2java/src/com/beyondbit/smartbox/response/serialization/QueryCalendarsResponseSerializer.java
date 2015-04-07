package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.QueryCalendarsResponse;
import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class QueryCalendarsResponseSerializer {

	public static QueryCalendarsResponse parseChildElement(QueryCalendarsResponse queryCalendarsResponse,String typeName,MyNode node,String typeNameSpace) {
		ArrayList<Calendar> calendarListData=new ArrayList<Calendar> ();
		if (queryCalendarsResponse == null)
			queryCalendarsResponse = new QueryCalendarsResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//Calendar;
		if (n.equalsName("Calendar") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
		calendarListData.add((Calendar)CalendarSerializer.parseChildElement(null,"Calendar",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
		}

			//int;
			if (n.equalsName("ContactTotal") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			queryCalendarsResponse.setContactTotal(UtilTextContent.toInt(n.getTextContent()));
			continue;
			}
		}
		queryCalendarsResponse.setCalendar(calendarListData.toArray(new Calendar[calendarListData.size()]));
		return queryCalendarsResponse;
	}

}