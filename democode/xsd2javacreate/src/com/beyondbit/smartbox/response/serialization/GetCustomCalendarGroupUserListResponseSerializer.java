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
import com.beyondbit.smartbox.response.GetCustomCalendarGroupUserListResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.User;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.UserSerializer;

public class GetCustomCalendarGroupUserListResponseSerializer {

	public static void AppendChildElement(Document doc, GetCustomCalendarGroupUserListResponse obj, Element parentElement) {
		for(User userObj : obj.getUser()){
			Element UserElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:User");
			UserSerializer.AppendChildElement(doc, userObj, UserElement);
			parentElement.appendChild(UserElement);
		}

	}

}