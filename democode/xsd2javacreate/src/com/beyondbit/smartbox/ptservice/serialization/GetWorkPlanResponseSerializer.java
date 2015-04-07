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
import com.beyondbit.smartbox.ptservice.GetWorkPlanResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.ptservice.common.WorkPlan;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.ptservice.common.serialization.WorkPlanSerializer;

public class GetWorkPlanResponseSerializer {

	public static void AppendChildElement(Document doc, GetWorkPlanResponse obj, Element parentElement) {
		Element WorkPlanElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:WorkPlan");
		WorkPlanSerializer.AppendChildElement(doc, obj.getWorkPlan(), WorkPlanElement);
		parentElement.appendChild(WorkPlanElement);

	}

}