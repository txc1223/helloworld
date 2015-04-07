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
import com.beyondbit.smartbox.ptservice.QuerySplitPageResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.ComplexElement;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.ComplexElementSerializer;

public class QuerySplitPageResponseSerializer {

	public static void AppendChildElement(Document doc, QuerySplitPageResponse obj, Element parentElement) {
		Element TotalElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Total");
		TotalElement.setTextContent(obj.getTotal() + "");
		parentElement.appendChild(TotalElement);

		for(ComplexElement complexElementObj : obj.getResult()){
			Element ResultElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Result");
			ComplexElementSerializer.AppendChildElement(doc, complexElementObj, ResultElement);
			parentElement.appendChild(ResultElement);
		}

	}

}