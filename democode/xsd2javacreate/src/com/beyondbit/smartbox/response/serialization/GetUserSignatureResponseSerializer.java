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
import com.beyondbit.smartbox.response.GetUserSignatureResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.UserSignatureList;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.UserSignatureListSerializer;

public class GetUserSignatureResponseSerializer {

	public static void AppendChildElement(Document doc, GetUserSignatureResponse obj, Element parentElement) {
		Element UserSignatureListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UserSignatureList");
		UserSignatureListSerializer.AppendChildElement(doc, obj.getUserSignatureList(), UserSignatureListElement);
		parentElement.appendChild(UserSignatureListElement);

	}

}