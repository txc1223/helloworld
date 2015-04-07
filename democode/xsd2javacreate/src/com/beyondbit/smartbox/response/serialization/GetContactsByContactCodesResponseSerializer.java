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
import com.beyondbit.smartbox.response.GetContactsByContactCodesResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.ContactList;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.ContactListSerializer;

public class GetContactsByContactCodesResponseSerializer {

	public static void AppendChildElement(Document doc, GetContactsByContactCodesResponse obj, Element parentElement) {
		Element ContactListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:ContactList");
		ContactListSerializer.AppendChildElement(doc, obj.getContactList(), ContactListElement);
		parentElement.appendChild(ContactListElement);

	}

}