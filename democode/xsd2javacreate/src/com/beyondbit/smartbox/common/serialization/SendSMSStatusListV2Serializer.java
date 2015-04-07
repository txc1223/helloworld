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
import com.beyondbit.smartbox.common.SendSMSStatusListV2;
import com.beyondbit.smartbox.common.SendSMSStatusV2;
import com.beyondbit.smartbox.common.serialization.SendSMSStatusV2Serializer;

public class SendSMSStatusListV2Serializer {

	public static void AppendChildElement(Document doc, SendSMSStatusListV2 obj, Element parentElement) {
		for(SendSMSStatusV2 sendSMSStatusV2Obj : obj.getSendSMSStatusList()){
			Element SendSMSStatusListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendSMSStatusList");
			SendSMSStatusV2Serializer.AppendChildElement(doc, sendSMSStatusV2Obj, SendSMSStatusListElement);
			parentElement.appendChild(SendSMSStatusListElement);
		}

	}

}