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
import com.beyondbit.smartbox.common.FriendList;
import com.beyondbit.smartbox.common.Friend;
import com.beyondbit.smartbox.common.serialization.FriendSerializer;

public class FriendListSerializer {

	public static void AppendChildElement(Document doc, FriendList obj, Element parentElement) {
		for(Friend friendObj : obj.getFriend()){
			Element FriendElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Friend");
			FriendSerializer.AppendChildElement(doc, friendObj, FriendElement);
			parentElement.appendChild(FriendElement);
		}

	}

}