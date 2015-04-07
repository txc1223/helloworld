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
import com.beyondbit.smartbox.common.ContactCategoryList;
import com.beyondbit.smartbox.common.ContactCategory;
import com.beyondbit.smartbox.common.serialization.ContactCategorySerializer;

public class ContactCategoryListSerializer {

	public static void AppendChildElement(Document doc, ContactCategoryList obj, Element parentElement) {
		for(ContactCategory contactCategoryObj : obj.getContactCategory()){
			Element ContactCategoryElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactCategory");
			ContactCategorySerializer.AppendChildElement(doc, contactCategoryObj, ContactCategoryElement);
			parentElement.appendChild(ContactCategoryElement);
		}

	}

}