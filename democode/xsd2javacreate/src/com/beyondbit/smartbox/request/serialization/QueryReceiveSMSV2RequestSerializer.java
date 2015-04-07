package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.QueryReceiveSMSV2Request;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryReceiveSMSV2RequestSerializer {

	public static void AppendChildElement(Document doc, QueryReceiveSMSV2Request obj, Element parentElement) {
		Element ReturnSizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ReturnSize");
		ReturnSizeElement.setTextContent(obj.getReturnSize() + "");
		parentElement.appendChild(ReturnSizeElement);

		Element BeginIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:BeginID");
		BeginIDElement.setTextContent(obj.getBeginID() + "");
		parentElement.appendChild(BeginIDElement);

		Element EndIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:EndID");
		EndIDElement.setTextContent(obj.getEndID() + "");
		parentElement.appendChild(EndIDElement);

	}

}