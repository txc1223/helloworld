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
import com.beyondbit.smartbox.common.SmsPersonListV2;
import com.beyondbit.smartbox.common.SmsPersonV2;
import com.beyondbit.smartbox.common.serialization.SmsPersonV2Serializer;

public class SmsPersonListV2Serializer {

	public static void AppendChildElement(Document doc, SmsPersonListV2 obj, Element parentElement) {
		for(SmsPersonV2 smsPersonV2Obj : obj.getPersons()){
			Element PersonsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Persons");
			SmsPersonV2Serializer.AppendChildElement(doc, smsPersonV2Obj, PersonsElement);
			parentElement.appendChild(PersonsElement);
		}

	}

}