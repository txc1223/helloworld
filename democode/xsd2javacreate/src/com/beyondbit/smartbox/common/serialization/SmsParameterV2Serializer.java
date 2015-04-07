package com.beyondbit.smartbox.common.serialization;

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
import com.beyondbit.smartbox.common.SmsParameterV2;

public class SmsParameterV2Serializer {

	public static void AppendChildElement(Document doc, SmsParameterV2 obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element ValueElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Value");
		ValueElement.setTextContent(obj.getValue() + "");
		parentElement.appendChild(ValueElement);

	}

}