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
import com.beyondbit.smartbox.ptservice.QueryTaskTargetRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryTaskTargetRequestSerializer {

	public static void AppendChildElement(Document doc, QueryTaskTargetRequest obj, Element parentElement) {
		Element TaskCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:TaskCode");
		TaskCodeElement.setTextContent(obj.getTaskCode() + "");
		parentElement.appendChild(TaskCodeElement);

	}

}