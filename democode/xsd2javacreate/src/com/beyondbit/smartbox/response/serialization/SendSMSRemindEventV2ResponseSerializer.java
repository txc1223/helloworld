package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.SendSMSRemindEventV2Response;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.SendSMSV2;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.SendSMSV2Serializer;

public class SendSMSRemindEventV2ResponseSerializer {

	public static void AppendChildElement(Document doc, SendSMSRemindEventV2Response obj, Element parentElement) {
		Element SendSMSElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:SendSMS");
		SendSMSV2Serializer.AppendChildElement(doc, obj.getSendSMS(), SendSMSElement);
		parentElement.appendChild(SendSMSElement);

	}

}