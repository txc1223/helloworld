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
import com.beyondbit.smartbox.response.QueryMagazineKindResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.MagazineKind;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.MagazineKindSerializer;

public class QueryMagazineKindResponseSerializer {

	public static void AppendChildElement(Document doc, QueryMagazineKindResponse obj, Element parentElement) {
		for(MagazineKind magazineKindObj : obj.getMagazineKind()){
			Element MagazineKindElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:MagazineKind");
			MagazineKindSerializer.AppendChildElement(doc, magazineKindObj, MagazineKindElement);
			parentElement.appendChild(MagazineKindElement);
		}

	}

}