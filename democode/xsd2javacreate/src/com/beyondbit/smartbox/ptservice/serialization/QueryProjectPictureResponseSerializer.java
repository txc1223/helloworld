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

import android.util.Base64;

import com.beyondbit.smartbox.ptservice.QueryProjectPictureResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;

public class QueryProjectPictureResponseSerializer {

	public static void AppendChildElement(Document doc, QueryProjectPictureResponse obj, Element parentElement) {
		for(byte[] bytesObj : obj.getPicture()){
			Element PictureElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Picture");
			PictureElement.setTextContent(Base64.encodeToString(bytesObj, Base64.NO_WRAP));
			parentElement.appendChild(PictureElement);
		}

	}

}