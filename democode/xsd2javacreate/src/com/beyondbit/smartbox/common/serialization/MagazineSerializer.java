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
import com.beyondbit.smartbox.common.Magazine;

public class MagazineSerializer {

	public static void AppendChildElement(Document doc, Magazine obj, Element parentElement) {
		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element NoElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:No");
		NoElement.setTextContent(obj.getNo() + "");
		parentElement.appendChild(NoElement);

		Element ReadedElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Readed");
		ReadedElement.setTextContent(obj.getReaded() + "");
		parentElement.appendChild(ReadedElement);

		Element VisitedCountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:VisitedCount");
		VisitedCountElement.setTextContent(obj.getVisitedCount() + "");
		parentElement.appendChild(VisitedCountElement);

		Element PublishTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishTime");
		PublishTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getPublishTime().getTime()));
		parentElement.appendChild(PublishTimeElement);

	}

}