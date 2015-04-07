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
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTableResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.ptservice.common.WorkPlanTable;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.ptservice.common.serialization.WorkPlanTableSerializer;

public class QueryWorkPlanTableResponseSerializer {

	public static void AppendChildElement(Document doc, QueryWorkPlanTableResponse obj, Element parentElement) {
		for(WorkPlanTable workPlanTableObj : obj.getWorkPlanTable()){
			Element WorkPlanTableElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:WorkPlanTable");
			WorkPlanTableSerializer.AppendChildElement(doc, workPlanTableObj, WorkPlanTableElement);
			parentElement.appendChild(WorkPlanTableElement);
		}

	}

}