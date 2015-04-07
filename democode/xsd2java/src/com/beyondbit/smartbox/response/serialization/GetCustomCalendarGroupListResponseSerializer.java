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
import com.beyondbit.smartbox.response.GetCustomCalendarGroupListResponse;
import com.beyondbit.smartbox.common.CalendarGroup;
import com.beyondbit.smartbox.common.serialization.CalendarGroupSerializer;

public class GetCustomCalendarGroupListResponseSerializer {

	public static GetCustomCalendarGroupListResponse parseChildElement(GetCustomCalendarGroupListResponse getCustomCalendarGroupListResponse,String typeName,MyNode node,String typeNameSpace) {
		ArrayList<CalendarGroup> calendarGroupListData=new ArrayList<CalendarGroup> ();
		if (getCustomCalendarGroupListResponse == null)
			getCustomCalendarGroupListResponse = new GetCustomCalendarGroupListResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//CalendarGroup;
		if (n.equalsName("CalendarGroup") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
		calendarGroupListData.add((CalendarGroup)CalendarGroupSerializer.parseChildElement(null,"CalendarGroup",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
		}

		}
		getCustomCalendarGroupListResponse.setCalendarGroup(calendarGroupListData.toArray(new CalendarGroup[calendarGroupListData.size()]));
		return getCustomCalendarGroupListResponse;
	}

}