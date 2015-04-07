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
import com.beyondbit.smartbox.common.SmsInfoV2;

public class SmsInfoV2Serializer {

	public static void AppendChildElement(Document doc, SmsInfoV2 obj, Element parentElement) {
		Element SignerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Signer");
		SignerElement.setTextContent(obj.getSigner() + "");
		parentElement.appendChild(SignerElement);

		Element PriorityElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Priority");
		PriorityElement.setTextContent(obj.getPriority() + "");
		parentElement.appendChild(PriorityElement);

		Element LevelElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Level");
		LevelElement.setTextContent(obj.getLevel() + "");
		parentElement.appendChild(LevelElement);

		Element SMSContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SMSContent");
		SMSContentElement.setTextContent(obj.getSMSContent() + "");
		parentElement.appendChild(SMSContentElement);

		Element IsNeedReplyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsNeedReply");
		IsNeedReplyElement.setTextContent(obj.getIsNeedReply() + "");
		parentElement.appendChild(IsNeedReplyElement);

		Element IsNeedRemindElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsNeedRemind");
		IsNeedRemindElement.setTextContent(obj.getIsNeedRemind() + "");
		parentElement.appendChild(IsNeedRemindElement);

		Element ReplyExpireTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReplyExpireTime");
		ReplyExpireTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getReplyExpireTime().getTime()));
		parentElement.appendChild(ReplyExpireTimeElement);

		Element LinkIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:LinkID");
		LinkIDElement.setTextContent(obj.getLinkID() + "");
		parentElement.appendChild(LinkIDElement);

		Element SendModeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendMode");
		SendModeElement.setTextContent(obj.getSendMode() + "");
		parentElement.appendChild(SendModeElement);

		Element DelayTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DelayType");
		DelayTypeElement.setTextContent(obj.getDelayType() + "");
		parentElement.appendChild(DelayTypeElement);

		Element DelaySecondElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DelaySecond");
		DelaySecondElement.setTextContent(obj.getDelaySecond() + "");
		parentElement.appendChild(DelaySecondElement);

		Element DelayTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DelayTime");
		DelayTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getDelayTime().getTime()));
		parentElement.appendChild(DelayTimeElement);

		Element RepeatScopeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatScope");
		RepeatScopeElement.setTextContent(obj.getRepeatScope() + "");
		parentElement.appendChild(RepeatScopeElement);

		Element RepeatStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatStartTime");
		RepeatStartTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getRepeatStartTime().getTime()));
		parentElement.appendChild(RepeatStartTimeElement);

		Element RepeatEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatEndTime");
		RepeatEndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getRepeatEndTime().getTime()));
		parentElement.appendChild(RepeatEndTimeElement);

		Element RepeatTimesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatTimes");
		RepeatTimesElement.setTextContent(obj.getRepeatTimes() + "");
		parentElement.appendChild(RepeatTimesElement);

		Element RepeatModeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatMode");
		RepeatModeElement.setTextContent(obj.getRepeatMode() + "");
		parentElement.appendChild(RepeatModeElement);

		Element RepeatDescElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:RepeatDesc");
		RepeatDescElement.setTextContent(obj.getRepeatDesc() + "");
		parentElement.appendChild(RepeatDescElement);

	}

}