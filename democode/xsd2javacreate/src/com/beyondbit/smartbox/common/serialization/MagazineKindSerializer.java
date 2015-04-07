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
import com.beyondbit.smartbox.common.MagazineKind;

public class MagazineKindSerializer {

	public static void AppendChildElement(Document doc, MagazineKind obj, Element parentElement) {
		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element PublishTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishTime");
		PublishTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getPublishTime().getTime()));
		parentElement.appendChild(PublishTimeElement);

		Element PublishUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishUnit");
		PublishUnitElement.setTextContent(obj.getPublishUnit() + "");
		parentElement.appendChild(PublishUnitElement);

		Element PublisherElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Publisher");
		PublisherElement.setTextContent(obj.getPublisher() + "");
		parentElement.appendChild(PublisherElement);

		Element CountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Count");
		CountElement.setTextContent(obj.getCount() + "");
		parentElement.appendChild(CountElement);

		Element UnreadCountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UnreadCount");
		UnreadCountElement.setTextContent(obj.getUnreadCount() + "");
		parentElement.appendChild(UnreadCountElement);

	}

}