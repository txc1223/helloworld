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
import com.beyondbit.smartbox.common.OAAttachment;

public class OAAttachmentSerializer {

	public static void AppendChildElement(Document doc, OAAttachment obj, Element parentElement) {
		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element FileNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FileName");
		FileNameElement.setTextContent(obj.getFileName() + "");
		parentElement.appendChild(FileNameElement);

		Element ContentTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContentType");
		ContentTypeElement.setTextContent(obj.getContentType() + "");
		parentElement.appendChild(ContentTypeElement);

		Element ContentSizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContentSize");
		ContentSizeElement.setTextContent(obj.getContentSize() + "");
		parentElement.appendChild(ContentSizeElement);

		Element SendTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendTime");
		SendTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getSendTime().getTime()));
		parentElement.appendChild(SendTimeElement);

		Element KindElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Kind");
		KindElement.setTextContent(obj.getKind() + "");
		parentElement.appendChild(KindElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

	}

}