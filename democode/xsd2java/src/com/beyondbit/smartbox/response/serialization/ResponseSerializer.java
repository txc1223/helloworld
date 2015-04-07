package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.AddCalendarResponse;
import com.beyondbit.smartbox.response.ClCheckPermissionResponse;
import com.beyondbit.smartbox.response.DeleteCalendarResponse;
import com.beyondbit.smartbox.response.FindDeptCalendarsResponse;
import com.beyondbit.smartbox.response.FindPersonnelCalendarsResponse;
import com.beyondbit.smartbox.response.GetCalendarUserShareListResponse;
import com.beyondbit.smartbox.response.GetCustomCalendarGroupListResponse;
import com.beyondbit.smartbox.response.GetCustomCalendarGroupUserListResponse;
import com.beyondbit.smartbox.response.GetDeptCalendarResponse;
import com.beyondbit.smartbox.response.GetPersonnelCalendarResponse;
import com.beyondbit.smartbox.response.GetUserDeptAndUnitResponse;
import com.beyondbit.smartbox.response.QueryCalendarsResponse;
import com.beyondbit.smartbox.response.QueryCalendarsByOrgCodesResponse;
import com.beyondbit.smartbox.response.QueryCalendarsByUserUIdsResponse;
import com.beyondbit.smartbox.response.QuerySubOrgsResponse;
import com.beyondbit.smartbox.response.QuerySubUsersResponse;
import com.beyondbit.smartbox.response.UpdateCalendarResponse;
import com.beyondbit.smartbox.response.FailureResponse;
import com.beyondbit.smartbox.response.SuccessResponse;
import com.beyondbit.smartbox.response.serialization.AddCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.ClCheckPermissionResponseSerializer;
import com.beyondbit.smartbox.response.serialization.DeleteCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FindDeptCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FindPersonnelCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCalendarUserShareListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCustomCalendarGroupListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCustomCalendarGroupUserListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetDeptCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetPersonnelCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUserDeptAndUnitResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsByOrgCodesResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsByUserUIdsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySubOrgsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySubUsersResponseSerializer;
import com.beyondbit.smartbox.response.serialization.UpdateCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FailureResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SuccessResponseSerializer;

public class ResponseSerializer {

	public static String serialize(Response obj) {
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

	public static void AppendRootElement(Document doc, Response obj) {
	}

public static Response unSerialize(String s) {
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
		if (myNode.equalsName("Response") && myNode.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
			String typeNameSpace=myNode.getTypeNameSpace(myNode.getNode());
			return parseChildElement(null,typeName, myNode,typeNameSpace);
		}
		return null;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

	public static Response parseChildElement(Response response,String typeName,MyNode node,String typeNameSpace) {
		if (typeName.equals("AddCalendarResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new AddCalendarResponse();
			AddCalendarResponseSerializer.parseChildElement((AddCalendarResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("ClCheckPermissionResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new ClCheckPermissionResponse();
			ClCheckPermissionResponseSerializer.parseChildElement((ClCheckPermissionResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("DeleteCalendarResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new DeleteCalendarResponse();
			DeleteCalendarResponseSerializer.parseChildElement((DeleteCalendarResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("FindDeptCalendarsResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new FindDeptCalendarsResponse();
			FindDeptCalendarsResponseSerializer.parseChildElement((FindDeptCalendarsResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("FindPersonnelCalendarsResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new FindPersonnelCalendarsResponse();
			FindPersonnelCalendarsResponseSerializer.parseChildElement((FindPersonnelCalendarsResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetCalendarUserShareListResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetCalendarUserShareListResponse();
			GetCalendarUserShareListResponseSerializer.parseChildElement((GetCalendarUserShareListResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetCustomCalendarGroupListResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetCustomCalendarGroupListResponse();
			GetCustomCalendarGroupListResponseSerializer.parseChildElement((GetCustomCalendarGroupListResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetCustomCalendarGroupUserListResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetCustomCalendarGroupUserListResponse();
			GetCustomCalendarGroupUserListResponseSerializer.parseChildElement((GetCustomCalendarGroupUserListResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetDeptCalendarResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetDeptCalendarResponse();
			GetDeptCalendarResponseSerializer.parseChildElement((GetDeptCalendarResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetPersonnelCalendarResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetPersonnelCalendarResponse();
			GetPersonnelCalendarResponseSerializer.parseChildElement((GetPersonnelCalendarResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("GetUserDeptAndUnitResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new GetUserDeptAndUnitResponse();
			GetUserDeptAndUnitResponseSerializer.parseChildElement((GetUserDeptAndUnitResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("QueryCalendarsResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new QueryCalendarsResponse();
			QueryCalendarsResponseSerializer.parseChildElement((QueryCalendarsResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("QueryCalendarsByOrgCodesResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new QueryCalendarsByOrgCodesResponse();
			QueryCalendarsByOrgCodesResponseSerializer.parseChildElement((QueryCalendarsByOrgCodesResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("QueryCalendarsByUserUIdsResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new QueryCalendarsByUserUIdsResponse();
			QueryCalendarsByUserUIdsResponseSerializer.parseChildElement((QueryCalendarsByUserUIdsResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("QuerySubOrgsResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new QuerySubOrgsResponse();
			QuerySubOrgsResponseSerializer.parseChildElement((QuerySubOrgsResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("QuerySubUsersResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new QuerySubUsersResponse();
			QuerySubUsersResponseSerializer.parseChildElement((QuerySubUsersResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("UpdateCalendarResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new UpdateCalendarResponse();
			UpdateCalendarResponseSerializer.parseChildElement((UpdateCalendarResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("FailureResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new FailureResponse();
			FailureResponseSerializer.parseChildElement((FailureResponse)response,typeName,node,typeNameSpace);
		}		 else if (typeName.equals("SuccessResponse")&& typeNameSpace.equals("http://www.beyondbit.com/smartbox/response")) {
			response= new SuccessResponse();
			SuccessResponseSerializer.parseChildElement((SuccessResponse)response,typeName,node,typeNameSpace);
		}
		return response;
		}

}