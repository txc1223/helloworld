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
import com.beyondbit.smartbox.response.FriendInviteResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.FriendInviteType;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.FriendInviteTypeSerializer;

public class FriendInviteResponseSerializer {

	public static void AppendChildElement(Document doc, FriendInviteResponse obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Type");
		FriendInviteTypeSerializer.AppendChildElement(doc, obj.getType(), TypeElement);
		parentElement.appendChild(TypeElement);

		Element MessageElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Message");
		MessageElement.setTextContent(obj.getMessage() + "");
		parentElement.appendChild(MessageElement);

	}

}