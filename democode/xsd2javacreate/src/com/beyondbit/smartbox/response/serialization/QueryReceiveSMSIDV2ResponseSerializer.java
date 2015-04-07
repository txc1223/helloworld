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
import com.beyondbit.smartbox.response.QueryReceiveSMSIDV2Response;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.SmsIdListV2;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.SmsIdListV2Serializer;

public class QueryReceiveSMSIDV2ResponseSerializer {

	public static void AppendChildElement(Document doc, QueryReceiveSMSIDV2Response obj, Element parentElement) {
		Element ReceiveSMSIDListV2Element = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:ReceiveSMSIDListV2");
		SmsIdListV2Serializer.AppendChildElement(doc, obj.getReceiveSMSIDListV2(), ReceiveSMSIDListV2Element);
		parentElement.appendChild(ReceiveSMSIDListV2Element);

	}

}