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
import com.beyondbit.smartbox.common.FriendGroup;
import com.beyondbit.smartbox.common.GroupType;
import com.beyondbit.smartbox.common.serialization.GroupTypeSerializer;

public class FriendGroupSerializer {

	public static void AppendChildElement(Document doc, FriendGroup obj, Element parentElement) {
		Element FriendGroupIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendGroupId");
		FriendGroupIdElement.setTextContent(obj.getFriendGroupId() + "");
		parentElement.appendChild(FriendGroupIdElement);

		Element GroupNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupName");
		GroupNameElement.setTextContent(obj.getGroupName() + "");
		parentElement.appendChild(GroupNameElement);

		Element OwnerUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OwnerUid");
		OwnerUidElement.setTextContent(obj.getOwnerUid() + "");
		parentElement.appendChild(OwnerUidElement);

		Element GroupTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GroupType");
		GroupTypeSerializer.AppendChildElement(doc, obj.getGroupType(), GroupTypeElement);
		parentElement.appendChild(GroupTypeElement);

		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
		SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);

	}

}