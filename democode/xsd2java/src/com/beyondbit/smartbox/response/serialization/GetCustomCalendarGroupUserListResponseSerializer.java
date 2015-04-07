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
import com.beyondbit.smartbox.response.GetCustomCalendarGroupUserListResponse;
import com.beyondbit.smartbox.common.User;
import com.beyondbit.smartbox.common.serialization.UserSerializer;

public class GetCustomCalendarGroupUserListResponseSerializer {

	public static GetCustomCalendarGroupUserListResponse parseChildElement(GetCustomCalendarGroupUserListResponse getCustomCalendarGroupUserListResponse,String typeName,MyNode node,String typeNameSpace) {
		ArrayList<User> userListData=new ArrayList<User> ();
		if (getCustomCalendarGroupUserListResponse == null)
			getCustomCalendarGroupUserListResponse = new GetCustomCalendarGroupUserListResponse();
		List<MyNode> nodeList=node.getMyNodeList();
		int len=nodeList.size();
		for (int i = 0; i < len; i++) {
			MyNode n = nodeList.get(i);
			//User;
		if (n.equalsName("User") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response")) {
		userListData.add((User)UserSerializer.parseChildElement(null,"User",n,"http://www.beyondbit.com/smartbox/common"));
			continue;
		}

		}
		getCustomCalendarGroupUserListResponse.setUser(userListData.toArray(new User[userListData.size()]));
		return getCustomCalendarGroupUserListResponse;
	}

}