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
import com.beyondbit.smartbox.common.ContactGroup;

public class ContactGroupSerializer {

	public static void AppendChildElement(Document doc, ContactGroup obj, Element parentElement) {
		Element ContactGroupCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactGroupCode");
		ContactGroupCodeElement.setTextContent(obj.getContactGroupCode() + "");
		parentElement.appendChild(ContactGroupCodeElement);

		Element ContactGroupNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactGroupName");
		ContactGroupNameElement.setTextContent(obj.getContactGroupName() + "");
		parentElement.appendChild(ContactGroupNameElement);

		Element ContactGroupHasChildElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactGroupHasChild");
		ContactGroupHasChildElement.setTextContent(obj.getContactGroupHasChild() + "");
		parentElement.appendChild(ContactGroupHasChildElement);

	}

}