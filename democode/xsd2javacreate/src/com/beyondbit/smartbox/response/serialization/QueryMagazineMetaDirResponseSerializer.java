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
import com.beyondbit.smartbox.response.QueryMagazineMetaDirResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.MagazineMetaDir;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.MagazineMetaDirSerializer;

public class QueryMagazineMetaDirResponseSerializer {

	public static void AppendChildElement(Document doc, QueryMagazineMetaDirResponse obj, Element parentElement) {
		for(MagazineMetaDir magazineMetaDirObj : obj.getMagazineMetaDir()){
			Element MagazineMetaDirElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:MagazineMetaDir");
			MagazineMetaDirSerializer.AppendChildElement(doc, magazineMetaDirObj, MagazineMetaDirElement);
			parentElement.appendChild(MagazineMetaDirElement);
		}

	}

}