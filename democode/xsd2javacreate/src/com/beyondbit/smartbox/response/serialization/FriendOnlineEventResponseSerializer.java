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
import com.beyondbit.smartbox.response.FriendOnlineEventResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class FriendOnlineEventResponseSerializer {

	public static void AppendChildElement(Document doc, FriendOnlineEventResponse obj, Element parentElement) {
		Element FriendUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:FriendUid");
		FriendUidElement.setTextContent(obj.getFriendUid() + "");
		parentElement.appendChild(FriendUidElement);

	}

}