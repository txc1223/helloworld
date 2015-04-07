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
import com.beyondbit.smartbox.ptservice.QueryAssistUnitsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryAssistUnitsRequestSerializer {

	public static void AppendChildElement(Document doc, QueryAssistUnitsRequest obj, Element parentElement) {
		Element ProjectCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:ProjectCode");
		ProjectCodeElement.setTextContent(obj.getProjectCode() + "");
		parentElement.appendChild(ProjectCodeElement);

		Element AssistUnitCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:AssistUnitCode");
		AssistUnitCodeElement.setTextContent(obj.getAssistUnitCode() + "");
		parentElement.appendChild(AssistUnitCodeElement);

	}

}