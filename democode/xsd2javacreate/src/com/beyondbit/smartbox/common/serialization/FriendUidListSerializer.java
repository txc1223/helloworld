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
import com.beyondbit.smartbox.common.FriendUidList;

public class FriendUidListSerializer {

	public static void AppendChildElement(Document doc, FriendUidList obj, Element parentElement) {
		for(String stringObj : obj.getFriendUid()){
			Element FriendUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FriendUid");
		FriendUidElement.setTextContent(stringObj + "");
			parentElement.appendChild(FriendUidElement);
		}

	}

}