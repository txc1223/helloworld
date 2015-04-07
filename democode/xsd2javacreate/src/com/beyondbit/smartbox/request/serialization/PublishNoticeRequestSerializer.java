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
import com.beyondbit.smartbox.request.PublishNoticeRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class PublishNoticeRequestSerializer {

	public static void AppendChildElement(Document doc, PublishNoticeRequest obj, Element parentElement) {
		Element TitleElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Title");
		TitleElement.setTextContent(obj.getTitle() + "");
		parentElement.appendChild(TitleElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

		Element PublicScopeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PublicScope");
		PublicScopeElement.setTextContent(obj.getPublicScope() + "");
		parentElement.appendChild(PublicScopeElement);

		Element RecieversElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Recievers");
		RecieversElement.setTextContent(obj.getRecievers() + "");
		parentElement.appendChild(RecieversElement);

		Element BeginTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:BeginTime");
		BeginTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getBeginTime().getTime()));
		parentElement.appendChild(BeginTimeElement);

		Element ExpireTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ExpireTime");
		ExpireTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getExpireTime().getTime()));
		parentElement.appendChild(ExpireTimeElement);

	}

}