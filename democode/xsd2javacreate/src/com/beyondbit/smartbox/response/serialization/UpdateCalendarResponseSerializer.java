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
import com.beyondbit.smartbox.response.UpdateCalendarResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class UpdateCalendarResponseSerializer {

	public static void AppendChildElement(Document doc, UpdateCalendarResponse obj, Element parentElement) {
		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Status");
		StatusElement.setTextContent(obj.getStatus() + "");
		parentElement.appendChild(StatusElement);

	}

}