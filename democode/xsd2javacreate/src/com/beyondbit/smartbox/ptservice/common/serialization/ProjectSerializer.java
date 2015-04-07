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
import com.beyondbit.smartbox.ptservice.common.Project;
import com.beyondbit.smartbox.ptservice.common.MonthStatus;
import com.beyondbit.smartbox.ptservice.common.Unit;
import com.beyondbit.smartbox.ptservice.common.serialization.MonthStatusSerializer;
import com.beyondbit.smartbox.ptservice.common.serialization.UnitSerializer;

public class ProjectSerializer {

	public static void AppendChildElement(Document doc, Project obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element CategoryElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Category");
		CategoryElement.setTextContent(obj.getCategory() + "");
		parentElement.appendChild(CategoryElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Type");
		TypeElement.setTextContent(obj.getType() + "");
		parentElement.appendChild(TypeElement);

		Element ShortNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ShortName");
		ShortNameElement.setTextContent(obj.getShortName() + "");
		parentElement.appendChild(ShortNameElement);

		Element TypeNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:TypeName");
		TypeNameElement.setTextContent(obj.getTypeName() + "");
		parentElement.appendChild(TypeNameElement);

		Element AccountabilityUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnit");
		AccountabilityUnitElement.setTextContent(obj.getAccountabilityUnit() + "");
		parentElement.appendChild(AccountabilityUnitElement);

		for(MonthStatus monthStatusObj : obj.getMonthStatus()){
			Element MonthStatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:MonthStatus");
			MonthStatusSerializer.AppendChildElement(doc, monthStatusObj, MonthStatusElement);
			parentElement.appendChild(MonthStatusElement);
		}

		for(Unit unitObj : obj.getAssistUnit()){
			Element AssistUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnit");
			UnitSerializer.AppendChildElement(doc, unitObj, AssistUnitElement);
			parentElement.appendChild(AssistUnitElement);
		}

		Element IsYhwqElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:IsYhwq");
		IsYhwqElement.setTextContent(obj.getIsYhwq() + "");
		parentElement.appendChild(IsYhwqElement);

		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Status");
		StatusElement.setTextContent(obj.getStatus() + "");
		parentElement.appendChild(StatusElement);

		Element BeginTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:BeginTime");
		BeginTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getBeginTime().getTime()));
		parentElement.appendChild(BeginTimeElement);

		Element EndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:EndTime");
		EndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getEndTime().getTime()));
		parentElement.appendChild(EndTimeElement);

		Element RegionLeaderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:RegionLeader");
		RegionLeaderElement.setTextContent(obj.getRegionLeader() + "");
		parentElement.appendChild(RegionLeaderElement);

		Element ManageUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnit");
		ManageUnitElement.setTextContent(obj.getManageUnit() + "");
		parentElement.appendChild(ManageUnitElement);

		Element ManageUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnitManager");
		ManageUnitManagerElement.setTextContent(obj.getManageUnitManager() + "");
		parentElement.appendChild(ManageUnitManagerElement);

		Element ManageUnitLiaisonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnitLiaison");
		ManageUnitLiaisonElement.setTextContent(obj.getManageUnitLiaison() + "");
		parentElement.appendChild(ManageUnitLiaisonElement);

		Element AccountabilityUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnitManager");
		AccountabilityUnitManagerElement.setTextContent(obj.getAccountabilityUnitManager() + "");
		parentElement.appendChild(AccountabilityUnitManagerElement);

		Element AccountabilityUnitLiaisonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnitLiaison");
		AccountabilityUnitLiaisonElement.setTextContent(obj.getAccountabilityUnitLiaison() + "");
		parentElement.appendChild(AccountabilityUnitLiaisonElement);

		Element AssistUnitManagersElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitManagers");
		AssistUnitManagersElement.setTextContent(obj.getAssistUnitManagers() + "");
		parentElement.appendChild(AssistUnitManagersElement);

		Element AssistUnitExcutorsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitExcutors");
		AssistUnitExcutorsElement.setTextContent(obj.getAssistUnitExcutors() + "");
		parentElement.appendChild(AssistUnitExcutorsElement);

		Element DescriptionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Description");
		DescriptionElement.setTextContent(obj.getDescription() + "");
		parentElement.appendChild(DescriptionElement);

		Element AttachedFilesElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AttachedFiles");
		AttachedFilesElement.setTextContent(obj.getAttachedFiles() + "");
		parentElement.appendChild(AttachedFilesElement);

		Element CreateUserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:CreateUserName");
		CreateUserNameElement.setTextContent(obj.getCreateUserName() + "");
		parentElement.appendChild(CreateUserNameElement);

		Element UpdateUserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:UpdateUserName");
		UpdateUserNameElement.setTextContent(obj.getUpdateUserName() + "");
		parentElement.appendChild(UpdateUserNameElement);

	}

}