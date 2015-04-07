package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.FriendInviteRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.FriendInviteType;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.FriendInviteTypeSerializer;

public class FriendInviteRequestSerializer {

	public static void AppendChildElement(Document doc, FriendInviteRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Type");
		FriendInviteTypeSerializer.AppendChildElement(doc, obj.getType(), TypeElement);
		parentElement.appendChild(TypeElement);

		Element MessageElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Message");
		MessageElement.setTextContent(obj.getMessage() + "");
		parentElement.appendChild(MessageElement);

	}

}