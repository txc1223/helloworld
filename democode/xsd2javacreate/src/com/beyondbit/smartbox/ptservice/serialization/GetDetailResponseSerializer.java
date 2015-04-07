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
import com.beyondbit.smartbox.ptservice.GetDetailResponse;
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.common.ComplexElement;
import com.beyondbit.smartbox.ptservice.Opinion;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import com.beyondbit.smartbox.common.serialization.ComplexElementSerializer;
import com.beyondbit.smartbox.ptservice.serialization.OpinionSerializer;

public class GetDetailResponseSerializer {

	public static void AppendChildElement(Document doc, GetDetailResponse obj, Element parentElement) {
		Element ResultElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Result");
		ComplexElementSerializer.AppendChildElement(doc, obj.getResult(), ResultElement);
		parentElement.appendChild(ResultElement);

		for(Opinion opinionObj : obj.getOpinion()){
			Element OpinionElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice","pts:Opinion");
			OpinionSerializer.AppendChildElement(doc, opinionObj, OpinionElement);
			parentElement.appendChild(OpinionElement);
		}

	}

}