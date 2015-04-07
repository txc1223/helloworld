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
import com.beyondbit.smartbox.common.ContactCategory;
import com.beyondbit.smartbox.common.CategoryType;
import com.beyondbit.smartbox.common.serialization.CategoryTypeSerializer;

public class ContactCategorySerializer {

	public static void AppendChildElement(Document doc, ContactCategory obj, Element parentElement) {
		Element ContactCategoryCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactCategoryCode");
		ContactCategoryCodeElement.setTextContent(obj.getContactCategoryCode() + "");
		parentElement.appendChild(ContactCategoryCodeElement);

		Element ContactCategoryNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactCategoryName");
		ContactCategoryNameElement.setTextContent(obj.getContactCategoryName() + "");
		parentElement.appendChild(ContactCategoryNameElement);

		Element CategoryTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CategoryType");
		CategoryTypeSerializer.AppendChildElement(doc, obj.getCategoryType(), CategoryTypeElement);
		parentElement.appendChild(CategoryTypeElement);

	}

}