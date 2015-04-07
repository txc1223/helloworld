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
import com.beyondbit.smartbox.common.CalOrg;

public class CalOrgSerializer {

	public static void AppendChildElement(Document doc, CalOrg obj, Element parentElement) {
		Element ParentOrgIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ParentOrgId");
		ParentOrgIdElement.setTextContent(obj.getParentOrgId() + "");
		parentElement.appendChild(ParentOrgIdElement);

		Element OrgIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgId");
		OrgIdElement.setTextContent(obj.getOrgId() + "");
		parentElement.appendChild(OrgIdElement);

		Element OrgNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgName");
		OrgNameElement.setTextContent(obj.getOrgName() + "");
		parentElement.appendChild(OrgNameElement);

		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
		SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);

	}

}