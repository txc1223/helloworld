package com.beyondbit.smartbox.ptservice.common.serialization;

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
import com.beyondbit.smartbox.ptservice.common.ProjectRemark;

public class ProjectRemarkSerializer {

	public static void AppendChildElement(Document doc, ProjectRemark obj, Element parentElement) {
		Element IdElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Id");
		IdElement.setTextContent(obj.getId() + "");
		parentElement.appendChild(IdElement);

		Element RemarkElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Remark");
		RemarkElement.setTextContent(obj.getRemark() + "");
		parentElement.appendChild(RemarkElement);

		Element RemarkerElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Remarker");
		RemarkerElement.setTextContent(obj.getRemarker() + "");
		parentElement.appendChild(RemarkerElement);

		Element DateElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Date");
		DateElement.setTextContent(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj.getDate().getTime()));
		parentElement.appendChild(DateElement);

		Element ContentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:Content");
		ContentElement.setTextContent(obj.getContent() + "");
		parentElement.appendChild(ContentElement);

		Element ProjectNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ProjectName");
		ProjectNameElement.setTextContent(obj.getProjectName() + "");
		parentElement.appendChild(ProjectNameElement);

		Element ProjectShortNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/ptservice/common","com:ProjectShortName");
		ProjectShortNameElement.setTextContent(obj.getProjectShortName() + "");
		parentElement.appendChild(ProjectShortNameElement);

	}

}