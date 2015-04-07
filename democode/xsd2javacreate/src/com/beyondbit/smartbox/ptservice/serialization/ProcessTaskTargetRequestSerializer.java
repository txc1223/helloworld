package com.beyondbit.smartbox.ptservice.serialization;

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
import com.beyondbit.smartbox.ptservice.ProcessTaskTargetRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class ProcessTaskTargetRequestSerializer {

	public static void AppendChildElement(Document doc, ProcessTaskTargetRequest obj, Element parentElement) {
		Element TaskTargetCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:TaskTargetCode");
		TaskTargetCodeElement.setTextContent(obj.getTaskTargetCode() + "");
		parentElement.appendChild(TaskTargetCodeElement);

		Element FinishElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Finish");
		FinishElement.setTextContent(obj.getFinish() + "");
		parentElement.appendChild(FinishElement);

		Element UnFinishedReasonElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:UnFinishedReason");
		UnFinishedReasonElement.setTextContent(obj.getUnFinishedReason() + "");
		parentElement.appendChild(UnFinishedReasonElement);

		Element SuggestElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Suggest");
		SuggestElement.setTextContent(obj.getSuggest() + "");
		parentElement.appendChild(SuggestElement);

		Element ReportDescriptionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:ReportDescription");
		ReportDescriptionElement.setTextContent(obj.getReportDescription() + "");
		parentElement.appendChild(ReportDescriptionElement);

		Element MethodElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Method");
		MethodElement.setTextContent(obj.getMethod() + "");
		parentElement.appendChild(MethodElement);

	}

}