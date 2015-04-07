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
import com.beyondbit.smartbox.ptservice.common.Task;

public class TaskSerializer {

	public static void AppendChildElement(Document doc, Task obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Status");
		StatusElement.setTextContent(obj.getStatus() + "");
		parentElement.appendChild(StatusElement);

		Element AccountabilityUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnit");
		AccountabilityUnitElement.setTextContent(obj.getAccountabilityUnit() + "");
		parentElement.appendChild(AccountabilityUnitElement);

		Element ProjectNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ProjectName");
		ProjectNameElement.setTextContent(obj.getProjectName() + "");
		parentElement.appendChild(ProjectNameElement);

		Element ManageUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnit");
		ManageUnitElement.setTextContent(obj.getManageUnit() + "");
		parentElement.appendChild(ManageUnitElement);

		Element RegionLeaderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:RegionLeader");
		RegionLeaderElement.setTextContent(obj.getRegionLeader() + "");
		parentElement.appendChild(RegionLeaderElement);

		Element CreateUserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:CreateUserName");
		CreateUserNameElement.setTextContent(obj.getCreateUserName() + "");
		parentElement.appendChild(CreateUserNameElement);

		Element UpdateUserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:UpdateUserName");
		UpdateUserNameElement.setTextContent(obj.getUpdateUserName() + "");
		parentElement.appendChild(UpdateUserNameElement);

	}

}