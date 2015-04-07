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
import com.beyondbit.smartbox.common.ContactList;
import com.beyondbit.smartbox.common.Contact;
import com.beyondbit.smartbox.common.serialization.ContactSerializer;

public class ContactListSerializer {

	public static void AppendChildElement(Document doc, ContactList obj, Element parentElement) {
		for(Contact contactObj : obj.getContact()){
			Element ContactElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Contact");
			ContactSerializer.AppendChildElement(doc, contactObj, ContactElement);
			parentElement.appendChild(ContactElement);
		}

	}

}