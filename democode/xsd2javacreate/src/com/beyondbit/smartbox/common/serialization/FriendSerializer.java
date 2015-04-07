package com.beyondbit.smartbox.common.serialization;

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
import com.beyondbit.smartbox.common.Friend;

public class FriendSerializer {

	public static void AppendChildElement(Document doc, Friend obj, Element parentElement) {
		Element FriendGroupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendGroupId");
		FriendGroupIdElement.setTextContent(obj.getFriendGroupId() + "");
		parentElement.appendChild(FriendGroupIdElement);

		Element OwnerUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OwnerUid");
		OwnerUidElement.setTextContent(obj.getOwnerUid() + "");
		parentElement.appendChild(OwnerUidElement);

		Element FriendUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendUid");
		FriendUidElement.setTextContent(obj.getFriendUid() + "");
		parentElement.appendChild(FriendUidElement);

		Element FriendUserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendUserName");
		FriendUserNameElement.setTextContent(obj.getFriendUserName() + "");
		parentElement.appendChild(FriendUserNameElement);

		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
		SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);

	}

}