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
import com.beyondbit.smartbox.common.SmsSignerV2;

public class SmsSignerV2Serializer {

	public static void AppendChildElement(Document doc, SmsSignerV2 obj, Element parentElement) {
		Element SignerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Signer");
		SignerElement.setTextContent(obj.getSigner() + "");
		parentElement.appendChild(SignerElement);

	}

}