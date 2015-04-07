package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.QueryReceiveSMSV2Response;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.ReceiveSMSListV2;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.ReceiveSMSListV2Serializer;

public class QueryReceiveSMSV2ResponseSerializer {

	public static void AppendChildElement(Document doc, QueryReceiveSMSV2Response obj, Element parentElement) {
		Element RangeTotalElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:RangeTotal");
		RangeTotalElement.setTextContent(obj.getRangeTotal() + "");
		parentElement.appendChild(RangeTotalElement);

		Element ReceiveSMSListElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:ReceiveSMSList");
		ReceiveSMSListV2Serializer.AppendChildElement(doc, obj.getReceiveSMSList(), ReceiveSMSListElement);
		parentElement.appendChild(ReceiveSMSListElement);

	}

}