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
import com.beyondbit.smartbox.common.CallBoard;

public class CallBoardSerializer {

	public static void AppendChildElement(Document doc, CallBoard obj, Element parentElement) {
		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element TitleElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Title");
		TitleElement.setTextContent(obj.getTitle() + "");
		parentElement.appendChild(TitleElement);

		Element PublishDeptElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishDept");
		PublishDeptElement.setTextContent(obj.getPublishDept() + "");
		parentElement.appendChild(PublishDeptElement);

		Element PublisherElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Publisher");
		PublisherElement.setTextContent(obj.getPublisher() + "");
		parentElement.appendChild(PublisherElement);

		Element PublishTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishTime");
		PublishTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getPublishTime().getTime()));
		parentElement.appendChild(PublishTimeElement);

		Element DisableTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DisableTime");
		DisableTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getDisableTime().getTime()));
		parentElement.appendChild(DisableTimeElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Type");
		TypeElement.setTextContent(obj.getType() + "");
		parentElement.appendChild(TypeElement);

		Element ReadedElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Readed");
		ReadedElement.setTextContent(obj.getReaded() + "");
		parentElement.appendChild(ReadedElement);

	}

}