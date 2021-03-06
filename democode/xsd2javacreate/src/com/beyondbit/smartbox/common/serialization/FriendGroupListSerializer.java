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
import com.beyondbit.smartbox.common.FriendGroupList;
import com.beyondbit.smartbox.common.FriendGroup;
import com.beyondbit.smartbox.common.serialization.FriendGroupSerializer;

public class FriendGroupListSerializer {

	public static void AppendChildElement(Document doc, FriendGroupList obj, Element parentElement) {
		for(FriendGroup friendGroupObj : obj.getFriendGroup()){
			Element FriendGroupElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendGroup");
			FriendGroupSerializer.AppendChildElement(doc, friendGroupObj, FriendGroupElement);
			parentElement.appendChild(FriendGroupElement);
		}

	}

}