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
import com.beyondbit.smartbox.ptservice.ProcessTaskTargetRetrialRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class ProcessTaskTargetRetrialRequestSerializer {

	public static void AppendChildElement(Document doc, ProcessTaskTargetRetrialRequest obj, Element parentElement) {
		Element TaskTargetCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:TaskTargetCode");
		TaskTargetCodeElement.setTextContent(obj.getTaskTargetCode() + "");
		parentElement.appendChild(TaskTargetCodeElement);

		Element AcceptElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Accept");
		AcceptElement.setTextContent(obj.getAccept() + "");
		parentElement.appendChild(AcceptElement);

		Element AcceptContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:AcceptContent");
		AcceptContentElement.setTextContent(obj.getAcceptContent() + "");
		parentElement.appendChild(AcceptContentElement);

		Element EndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:EndTime");
		EndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getEndTime().getTime()));
		parentElement.appendChild(EndTimeElement);

		Element MethodElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Method");
		MethodElement.setTextContent(obj.getMethod() + "");
		parentElement.appendChild(MethodElement);

	}

}