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
import com.beyondbit.smartbox.request.FinishOfflineFileRequest;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.serialization.RequestSerializer;

public class FinishOfflineFileRequestSerializer {

	public static void AppendChildElement(Document doc, FinishOfflineFileRequest obj, Element parentElement) {
		Element IdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Id");
		IdElement.setTextContent(obj.getId() + "");
		parentElement.appendChild(IdElement);

		Element DataIdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:DataId");
		DataIdElement.setTextContent(obj.getDataId() + "");
		parentElement.appendChild(DataIdElement);

		Element IsCancelElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:IsCancel");
		IsCancelElement.setTextContent(obj.getIsCancel() + "");
		parentElement.appendChild(IsCancelElement);

	}

}