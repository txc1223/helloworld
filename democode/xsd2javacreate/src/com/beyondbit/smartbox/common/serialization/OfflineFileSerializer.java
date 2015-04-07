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
import com.beyondbit.smartbox.common.OfflineFile;

public class OfflineFileSerializer {

	public static void AppendChildElement(Document doc, OfflineFile obj, Element parentElement) {
		Element IdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Id");
		IdElement.setTextContent(obj.getId() + "");
		parentElement.appendChild(IdElement);

		Element DataIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DataId");
		DataIdElement.setTextContent(obj.getDataId() + "");
		parentElement.appendChild(DataIdElement);

		Element DisplayNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DisplayName");
		DisplayNameElement.setTextContent(obj.getDisplayName() + "");
		parentElement.appendChild(DisplayNameElement);

		Element FromElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:From");
		FromElement.setTextContent(obj.getFrom() + "");
		parentElement.appendChild(FromElement);

		Element ToElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:To");
		ToElement.setTextContent(obj.getTo() + "");
		parentElement.appendChild(ToElement);

		Element BeginTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:BeginTime");
		BeginTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getBeginTime().getTime()));
		parentElement.appendChild(BeginTimeElement);

		Element UrlElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Url");
		UrlElement.setTextContent(obj.getUrl() + "");
		parentElement.appendChild(UrlElement);

		Element SizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Size");
		SizeElement.setTextContent(obj.getSize() + "");
		parentElement.appendChild(SizeElement);

	}

}