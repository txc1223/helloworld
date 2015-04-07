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
import com.beyondbit.smartbox.common.SmsIdListV2;
import com.beyondbit.smartbox.common.SmsIdV2;
import com.beyondbit.smartbox.common.serialization.SmsIdV2Serializer;

public class SmsIdListV2Serializer {

	public static void AppendChildElement(Document doc, SmsIdListV2 obj, Element parentElement) {
		for(SmsIdV2 smsIdV2Obj : obj.getSmsIdList()){
			Element SmsIdListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SmsIdList");
			SmsIdV2Serializer.AppendChildElement(doc, smsIdV2Obj, SmsIdListElement);
			parentElement.appendChild(SmsIdListElement);
		}

	}

}