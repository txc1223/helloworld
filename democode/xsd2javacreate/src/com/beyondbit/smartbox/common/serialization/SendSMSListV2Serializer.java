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
import com.beyondbit.smartbox.common.SendSMSListV2;
import com.beyondbit.smartbox.common.SendSMSV2;
import com.beyondbit.smartbox.common.serialization.SendSMSV2Serializer;

public class SendSMSListV2Serializer {

	public static void AppendChildElement(Document doc, SendSMSListV2 obj, Element parentElement) {
		for(SendSMSV2 sendSMSV2Obj : obj.getSendSMSList()){
			Element SendSMSListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SendSMSList");
			SendSMSV2Serializer.AppendChildElement(doc, sendSMSV2Obj, SendSMSListElement);
			parentElement.appendChild(SendSMSListElement);
		}

	}

}