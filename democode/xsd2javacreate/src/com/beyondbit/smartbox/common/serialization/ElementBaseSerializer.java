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
import com.beyondbit.smartbox.common.ElementBase;
import com.beyondbit.smartbox.common.StringElement;
import com.beyondbit.smartbox.common.ArrayElement;
import com.beyondbit.smartbox.common.ComplexElement;
import com.beyondbit.smartbox.common.serialization.StringElementSerializer;
import com.beyondbit.smartbox.common.serialization.ArrayElementSerializer;
import com.beyondbit.smartbox.common.serialization.ComplexElementSerializer;

public class ElementBaseSerializer {

	public static void AppendChildElement(Document doc, ElementBase obj, Element parentElement) {
		Class<? extends ElementBase> cls = obj.getClass();

		if (cls.equals(StringElement.class)) {
			StringElementSerializer.AppendChildElement(doc, (StringElement) obj, parentElement);
		}		 else if (cls.equals(ArrayElement.class)) {
			ArrayElementSerializer.AppendChildElement(doc, (ArrayElement) obj, parentElement);
		}		 else if (cls.equals(ComplexElement.class)) {
			ComplexElementSerializer.AppendChildElement(doc, (ComplexElement) obj, parentElement);
		}
	}

}