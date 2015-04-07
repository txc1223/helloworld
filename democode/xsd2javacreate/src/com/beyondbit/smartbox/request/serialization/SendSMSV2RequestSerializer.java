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
import com.beyondbit.smartbox.request.SendSMSV2Request;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.SmsPersonListV2;
import com.beyondbit.smartbox.common.SmsInfoV2;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.SmsPersonListV2Serializer;
import com.beyondbit.smartbox.common.serialization.SmsInfoV2Serializer;

public class SendSMSV2RequestSerializer {

	public static void AppendChildElement(Document doc, SendSMSV2Request obj, Element parentElement) {
		Element ReceiverListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ReceiverList");
		SmsPersonListV2Serializer.AppendChildElement(doc, obj.getReceiverList(), ReceiverListElement);
		parentElement.appendChild(ReceiverListElement);

		Element SmsInfoElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:SmsInfo");
		SmsInfoV2Serializer.AppendChildElement(doc, obj.getSmsInfo(), SmsInfoElement);
		parentElement.appendChild(SmsInfoElement);

	}

}