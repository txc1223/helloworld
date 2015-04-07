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
import com.beyondbit.smartbox.common.SmsSignerListV2;
import com.beyondbit.smartbox.common.SmsSignerV2;
import com.beyondbit.smartbox.common.serialization.SmsSignerV2Serializer;

public class SmsSignerListV2Serializer {

	public static void AppendChildElement(Document doc, SmsSignerListV2 obj, Element parentElement) {
		for(SmsSignerV2 smsSignerV2Obj : obj.getSignerList()){
			Element SignerListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SignerList");
			SmsSignerV2Serializer.AppendChildElement(doc, smsSignerV2Obj, SignerListElement);
			parentElement.appendChild(SignerListElement);
		}

	}

}