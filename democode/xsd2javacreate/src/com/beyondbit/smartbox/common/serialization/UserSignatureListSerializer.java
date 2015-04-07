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
import com.beyondbit.smartbox.common.UserSignatureList;
import com.beyondbit.smartbox.common.UserSignature;
import com.beyondbit.smartbox.common.serialization.UserSignatureSerializer;

public class UserSignatureListSerializer {

	public static void AppendChildElement(Document doc, UserSignatureList obj, Element parentElement) {
		for(UserSignature userSignatureObj : obj.getUserSignature()){
			Element UserSignatureElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserSignature");
			UserSignatureSerializer.AppendChildElement(doc, userSignatureObj, UserSignatureElement);
			parentElement.appendChild(UserSignatureElement);
		}

	}

}