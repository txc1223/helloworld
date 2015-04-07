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
import com.beyondbit.smartbox.request.ModFriendGroupRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.common.FriendGroup;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;
import com.beyondbit.smartbox.common.serialization.FriendGroupSerializer;

public class ModFriendGroupRequestSerializer {

	public static void AppendChildElement(Document doc, ModFriendGroupRequest obj, Element parentElement) {
		Element FriendGroupElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:FriendGroup");
		FriendGroupSerializer.AppendChildElement(doc, obj.getFriendGroup(), FriendGroupElement);
		parentElement.appendChild(FriendGroupElement);

	}

}