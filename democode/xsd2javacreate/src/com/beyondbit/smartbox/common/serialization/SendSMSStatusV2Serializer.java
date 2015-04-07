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
import com.beyondbit.smartbox.common.SendSMSStatusV2;
import com.beyondbit.smartbox.common.SmsPersonV2;
import com.beyondbit.smartbox.common.serialization.SmsPersonV2Serializer;

public class SendSMSStatusV2Serializer {

	public static void AppendChildElement(Document doc, SendSMSStatusV2 obj, Element parentElement) {
		Element SMSSendIDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SMSSendID");
		SMSSendIDElement.setTextContent(obj.getSMSSendID() + "");
		parentElement.appendChild(SMSSendIDElement);

		Element ReceiverElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Receiver");
		SmsPersonV2Serializer.AppendChildElement(doc, obj.getReceiver(), ReceiverElement);
		parentElement.appendChild(ReceiverElement);

		Element DeviceNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeviceName");
		DeviceNameElement.setTextContent(obj.getDeviceName() + "");
		parentElement.appendChild(DeviceNameElement);

		Element DeviceCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeviceCode");
		DeviceCodeElement.setTextContent(obj.getDeviceCode() + "");
		parentElement.appendChild(DeviceCodeElement);

		Element SendStatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendStatus");
		SendStatusElement.setTextContent(obj.getSendStatus() + "");
		parentElement.appendChild(SendStatusElement);

	}

}