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
import com.beyondbit.smartbox.response.QueryCalendarsByOrgCodesResponse;
import com.beyondbit.smartbox.common.OrgCalendar;
import com.beyondbit.smartbox.common.serialization.OrgCalendarSerializer;

public class QueryCalendarsByOrgCodesResponseSerializer {

	public static QueryCalendarsByOrgCodesResponse parseChildElement(QueryCalendarsByOrgCodesResponse queryCalendarsByOrgCodesResponse,String typeName,MyNode node,String typeNameSpace) {
		ArrayList<OrgCalendar> orgCalendarListData=new ArrayList<OrgCalendar> ();
		if (queryCalendarsByOrgCodesResponse == null)
			queryCalendarsByOrgCodesResponse = new QueryCalendarsByOrgCodesResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//OrgCalendar;
		if (n.equalsName("OrgCalendar") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
		orgCalendarListData.add((OrgCalendar)OrgCalendarSerializer.parseChildElement(null,"OrgCalendar",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
		}

		}
		queryCalendarsByOrgCodesResponse.setOrgCalendar(orgCalendarListData.toArray(new OrgCalendar[orgCalendarListData.size()]));
		return queryCalendarsByOrgCodesResponse;
	}

}