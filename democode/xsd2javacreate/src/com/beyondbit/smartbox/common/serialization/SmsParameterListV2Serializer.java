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
import com.beyondbit.smartbox.common.SmsParameterListV2;
import com.beyondbit.smartbox.common.SmsParameterV2;
import com.beyondbit.smartbox.common.serialization.SmsParameterV2Serializer;

public class SmsParameterListV2Serializer {

	public static void AppendChildElement(Document doc, SmsParameterListV2 obj, Element parentElement) {
		for(SmsParameterV2 smsParameterV2Obj : obj.getParameterList()){
			Element ParameterListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ParameterList");
			SmsParameterV2Serializer.AppendChildElement(doc, smsParameterV2Obj, ParameterListElement);
			parentElement.appendChild(ParameterListElement);
		}

	}

}