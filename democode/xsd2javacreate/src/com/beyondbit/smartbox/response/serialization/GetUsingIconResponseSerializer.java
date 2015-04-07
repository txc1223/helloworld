package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.GetUsingIconResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class GetUsingIconResponseSerializer {

	public static void AppendChildElement(Document doc, GetUsingIconResponse obj, Element parentElement) {
		Element IconCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:IconCode");
		IconCodeElement.setTextContent(obj.getIconCode() + "");
		parentElement.appendChild(IconCodeElement);

		Element IconElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Icon");
		IconElement.setTextContent(obj.getIcon() + "");
		parentElement.appendChild(IconElement);

	}

}