package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.QueryCalendarsByUserUIdsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryCalendarsByUserUIdsRequestSerializer {

	public static void AppendChildElement(Document doc, QueryCalendarsByUserUIdsRequest obj, Element parentElement,Class clazz) {
		if(obj.getUserUids()!=null){
		Element UserUidsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUids");
			UserUidsElement.setTextContent(obj.getUserUids() + "");
		parentElement.appendChild(UserUidsElement);
		}

		if(obj.getHasViewStartTime()){
		Element ViewStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewStartTime");
			ViewStartTimeElement.setTextContent(UtilTextContent.date2String(obj.getViewStartTime().getTime()));
		parentElement.appendChild(ViewStartTimeElement);
		}

		if(obj.getHasViewEndTime()){
		Element ViewEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewEndTime");
			ViewEndTimeElement.setTextContent(UtilTextContent.date2String(obj.getViewEndTime().getTime()));
		parentElement.appendChild(ViewEndTimeElement);
		}

	}

}