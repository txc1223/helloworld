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
import com.beyondbit.smartbox.common.ReceiveSMSListV2;
import com.beyondbit.smartbox.common.ReceiveSMSV2;
import com.beyondbit.smartbox.common.serialization.ReceiveSMSV2Serializer;

public class ReceiveSMSListV2Serializer {

	public static void AppendChildElement(Document doc, ReceiveSMSListV2 obj, Element parentElement) {
		for(ReceiveSMSV2 receiveSMSV2Obj : obj.getReceiveSMSList()){
			Element ReceiveSMSListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ReceiveSMSList");
			ReceiveSMSV2Serializer.AppendChildElement(doc, receiveSMSV2Obj, ReceiveSMSListElement);
			parentElement.appendChild(ReceiveSMSListElement);
		}

	}

}