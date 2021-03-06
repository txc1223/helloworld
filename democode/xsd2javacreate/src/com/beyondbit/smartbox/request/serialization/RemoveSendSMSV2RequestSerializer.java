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
import com.beyondbit.smartbox.request.RemoveSendSMSV2Request;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.SmsIdListV2;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.SmsIdListV2Serializer;

public class RemoveSendSMSV2RequestSerializer {

	public static void AppendChildElement(Document doc, RemoveSendSMSV2Request obj, Element parentElement) {
		Element SendSMSIDListV2Element = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:SendSMSIDListV2");
		SmsIdListV2Serializer.AppendChildElement(doc, obj.getSendSMSIDListV2(), SendSMSIDListV2Element);
		parentElement.appendChild(SendSMSIDListV2Element);

	}

}