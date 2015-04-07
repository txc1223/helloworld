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
import com.beyondbit.smartbox.common.ReceiveSMSV2;
import com.beyondbit.smartbox.common.SmsPersonV2;
import com.beyondbit.smartbox.common.serialization.SmsPersonV2Serializer;

public class ReceiveSMSV2Serializer {

	public static void AppendChildElement(Document doc, ReceiveSMSV2 obj, Element parentElement) {
		Element ReceiveIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReceiveID");
		ReceiveIDElement.setTextContent(obj.getReceiveID() + "");
		parentElement.appendChild(ReceiveIDElement);

		Element LinkSendIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:LinkSendID");
		LinkSendIDElement.setTextContent(obj.getLinkSendID() + "");
		parentElement.appendChild(LinkSendIDElement);

		Element SubjectNoElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SubjectNo");
		SubjectNoElement.setTextContent(obj.getSubjectNo() + "");
		parentElement.appendChild(SubjectNoElement);

		Element SenderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sender");
		SmsPersonV2Serializer.AppendChildElement(doc, obj.getSender(), SenderElement);
		parentElement.appendChild(SenderElement);

		Element SMSContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SMSContent");
		SMSContentElement.setTextContent(obj.getSMSContent() + "");
		parentElement.appendChild(SMSContentElement);

		Element ReceiveTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReceiveTime");
		ReceiveTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getReceiveTime().getTime()));
		parentElement.appendChild(ReceiveTimeElement);

	}

}