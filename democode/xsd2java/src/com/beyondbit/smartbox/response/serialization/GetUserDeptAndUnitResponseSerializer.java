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
import com.beyondbit.smartbox.response.GetUserDeptAndUnitResponse;

public class GetUserDeptAndUnitResponseSerializer {

	public static GetUserDeptAndUnitResponse parseChildElement(GetUserDeptAndUnitResponse getUserDeptAndUnitResponse,String typeName,MyNode node,String typeNameSpace) {
		if (getUserDeptAndUnitResponse == null)
			getUserDeptAndUnitResponse = new GetUserDeptAndUnitResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("DeptId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			getUserDeptAndUnitResponse.setDeptId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("DeptName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			getUserDeptAndUnitResponse.setDeptName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UnitId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			getUserDeptAndUnitResponse.setUnitId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UnitName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			getUserDeptAndUnitResponse.setUnitName(n.getTextContent());
			continue;
			}
		}
		return getUserDeptAndUnitResponse;
	}

}