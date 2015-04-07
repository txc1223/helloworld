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
import com.beyondbit.smartbox.response.QuerySubUsersResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.CalUser;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.CalUserSerializer;

public class QuerySubUsersResponseSerializer {

	public static void AppendChildElement(Document doc, QuerySubUsersResponse obj, Element parentElement) {
		for(CalUser calUserObj : obj.getCalUser()){
			Element CalUserElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:CalUser");
			CalUserSerializer.AppendChildElement(doc, calUserObj, CalUserElement);
			parentElement.appendChild(CalUserElement);
		}

	}

}