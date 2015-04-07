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
import com.beyondbit.smartbox.response.QueryCallBoardResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.CallBoard;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.CallBoardSerializer;

public class QueryCallBoardResponseSerializer {

	public static void AppendChildElement(Document doc, QueryCallBoardResponse obj, Element parentElement) {
		Element TotalElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Total");
		TotalElement.setTextContent(obj.getTotal() + "");
		parentElement.appendChild(TotalElement);

		Element UnReadedCountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:UnReadedCount");
		UnReadedCountElement.setTextContent(obj.getUnReadedCount() + "");
		parentElement.appendChild(UnReadedCountElement);

		for(CallBoard callBoardObj : obj.getCallBoard()){
			Element CallBoardElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:CallBoard");
			CallBoardSerializer.AppendChildElement(doc, callBoardObj, CallBoardElement);
			parentElement.appendChild(CallBoardElement);
		}

	}

}