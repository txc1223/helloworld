package com.beyondbit.smartbox.ptservice.common.serialization;

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
import com.beyondbit.smartbox.ptservice.common.Unit;

public class UnitSerializer {

	public static void AppendChildElement(Document doc, Unit obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element TargetNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:TargetName");
		TargetNameElement.setTextContent(obj.getTargetName() + "");
		parentElement.appendChild(TargetNameElement);

		Element TaskNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:TaskName");
		TaskNameElement.setTextContent(obj.getTaskName() + "");
		parentElement.appendChild(TaskNameElement);

		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Status");
		StatusElement.setTextContent(obj.getStatus() + "");
		parentElement.appendChild(StatusElement);

		Element ManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Manager");
		ManagerElement.setTextContent(obj.getManager() + "");
		parentElement.appendChild(ManagerElement);

		Element ExcutorElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Excutor");
		ExcutorElement.setTextContent(obj.getExcutor() + "");
		parentElement.appendChild(ExcutorElement);

		Element ManageUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnit");
		ManageUnitElement.setTextContent(obj.getManageUnit() + "");
		parentElement.appendChild(ManageUnitElement);

		Element AccountabilityUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnit");
		AccountabilityUnitElement.setTextContent(obj.getAccountabilityUnit() + "");
		parentElement.appendChild(AccountabilityUnitElement);

		Element AccountabilityUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnitManager");
		AccountabilityUnitManagerElement.setTextContent(obj.getAccountabilityUnitManager() + "");
		parentElement.appendChild(AccountabilityUnitManagerElement);

	}

}