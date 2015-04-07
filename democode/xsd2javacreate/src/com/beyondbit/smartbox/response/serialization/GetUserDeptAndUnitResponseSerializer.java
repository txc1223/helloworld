package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.GetUserDeptAndUnitResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class GetUserDeptAndUnitResponseSerializer {

	public static void AppendChildElement(Document doc, GetUserDeptAndUnitResponse obj, Element parentElement) {
		Element DeptIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:DeptId");
		DeptIdElement.setTextContent(obj.getDeptId() + "");
		parentElement.appendChild(DeptIdElement);

		Element DeptNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:DeptName");
		DeptNameElement.setTextContent(obj.getDeptName() + "");
		parentElement.appendChild(DeptNameElement);

		Element UnitIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UnitId");
		UnitIdElement.setTextContent(obj.getUnitId() + "");
		parentElement.appendChild(UnitIdElement);

		Element UnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UnitName");
		UnitNameElement.setTextContent(obj.getUnitName() + "");
		parentElement.appendChild(UnitNameElement);

	}

}