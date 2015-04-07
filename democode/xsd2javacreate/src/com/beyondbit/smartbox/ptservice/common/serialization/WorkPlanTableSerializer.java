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
import com.beyondbit.smartbox.ptservice.common.WorkPlanTable;
import com.beyondbit.smartbox.ptservice.common.WorkPlanList;
import com.beyondbit.smartbox.ptservice.common.serialization.WorkPlanListSerializer;

public class WorkPlanTableSerializer {

	public static void AppendChildElement(Document doc, WorkPlanTable obj, Element parentElement) {
		Element UnitCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:UnitCode");
		UnitCodeElement.setTextContent(obj.getUnitCode() + "");
		parentElement.appendChild(UnitCodeElement);

		Element UnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:UnitName");
		UnitNameElement.setTextContent(obj.getUnitName() + "");
		parentElement.appendChild(UnitNameElement);

		Element LeaderCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:LeaderCode");
		LeaderCodeElement.setTextContent(obj.getLeaderCode() + "");
		parentElement.appendChild(LeaderCodeElement);

		Element LeaderNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:LeaderName");
		LeaderNameElement.setTextContent(obj.getLeaderName() + "");
		parentElement.appendChild(LeaderNameElement);

		for(WorkPlanList workPlanListObj : obj.getWorkPlanList()){
			Element WorkPlanListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:WorkPlanList");
			WorkPlanListSerializer.AppendChildElement(doc, workPlanListObj, WorkPlanListElement);
			parentElement.appendChild(WorkPlanListElement);
		}

	}

}