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
import com.beyondbit.smartbox.request.UpdateCalendarRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.DetailCalendar;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;

public class UpdateCalendarRequestSerializer {

	public static void AppendChildElement(Document doc, UpdateCalendarRequest obj, Element parentElement,Class clazz) {
		if(obj.getUserUid()!=null){
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
			UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);
		}

		if(obj.getCalendarType()!=null){
		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
			CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
		parentElement.appendChild(CalendarTypeElement);
		}

		if(obj.getHasDetailCalendar()){
		Element DetailCalendarElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DetailCalendar");
			CalendarSerializer.AppendChildElement(doc, obj.getDetailCalendar(), DetailCalendarElement,DetailCalendar.class);
		parentElement.appendChild(DetailCalendarElement);
		}

	}

}