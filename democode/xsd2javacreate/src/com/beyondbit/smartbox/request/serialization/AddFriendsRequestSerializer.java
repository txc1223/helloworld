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
import com.beyondbit.smartbox.request.AddFriendsRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.FriendList;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.FriendListSerializer;

public class AddFriendsRequestSerializer {

	public static void AppendChildElement(Document doc, AddFriendsRequest obj, Element parentElement) {
		Element FriendListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:FriendList");
		FriendListSerializer.AppendChildElement(doc, obj.getFriendList(), FriendListElement);
		parentElement.appendChild(FriendListElement);

		Element groupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:groupId");
		groupIdElement.setTextContent(obj.getGroupId() + "");
		parentElement.appendChild(groupIdElement);

	}

}