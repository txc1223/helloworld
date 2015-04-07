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
import com.beyondbit.smartbox.common.OrgCalendar;
import com.beyondbit.smartbox.common.CalendarList;
import com.beyondbit.smartbox.common.serialization.CalendarListSerializer;

public class OrgCalendarSerializer {

	public static void AppendChildElement(Document doc, OrgCalendar obj, Element parentElement,Class clazz) {
		if(obj.getOrgCode()!=null){
		Element OrgCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgCode");
			OrgCodeElement.setTextContent(obj.getOrgCode() + "");
		parentElement.appendChild(OrgCodeElement);
		}

		if(obj.getHasCalendarList()){
		Element CalendarListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CalendarList");
			CalendarListSerializer.AppendChildElement(doc, obj.getCalendarList(), CalendarListElement,CalendarList.class);
		parentElement.appendChild(CalendarListElement);
		}

	}
	public static OrgCalendar parseChildElement(OrgCalendar orgCalendar,String typeName,MyNode node,String typeNameSpace) {
		if (orgCalendar == null)
			orgCalendar = new OrgCalendar();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("OrgCode") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			orgCalendar.setOrgCode(n.getTextContent());
			continue;
			}
			//CalendarList;
			if (n.equalsName("CalendarList") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			orgCalendar.setCalendarList((CalendarList)CalendarListSerializer.parseChildElement(null,"CalendarList",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
			}
		}
		return orgCalendar;
	}

}