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
import com.beyondbit.smartbox.response.CheckPermissionResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.Permission;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.PermissionSerializer;

public class CheckPermissionResponseSerializer {

	public static void AppendChildElement(Document doc, CheckPermissionResponse obj, Element parentElement) {
		Element PermissionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Permission");
		PermissionSerializer.AppendChildElement(doc, obj.getPermission(), PermissionElement);
		parentElement.appendChild(PermissionElement);

	}

}