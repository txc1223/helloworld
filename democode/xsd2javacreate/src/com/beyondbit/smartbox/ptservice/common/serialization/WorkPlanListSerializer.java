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
import com.beyondbit.smartbox.ptservice.common.WorkPlanList;
import com.beyondbit.smartbox.ptservice.common.WorkPlan;
import com.beyondbit.smartbox.ptservice.common.serialization.WorkPlanSerializer;

public class WorkPlanListSerializer {

	public static void AppendChildElement(Document doc, WorkPlanList obj, Element parentElement) {
		for(WorkPlan workPlanObj : obj.getAMList()){
			Element AMListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:AMList");
			WorkPlanSerializer.AppendChildElement(doc, workPlanObj, AMListElement);
			parentElement.appendChild(AMListElement);
		}

		for(WorkPlan workPlanObj : obj.getPMList()){
			Element PMListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:PMList");
			WorkPlanSerializer.AppendChildElement(doc, workPlanObj, PMListElement);
			parentElement.appendChild(PMListElement);
		}

	}

}