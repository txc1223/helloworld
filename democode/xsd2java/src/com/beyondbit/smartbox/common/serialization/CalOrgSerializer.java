package com.beyondbit.smartbox.common.serialization;

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
import com.beyondbit.smartbox.common.CalOrg;

public class CalOrgSerializer {

	public static void AppendChildElement(Document doc, CalOrg obj, Element parentElement,Class clazz) {
		if(obj.getParentOrgId()!=null){
		Element ParentOrgIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ParentOrgId");
			ParentOrgIdElement.setTextContent(obj.getParentOrgId() + "");
		parentElement.appendChild(ParentOrgIdElement);
		}

		if(obj.getOrgId()!=null){
		Element OrgIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgId");
			OrgIdElement.setTextContent(obj.getOrgId() + "");
		parentElement.appendChild(OrgIdElement);
		}

		if(obj.getOrgName()!=null){
		Element OrgNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgName");
			OrgNameElement.setTextContent(obj.getOrgName() + "");
		parentElement.appendChild(OrgNameElement);
		}

		if(obj.getHasSequence()){
		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
			SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);
		}

	}
	public static CalOrg parseChildElement(CalOrg calOrg,String typeName,MyNode node,String typeNameSpace) {
		if (calOrg == null)
			calOrg = new CalOrg();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("ParentOrgId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calOrg.setParentOrgId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("OrgId") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calOrg.setOrgId(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("OrgName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calOrg.setOrgName(n.getTextContent());
			continue;
			}
			//int;
			if (n.equalsName("Sequence") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			calOrg.setSequence(UtilTextContent.toInt(n.getTextContent()));
			continue;
			}
		}
		return calOrg;
	}

}