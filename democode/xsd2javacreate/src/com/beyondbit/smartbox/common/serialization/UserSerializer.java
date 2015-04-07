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
import com.beyondbit.smartbox.common.User;

public class UserSerializer {

	public static void AppendChildElement(Document doc, User obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element UserFullNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserFullName");
		UserFullNameElement.setTextContent(obj.getUserFullName() + "");
		parentElement.appendChild(UserFullNameElement);

		Element DeptCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptCode");
		DeptCodeElement.setTextContent(obj.getDeptCode() + "");
		parentElement.appendChild(DeptCodeElement);

		Element DeptNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:DeptName");
		DeptNameElement.setTextContent(obj.getDeptName() + "");
		parentElement.appendChild(DeptNameElement);

		Element UintCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UintCode");
		UintCodeElement.setTextContent(obj.getUintCode() + "");
		parentElement.appendChild(UintCodeElement);

		Element UnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UnitName");
		UnitNameElement.setTextContent(obj.getUnitName() + "");
		parentElement.appendChild(UnitNameElement);

	}

}