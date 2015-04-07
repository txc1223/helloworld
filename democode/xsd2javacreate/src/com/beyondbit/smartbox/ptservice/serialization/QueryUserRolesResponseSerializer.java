package com.beyondbit.smartbox.ptservice.serialization;

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
import com.beyondbit.smartbox.ptservice.QueryUserRolesResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class QueryUserRolesResponseSerializer {

	public static void AppendChildElement(Document doc, QueryUserRolesResponse obj, Element parentElement) {
		for(String stringObj : obj.getRoleCode()){
			Element RoleCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:RoleCode");
		RoleCodeElement.setTextContent(stringObj + "");
			parentElement.appendChild(RoleCodeElement);
		}

	}

}