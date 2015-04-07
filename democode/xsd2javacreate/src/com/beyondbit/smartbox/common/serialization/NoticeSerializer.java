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
import com.beyondbit.smartbox.common.Notice;

public class NoticeSerializer {

	public static void AppendChildElement(Document doc, Notice obj, Element parentElement) {
		Element NoticeIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:NoticeId");
		NoticeIdElement.setTextContent(obj.getNoticeId() + "");
		parentElement.appendChild(NoticeIdElement);

		Element TitleElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Title");
		TitleElement.setTextContent(obj.getTitle() + "");
		parentElement.appendChild(TitleElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

		Element PublicScopeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublicScope");
		PublicScopeElement.setTextContent(obj.getPublicScope() + "");
		parentElement.appendChild(PublicScopeElement);

		Element PublishUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishUid");
		PublishUidElement.setTextContent(obj.getPublishUid() + "");
		parentElement.appendChild(PublishUidElement);

		Element PublishTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PublishTime");
		PublishTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getPublishTime().getTime()));
		parentElement.appendChild(PublishTimeElement);

		Element PublisherElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Publisher");
		PublisherElement.setTextContent(obj.getPublisher() + "");
		parentElement.appendChild(PublisherElement);

		Element FirstReadTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FirstReadTime");
		FirstReadTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getFirstReadTime().getTime()));
		parentElement.appendChild(FirstReadTimeElement);

		Element BeginTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:BeginTime");
		BeginTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getBeginTime().getTime()));
		parentElement.appendChild(BeginTimeElement);

		Element ExpireTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ExpireTime");
		ExpireTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getExpireTime().getTime()));
		parentElement.appendChild(ExpireTimeElement);

	}

}