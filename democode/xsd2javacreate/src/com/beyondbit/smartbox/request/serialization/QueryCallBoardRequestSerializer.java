package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.QueryCallBoardRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class QueryCallBoardRequestSerializer {

	public static void AppendChildElement(Document doc, QueryCallBoardRequest obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element TypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Type");
		TypeElement.setTextContent(obj.getType() + "");
		parentElement.appendChild(TypeElement);

		Element EnableDisableTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:EnableDisableTime");
		EnableDisableTimeElement.setTextContent(obj.getEnableDisableTime() + "");
		parentElement.appendChild(EnableDisableTimeElement);

		Element ViewStartTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewStartTime");
		ViewStartTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewStartTime().getTime()));
		parentElement.appendChild(ViewStartTimeElement);

		Element ViewEndTimeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:ViewEndTime");
		ViewEndTimeElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getViewEndTime().getTime()));
		parentElement.appendChild(ViewEndTimeElement);

		Element PageSizeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageSize");
		PageSizeElement.setTextContent(obj.getPageSize() + "");
		parentElement.appendChild(PageSizeElement);

		Element PageNumberElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:PageNumber");
		PageNumberElement.setTextContent(obj.getPageNumber() + "");
		parentElement.appendChild(PageNumberElement);

		Element DisplayAfterVisitedElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DisplayAfterVisited");
		DisplayAfterVisitedElement.setTextContent(obj.getDisplayAfterVisited() + "");
		parentElement.appendChild(DisplayAfterVisitedElement);

	}

}