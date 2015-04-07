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
import com.beyondbit.smartbox.ptservice.UpdateWorkPlanRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class UpdateWorkPlanRequestSerializer {

	public static void AppendChildElement(Document doc, UpdateWorkPlanRequest obj, Element parentElement) {
		Element IdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Id");
		IdElement.setTextContent(obj.getId() + "");
		parentElement.appendChild(IdElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Type");
		TypeElement.setTextContent(obj.getType() + "");
		parentElement.appendChild(TypeElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

		Element AddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Address");
		AddressElement.setTextContent(obj.getAddress() + "");
		parentElement.appendChild(AddressElement);

		Element BeginTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:BeginTime");
		BeginTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getBeginTime().getTime()));
		parentElement.appendChild(BeginTimeElement);

		Element EndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:EndTime");
		EndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getEndTime().getTime()));
		parentElement.appendChild(EndTimeElement);

	}

}