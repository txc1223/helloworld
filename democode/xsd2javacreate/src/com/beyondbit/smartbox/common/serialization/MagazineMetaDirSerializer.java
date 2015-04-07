package com.beyondbit.smartbox.common.serialization;

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
import com.beyondbit.smartbox.common.MagazineMetaDir;

public class MagazineMetaDirSerializer {

	public static void AppendChildElement(Document doc, MagazineMetaDir obj, Element parentElement) {
		Element IDElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ID");
		IDElement.setTextContent(obj.getID() + "");
		parentElement.appendChild(IDElement);

		Element NameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Name");
		NameElement.setTextContent(obj.getName() + "");
		parentElement.appendChild(NameElement);

		Element FlagElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Flag");
		FlagElement.setTextContent(obj.getFlag() + "");
		parentElement.appendChild(FlagElement);

		Element SequenceElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Sequence");
		SequenceElement.setTextContent(obj.getSequence() + "");
		parentElement.appendChild(SequenceElement);

		Element MetaDirNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:MetaDirName");
		MetaDirNameElement.setTextContent(obj.getMetaDirName() + "");
		parentElement.appendChild(MetaDirNameElement);

	}

}