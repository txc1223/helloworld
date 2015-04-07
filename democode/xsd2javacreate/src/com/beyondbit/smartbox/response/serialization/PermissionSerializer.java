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
import com.beyondbit.smartbox.response.Permission;

public class PermissionSerializer {

	public static void AppendChildElement(Document doc, Permission obj, Element parentElement) {
		Element PrivilegeCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:PrivilegeCode");
		PrivilegeCodeElement.setTextContent(obj.getPrivilegeCode() + "");
		parentElement.appendChild(PrivilegeCodeElement);

		Element AccessableElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Accessable");
		AccessableElement.setTextContent(obj.getAccessable() + "");
		parentElement.appendChild(AccessableElement);

	}

}