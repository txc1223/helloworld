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
import com.beyondbit.smartbox.ptservice.QueryProjectListRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryProjectListRequestSerializer {

	public static void AppendChildElement(Document doc, QueryProjectListRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element CategoryElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Category");
		CategoryElement.setTextContent(obj.getCategory() + "");
		parentElement.appendChild(CategoryElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Type");
		TypeElement.setTextContent(obj.getType() + "");
		parentElement.appendChild(TypeElement);

		Element ViewStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:ViewStartTime");
		ViewStartTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewStartTime().getTime()));
		parentElement.appendChild(ViewStartTimeElement);

		Element ViewEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:ViewEndTime");
		ViewEndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewEndTime().getTime()));
		parentElement.appendChild(ViewEndTimeElement);

	}

}