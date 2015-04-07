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
import com.beyondbit.smartbox.response.SendSMSStatusDetailRemindEventV2Response;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.SendSMSStatusV2;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.SendSMSStatusV2Serializer;

public class SendSMSStatusDetailRemindEventV2ResponseSerializer {

	public static void AppendChildElement(Document doc, SendSMSStatusDetailRemindEventV2Response obj, Element parentElement) {
		Element SendSMSStatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:SendSMSStatus");
		SendSMSStatusV2Serializer.AppendChildElement(doc, obj.getSendSMSStatus(), SendSMSStatusElement);
		parentElement.appendChild(SendSMSStatusElement);

	}

}