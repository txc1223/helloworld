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
import com.beyondbit.smartbox.ptservice.common.TaskTarget;
import com.beyondbit.smartbox.ptservice.common.File;
import com.beyondbit.smartbox.ptservice.common.serialization.FileSerializer;

public class TaskTargetSerializer {

	public static void AppendChildElement(Document doc, TaskTarget obj, Element parentElement) {
		Element CodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Code");
		CodeElement.setTextContent(obj.getCode() + "");
		parentElement.appendChild(CodeElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element StatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Status");
		StatusElement.setTextContent(obj.getStatus() + "");
		parentElement.appendChild(StatusElement);

		Element ReportStatusElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ReportStatus");
		ReportStatusElement.setTextContent(obj.getReportStatus() + "");
		parentElement.appendChild(ReportStatusElement);

		Element MonthElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Month");
		MonthElement.setTextContent(obj.getMonth() + "");
		parentElement.appendChild(MonthElement);

		Element DescriptionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Description");
		DescriptionElement.setTextContent(obj.getDescription() + "");
		parentElement.appendChild(DescriptionElement);

		Element PublishUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:PublishUnit");
		PublishUnitElement.setTextContent(obj.getPublishUnit() + "");
		parentElement.appendChild(PublishUnitElement);

		Element PublisherElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Publisher");
		PublisherElement.setTextContent(obj.getPublisher() + "");
		parentElement.appendChild(PublisherElement);

		Element EndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:EndTime");
		EndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getEndTime().getTime()));
		parentElement.appendChild(EndTimeElement);

		Element DeriveElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Derive");
		DeriveElement.setTextContent(obj.getDerive() + "");
		parentElement.appendChild(DeriveElement);

		Element TaskNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:TaskName");
		TaskNameElement.setTextContent(obj.getTaskName() + "");
		parentElement.appendChild(TaskNameElement);

		Element ProjectNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ProjectName");
		ProjectNameElement.setTextContent(obj.getProjectName() + "");
		parentElement.appendChild(ProjectNameElement);

		Element ManageUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnit");
		ManageUnitElement.setTextContent(obj.getManageUnit() + "");
		parentElement.appendChild(ManageUnitElement);

		Element RegionLeaderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:RegionLeader");
		RegionLeaderElement.setTextContent(obj.getRegionLeader() + "");
		parentElement.appendChild(RegionLeaderElement);

		Element AssistUnitCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitCode");
		AssistUnitCodeElement.setTextContent(obj.getAssistUnitCode() + "");
		parentElement.appendChild(AssistUnitCodeElement);

		Element AssistUnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitName");
		AssistUnitNameElement.setTextContent(obj.getAssistUnitName() + "");
		parentElement.appendChild(AssistUnitNameElement);

		Element AssistUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitManager");
		AssistUnitManagerElement.setTextContent(obj.getAssistUnitManager() + "");
		parentElement.appendChild(AssistUnitManagerElement);

		Element AssistUnitExcutorElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssistUnitExcutor");
		AssistUnitExcutorElement.setTextContent(obj.getAssistUnitExcutor() + "");
		parentElement.appendChild(AssistUnitExcutorElement);

		Element ManageUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnitManager");
		ManageUnitManagerElement.setTextContent(obj.getManageUnitManager() + "");
		parentElement.appendChild(ManageUnitManagerElement);

		Element ManageUnitLiaisonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ManageUnitLiaison");
		ManageUnitLiaisonElement.setTextContent(obj.getManageUnitLiaison() + "");
		parentElement.appendChild(ManageUnitLiaisonElement);

		Element AccountabilityUnitElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnit");
		AccountabilityUnitElement.setTextContent(obj.getAccountabilityUnit() + "");
		parentElement.appendChild(AccountabilityUnitElement);

		Element AccountabilityUnitManagerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnitManager");
		AccountabilityUnitManagerElement.setTextContent(obj.getAccountabilityUnitManager() + "");
		parentElement.appendChild(AccountabilityUnitManagerElement);

		Element AccountabilityUnitLiaisonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AccountabilityUnitLiaison");
		AccountabilityUnitLiaisonElement.setTextContent(obj.getAccountabilityUnitLiaison() + "");
		parentElement.appendChild(AccountabilityUnitLiaisonElement);

		Element ReportDescriptionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ReportDescription");
		ReportDescriptionElement.setTextContent(obj.getReportDescription() + "");
		parentElement.appendChild(ReportDescriptionElement);

		Element UnFinishedReasonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:UnFinishedReason");
		UnFinishedReasonElement.setTextContent(obj.getUnFinishedReason() + "");
		parentElement.appendChild(UnFinishedReasonElement);

		Element SuggestElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Suggest");
		SuggestElement.setTextContent(obj.getSuggest() + "");
		parentElement.appendChild(SuggestElement);

		Element RemarkElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Remark");
		RemarkElement.setTextContent(obj.getRemark() + "");
		parentElement.appendChild(RemarkElement);

		for(File fileObj : obj.getFile()){
			Element FileElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:File");
			FileSerializer.AppendChildElement(doc, fileObj, FileElement);
			parentElement.appendChild(FileElement);
		}

		Element AssessOpinionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AssessOpinion");
		AssessOpinionElement.setTextContent(obj.getAssessOpinion() + "");
		parentElement.appendChild(AssessOpinionElement);

	}

}