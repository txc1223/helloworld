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
import com.beyondbit.smartbox.ptservice.SubmitWorkPlanRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class SubmitWorkPlanRequestSerializer {

	public static void AppendChildElement(Document doc, SubmitWorkPlanRequest obj, Element parentElement) {
		Element IdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Id");
		IdElement.setTextContent(obj.getId() + "");
		parentElement.appendChild(IdElement);

		Element RemarkElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Remark");
		RemarkElement.setTextContent(obj.getRemark() + "");
		parentElement.appendChild(RemarkElement);

	}

}