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
import com.beyondbit.smartbox.request.QueryCalendarsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryCalendarsRequestSerializer {

	public static void AppendChildElement(Document doc, QueryCalendarsRequest obj, Element parentElement,Class clazz) {
		if(obj.getUserUid()!=null){
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
			UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);
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

		if(obj.getSubject()!=null){
		Element SubjectElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Subject");
			SubjectElement.setTextContent(obj.getSubject() + "");
		parentElement.appendChild(SubjectElement);
		}

		if(obj.getHasIsPrecise()){
		Element IsPreciseElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:IsPrecise");
			IsPreciseElement.setTextContent(obj.getIsPrecise() + "");
		parentElement.appendChild(IsPreciseElement);
		}

		if(obj.getCalendarType()!=null){
		Element CalendarTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:CalendarType");
			CalendarTypeElement.setTextContent(obj.getCalendarType() + "");
		parentElement.appendChild(CalendarTypeElement);
		}

		if(obj.getDeptCode()!=null){
		Element DeptCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DeptCode");
			DeptCodeElement.setTextContent(obj.getDeptCode() + "");
		parentElement.appendChild(DeptCodeElement);
		}

		if(obj.getHasPageSize()){
		Element PageSizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageSize");
			PageSizeElement.setTextContent(obj.getPageSize() + "");
		parentElement.appendChild(PageSizeElement);
		}

		if(obj.getHasPageIndex()){
		Element PageIndexElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageIndex");
			PageIndexElement.setTextContent(obj.getPageIndex() + "");
		parentElement.appendChild(PageIndexElement);
		}

	}

}