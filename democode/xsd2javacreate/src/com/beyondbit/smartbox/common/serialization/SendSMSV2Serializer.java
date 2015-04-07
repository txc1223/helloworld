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
import com.beyondbit.smartbox.common.SendSMSV2;

public class SendSMSV2Serializer {

	public static void AppendChildElement(Document doc, SendSMSV2 obj, Element parentElement) {
		Element SMSSendIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SMSSendID");
		SMSSendIDElement.setTextContent(obj.getSMSSendID() + "");
		parentElement.appendChild(SMSSendIDElement);

		Element SubjectNoElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SubjectNo");
		SubjectNoElement.setTextContent(obj.getSubjectNo() + "");
		parentElement.appendChild(SubjectNoElement);

		Element SendTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendTime");
		SendTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getSendTime().getTime()));
		parentElement.appendChild(SendTimeElement);

		Element FirstReceiverElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FirstReceiver");
		FirstReceiverElement.setTextContent(obj.getFirstReceiver() + "");
		parentElement.appendChild(FirstReceiverElement);

		Element SMSContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SMSContent");
		SMSContentElement.setTextContent(obj.getSMSContent() + "");
		parentElement.appendChild(SMSContentElement);

		Element SendStatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendStatus");
		SendStatusElement.setTextContent(obj.getSendStatus() + "");
		parentElement.appendChild(SendStatusElement);

		Element IsLockedElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsLocked");
		IsLockedElement.setTextContent(obj.getIsLocked() + "");
		parentElement.appendChild(IsLockedElement);

		Element ReplayCountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReplayCount");
		ReplayCountElement.setTextContent(obj.getReplayCount() + "");
		parentElement.appendChild(ReplayCountElement);

		Element CreateTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CreateTime");
		CreateTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getCreateTime().getTime()));
		parentElement.appendChild(CreateTimeElement);

	}

}