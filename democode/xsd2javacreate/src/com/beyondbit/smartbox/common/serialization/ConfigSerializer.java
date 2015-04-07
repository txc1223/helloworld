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
import com.beyondbit.smartbox.common.Config;

public class ConfigSerializer {

	public static void AppendChildElement(Document doc, Config obj, Element parentElement) {
		Element KeyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Key");
		KeyElement.setTextContent(obj.getKey() + "");
		parentElement.appendChild(KeyElement);

		Element ValueElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Value");
		ValueElement.setTextContent(obj.getValue() + "");
		parentElement.appendChild(ValueElement);

	}

}