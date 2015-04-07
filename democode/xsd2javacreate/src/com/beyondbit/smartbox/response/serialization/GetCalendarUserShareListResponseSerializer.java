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
import com.beyondbit.smartbox.response.GetCalendarUserShareListResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.UserShare;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.UserShareSerializer;

public class GetCalendarUserShareListResponseSerializer {

	public static void AppendChildElement(Document doc, GetCalendarUserShareListResponse obj, Element parentElement) {
		for(UserShare userShareObj : obj.getUserShare()){
			Element UserShareElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UserShare");
			UserShareSerializer.AppendChildElement(doc, userShareObj, UserShareElement);
			parentElement.appendChild(UserShareElement);
		}

	}

}