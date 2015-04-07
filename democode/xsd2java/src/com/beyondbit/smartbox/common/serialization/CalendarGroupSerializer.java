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
import com.beyondbit.smartbox.common.CalendarGroup;

public class CalendarGroupSerializer {

	public static void AppendChildElement(Document doc, CalendarGroup obj, Element parentElement,Class clazz) {
		if(obj.getGroupId()!=null){
		Element GroupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupId");
			GroupIdElement.setTextContent(obj.getGroupId() + "");
		parentElement.appendChild(GroupIdElement);
		}

		if(obj.getGroupName()!=null){
		Element GroupNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupName");
			GroupNameElement.setTextContent(obj.getGroupName() + "");
		parentElement.appendChild(GroupNameElement);
		}

	}
	public static CalendarGroup parseChildElement(CalendarGroup calendarGroup,String typeName,MyNode node,String typeNameSpace) {
		if (calendarGroup == null)
			calendarGroup = new CalendarGroup();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("GroupId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendarGroup.setGroupId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("GroupName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calendarGroup.setGroupName(n.getTextContent());
			continue;
			}
		}
		return calendarGroup;
	}

}