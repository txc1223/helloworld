package com.beyondbit.smartbox.ptservice.common.serialization;

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
import com.beyondbit.smartbox.ptservice.common.File;

public class FileSerializer {

	public static void AppendChildElement(Document doc, File obj, Element parentElement) {
		Element FileNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:FileName");
		FileNameElement.setTextContent(obj.getFileName() + "");
		parentElement.appendChild(FileNameElement);

		Element PublishUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:PublishUnit");
		PublishUnitElement.setTextContent(obj.getPublishUnit() + "");
		parentElement.appendChild(PublishUnitElement);

		Element PublisherElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Publisher");
		PublisherElement.setTextContent(obj.getPublisher() + "");
		parentElement.appendChild(PublisherElement);

		Element PublishDateElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:PublishDate");
		PublishDateElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getPublishDate().getTime()));
		parentElement.appendChild(PublishDateElement);

	}

}