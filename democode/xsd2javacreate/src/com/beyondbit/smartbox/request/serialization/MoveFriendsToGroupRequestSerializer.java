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
import com.beyondbit.smartbox.request.MoveFriendsToGroupRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.FriendUidList;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.FriendUidListSerializer;

public class MoveFriendsToGroupRequestSerializer {

	public static void AppendChildElement(Document doc, MoveFriendsToGroupRequest obj, Element parentElement) {
		Element FriendUidListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:FriendUidList");
		FriendUidListSerializer.AppendChildElement(doc, obj.getFriendUidList(), FriendUidListElement);
		parentElement.appendChild(FriendUidListElement);

		Element groupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:groupId");
		groupIdElement.setTextContent(obj.getGroupId() + "");
		parentElement.appendChild(groupIdElement);

	}

}