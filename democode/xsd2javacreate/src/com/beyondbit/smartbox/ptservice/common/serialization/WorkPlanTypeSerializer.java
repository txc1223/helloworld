package com.beyondbit.smartbox.ptservice.common.serialization;

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
import com.beyondbit.smartbox.ptservice.common.WorkPlanType;

public class WorkPlanTypeSerializer {

	public static void AppendChildElement(Document doc, WorkPlanType obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

	}

}