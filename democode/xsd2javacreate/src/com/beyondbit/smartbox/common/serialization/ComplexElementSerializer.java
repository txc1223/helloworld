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
import com.beyondbit.smartbox.common.ComplexElement;
import com.beyondbit.smartbox.common.ElementBase;
import com.beyondbit.smartbox.common.ElementKeyValue;
import com.beyondbit.smartbox.common.serialization.ElementBaseSerializer;
import com.beyondbit.smartbox.common.serialization.ElementKeyValueSerializer;

public class ComplexElementSerializer {

	public static void AppendChildElement(Document doc, ComplexElement obj, Element parentElement) {
		for(ElementKeyValue elementKeyValueObj : obj.getProperty()){
			Element PropertyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Property");
			ElementKeyValueSerializer.AppendChildElement(doc, elementKeyValueObj, PropertyElement);
			parentElement.appendChild(PropertyElement);
		}

	}

}