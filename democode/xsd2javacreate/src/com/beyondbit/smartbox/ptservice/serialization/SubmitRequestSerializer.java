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
import com.beyondbit.smartbox.ptservice.SubmitRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.ComplexElement;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.ComplexElementSerializer;

public class SubmitRequestSerializer {

	public static void AppendChildElement(Document doc, SubmitRequest obj, Element parentElement) {
		Element ModuleElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Module");
		ModuleElement.setTextContent(obj.getModule() + "");
		parentElement.appendChild(ModuleElement);

		Element MethodElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Method");
		MethodElement.setTextContent(obj.getMethod() + "");
		parentElement.appendChild(MethodElement);

		Element SubmitItemElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:SubmitItem");
		ComplexElementSerializer.AppendChildElement(doc, obj.getSubmitItem(), SubmitItemElement);
		parentElement.appendChild(SubmitItemElement);

	}

}