package com.beyondbit.smartbox.ptservice.serialization;

import java.io.ByteArrayOutputStream; 
import java.text.SimpleDateFormat; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.bootstrap.DOMImplementationRegistry; 
import org.w3c.dom.ls.DOMImplementationLS; 
import org.w3c.dom.ls.LSOutput; 
import org.w3c.dom.ls.LSSerializer; 
import com.beyondbit.smartbox.ptservice.AcceptMonthReportRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class AcceptMonthReportRequestSerializer {

	public static void AppendChildElement(Document doc, AcceptMonthReportRequest obj, Element parentElement) {
		Element MonthReportCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:MonthReportCode");
		MonthReportCodeElement.setTextContent(obj.getMonthReportCode() + "");
		parentElement.appendChild(MonthReportCodeElement);

		Element RemarkElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Remark");
		RemarkElement.setTextContent(obj.getRemark() + "");
		parentElement.appendChild(RemarkElement);

		Element ActionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Action");
		ActionElement.setTextContent(obj.getAction() + "");
		parentElement.appendChild(ActionElement);

	}

}