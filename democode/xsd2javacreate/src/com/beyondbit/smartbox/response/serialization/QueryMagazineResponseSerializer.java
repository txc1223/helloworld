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
import com.beyondbit.smartbox.response.QueryMagazineResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.Magazine;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.MagazineSerializer;

public class QueryMagazineResponseSerializer {

	public static void AppendChildElement(Document doc, QueryMagazineResponse obj, Element parentElement) {
		Element TotalElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Total");
		TotalElement.setTextContent(obj.getTotal() + "");
		parentElement.appendChild(TotalElement);

		for(Magazine magazineObj : obj.getMagazine()){
			Element MagazineElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Magazine");
			MagazineSerializer.AppendChildElement(doc, magazineObj, MagazineElement);
			parentElement.appendChild(MagazineElement);
		}

	}

}