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
import com.beyondbit.smartbox.common.ContactGroupList;
import com.beyondbit.smartbox.common.ContactGroup;
import com.beyondbit.smartbox.common.serialization.ContactGroupSerializer;

public class ContactGroupListSerializer {

	public static void AppendChildElement(Document doc, ContactGroupList obj, Element parentElement) {
		for(ContactGroup contactGroupObj : obj.getContactGroup()){
			Element ContactGroupElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactGroup");
			ContactGroupSerializer.AppendChildElement(doc, contactGroupObj, ContactGroupElement);
			parentElement.appendChild(ContactGroupElement);
		}

	}

}