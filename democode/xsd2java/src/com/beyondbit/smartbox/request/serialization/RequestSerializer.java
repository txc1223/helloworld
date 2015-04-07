package com.beyondbit.smartbox.request.serialization;

import java.io.StringWriter; 
import java.io.ByteArrayInputStream; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.TimeZone;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NamedNodeMap; 
import util.MyNode; 
import util.UtilTextContent; 
import android.util.Base64; 
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.AddCalendarRequest;
import com.beyondbit.smartbox.request.ClCheckPermissionRequest;
import com.beyondbit.smartbox.request.DeleteCalendarRequest;
import com.beyondbit.smartbox.request.FindDeptCalendarsRequest;
import com.beyondbit.smartbox.request.FindPersonnelCalendarsRequest;
import com.beyondbit.smartbox.request.GetCalendarUserShareListRequest;
import com.beyondbit.smartbox.request.GetCustomCalendarGroupListRequest;
import com.beyondbit.smartbox.request.GetCustomCalendarGroupUserListRequest;
import com.beyondbit.smartbox.request.GetDeptCalendarRequest;
import com.beyondbit.smartbox.request.GetPersonnelCalendarRequest;
import com.beyondbit.smartbox.request.GetUserDeptAndUnitRequest;
import com.beyondbit.smartbox.request.QueryCalendarsRequest;
import com.beyondbit.smartbox.request.QueryCalendarsByOrgCodesRequest;
import com.beyondbit.smartbox.request.QueryCalendarsByUserUIdsRequest;
import com.beyondbit.smartbox.request.QuerySubOrgsRequest;
import com.beyondbit.smartbox.request.QuerySubUsersRequest;
import com.beyondbit.smartbox.request.UpdateCalendarRequest;
import com.beyondbit.smartbox.request.serialization.AddCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ClCheckPermissionRequestSerializer;
import com.beyondbit.smartbox.request.serialization.DeleteCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FindDeptCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FindPersonnelCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCalendarUserShareListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCustomCalendarGroupListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCustomCalendarGroupUserListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetDeptCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetPersonnelCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUserDeptAndUnitRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsByOrgCodesRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsByUserUIdsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySubOrgsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySubUsersRequestSerializer;
import com.beyondbit.smartbox.request.serialization.UpdateCalendarRequestSerializer;

public class RequestSerializer {

	public static String serialize(Request obj) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document doc = builder.newDocument();

		AppendRootElement(doc, obj);

		TransformerFactory transFactory = TransformerFactory.newInstance();

		Transformer transformer = null;
		try {
			transformer = transFactory.newTransformer();
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringWriter buffer = new StringWriter();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

		try {
			transformer.transform(new DOMSource(doc), new StreamResult(buffer));
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void AppendRootElement(Document doc, Request obj) {
		Element rootElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Request");

		AppendChildElement(doc, obj, rootElement,null);

		doc.appendChild(rootElement);
	}

public static Request unSerialize(String s) {
	try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		ByteArrayInputStream sb = new ByteArrayInputStream(s.getBytes());
		Document doc = dbBuilder.parse(sb);
		Element root = doc.getDocumentElement();
		NamedNodeMap e = doc.getDocumentElement().getAttributes();
		MyNode myNode = new MyNode(root);
		String typeName = root.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "type").getNodeValue();
		String[] str = typeName.split("\\:");
		if (str.length > 1) {
			typeName = str[1];
		} 
		String jiedianName = myNode.getName();
		System.out.println("typeName=" + typeName);
		System.out.println("jiedianName=" + jiedianName);
		System.out.println("The root element is:" + root.getNodeName());
		if (myNode.equalsName("Request") && myNode.equalsNameSpace("http://www.beyondbit.com/smartbox/request")) {
		}
		return null;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

	public static void AppendChildElement(Document doc, Request obj, Element parentElement,Class clazz) {
		Class<? extends Request> cls = obj.getClass();

		if (cls.equals(AddCalendarRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			AddCalendarRequestSerializer.AppendChildElement(doc, (AddCalendarRequest) obj, parentElement,null);
		}	 else if (cls.equals(ClCheckPermissionRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			ClCheckPermissionRequestSerializer.AppendChildElement(doc, (ClCheckPermissionRequest) obj, parentElement,null);
		}	 else if (cls.equals(DeleteCalendarRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			DeleteCalendarRequestSerializer.AppendChildElement(doc, (DeleteCalendarRequest) obj, parentElement,null);
		}	 else if (cls.equals(FindDeptCalendarsRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			FindDeptCalendarsRequestSerializer.AppendChildElement(doc, (FindDeptCalendarsRequest) obj, parentElement,null);
		}	 else if (cls.equals(FindPersonnelCalendarsRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			FindPersonnelCalendarsRequestSerializer.AppendChildElement(doc, (FindPersonnelCalendarsRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetCalendarUserShareListRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetCalendarUserShareListRequestSerializer.AppendChildElement(doc, (GetCalendarUserShareListRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetCustomCalendarGroupListRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetCustomCalendarGroupListRequestSerializer.AppendChildElement(doc, (GetCustomCalendarGroupListRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetCustomCalendarGroupUserListRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetCustomCalendarGroupUserListRequestSerializer.AppendChildElement(doc, (GetCustomCalendarGroupUserListRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetDeptCalendarRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetDeptCalendarRequestSerializer.AppendChildElement(doc, (GetDeptCalendarRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetPersonnelCalendarRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetPersonnelCalendarRequestSerializer.AppendChildElement(doc, (GetPersonnelCalendarRequest) obj, parentElement,null);
		}	 else if (cls.equals(GetUserDeptAndUnitRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			GetUserDeptAndUnitRequestSerializer.AppendChildElement(doc, (GetUserDeptAndUnitRequest) obj, parentElement,null);
		}	 else if (cls.equals(QueryCalendarsRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			QueryCalendarsRequestSerializer.AppendChildElement(doc, (QueryCalendarsRequest) obj, parentElement,null);
		}	 else if (cls.equals(QueryCalendarsByOrgCodesRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			QueryCalendarsByOrgCodesRequestSerializer.AppendChildElement(doc, (QueryCalendarsByOrgCodesRequest) obj, parentElement,null);
		}	 else if (cls.equals(QueryCalendarsByUserUIdsRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			QueryCalendarsByUserUIdsRequestSerializer.AppendChildElement(doc, (QueryCalendarsByUserUIdsRequest) obj, parentElement,null);
		}	 else if (cls.equals(QuerySubOrgsRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			QuerySubOrgsRequestSerializer.AppendChildElement(doc, (QuerySubOrgsRequest) obj, parentElement,null);
		}	 else if (cls.equals(QuerySubUsersRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			QuerySubUsersRequestSerializer.AppendChildElement(doc, (QuerySubUsersRequest) obj, parentElement,null);
		}	 else if (cls.equals(UpdateCalendarRequest.class)) {
			if (!cls.equals(clazz)) 
			parentElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
			UpdateCalendarRequestSerializer.AppendChildElement(doc, (UpdateCalendarRequest) obj, parentElement,null);
		}
	}

}