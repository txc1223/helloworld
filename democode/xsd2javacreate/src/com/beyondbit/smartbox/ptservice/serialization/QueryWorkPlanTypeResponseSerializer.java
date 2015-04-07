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
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTypeResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.ptservice.common.WorkPlanType;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.ptservice.common.serialization.WorkPlanTypeSerializer;

public class QueryWorkPlanTypeResponseSerializer {

	public static void AppendChildElement(Document doc, QueryWorkPlanTypeResponse obj, Element parentElement) {
		for(WorkPlanType workPlanTypeObj : obj.getWorkPlanType()){
			Element WorkPlanTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:WorkPlanType");
			WorkPlanTypeSerializer.AppendChildElement(doc, workPlanTypeObj, WorkPlanTypeElement);
			parentElement.appendChild(WorkPlanTypeElement);
		}

	}

}