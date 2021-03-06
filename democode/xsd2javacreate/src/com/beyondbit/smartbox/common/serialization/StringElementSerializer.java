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
import com.beyondbit.smartbox.common.StringElement;
import com.beyondbit.smartbox.common.ElementBase;
import com.beyondbit.smartbox.common.serialization.ElementBaseSerializer;

public class StringElementSerializer {

	public static void AppendChildElement(Document doc, StringElement obj, Element parentElement) {
		Element ValueElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Value");
		ValueElement.setTextContent(obj.getValue() + "");
		parentElement.appendChild(ValueElement);

	}

}