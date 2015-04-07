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
import com.beyondbit.smartbox.common.UserShare;

public class UserShareSerializer {

	public static void AppendChildElement(Document doc, UserShare obj, Element parentElement,Class clazz) {
		if(obj.getUserUid()!=null){
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
			UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);
		}

		if(obj.getUserFullName()!=null){
		Element UserFullNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserFullName");
			UserFullNameElement.setTextContent(obj.getUserFullName() + "");
		parentElement.appendChild(UserFullNameElement);
		}

		if(obj.getDeptCode()!=null){
		Element DeptCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptCode");
			DeptCodeElement.setTextContent(obj.getDeptCode() + "");
		parentElement.appendChild(DeptCodeElement);
		}

		if(obj.getDeptName()!=null){
		Element DeptNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptName");
			DeptNameElement.setTextContent(obj.getDeptName() + "");
		parentElement.appendChild(DeptNameElement);
		}

		if(obj.getUintCode()!=null){
		Element UintCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UintCode");
			UintCodeElement.setTextContent(obj.getUintCode() + "");
		parentElement.appendChild(UintCodeElement);
		}

		if(obj.getUnitName()!=null){
		Element UnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UnitName");
			UnitNameElement.setTextContent(obj.getUnitName() + "");
		parentElement.appendChild(UnitNameElement);
		}

		if(obj.getIsCanEdit()!=null){
		Element IsCanEditElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IsCanEdit");
			IsCanEditElement.setTextContent(obj.getIsCanEdit() + "");
		parentElement.appendChild(IsCanEditElement);
		}

	}
	public static UserShare parseChildElement(UserShare userShare,String typeName,MyNode node,String typeNameSpace) {
		if (userShare == null)
			userShare = new UserShare();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//string;
			if (n.equalsName("UserUid") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setUserUid(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UserFullName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setUserFullName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("DeptCode") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setDeptCode(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("DeptName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setDeptName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UintCode") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setUintCode(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("UnitName") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setUnitName(n.getTextContent());
			continue;
			}
			//string;
			if (n.equalsName("IsCanEdit") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/common")) {
			userShare.setIsCanEdit(n.getTextContent());
			continue;
			}
		}
		return userShare;
	}

}