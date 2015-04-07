package com.beyondbit.smartbox.response.serialization;

import java.io.StringWriter; 
import java.io.ByteArrayInputStream; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.TimeZone;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NamedNodeMap; 
import util.MyNode; 
import util.UtilTextContent; 
import android.util.Base64; 
import com.beyondbit.smartbox.response.ClCheckPermissionResponse;

public class ClCheckPermissionResponseSerializer {

	public static ClCheckPermissionResponse parseChildElement(ClCheckPermissionResponse clCheckPermissionResponse,String typeName,MyNode node,String typeNameSpace) {
		if (clCheckPermissionResponse == null)
			clCheckPermissionResponse = new ClCheckPermissionResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//boolean;
			if (n.equalsName("hasDept") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			clCheckPermissionResponse.setHasDept(UtilTextContent.toBoolean(n.getTextContent()));
			continue;
			}
			//boolean;
			if (n.equalsName("hasUnit") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			clCheckPermissionResponse.setHasUnit(UtilTextContent.toBoolean(n.getTextContent()));
			continue;
			}
		}
		return clCheckPermissionResponse;
	}

}