package com.beyondbit.smartbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Base64;
import android.util.Log;

import com.beyondbit.smartbox.common.Calendar;
import com.beyondbit.smartbox.common.CallBoard;
import com.beyondbit.smartbox.common.StatusType;
import com.beyondbit.smartbox.common.UserStatus;
import com.beyondbit.smartbox.common.UserStatusList;
import com.beyondbit.smartbox.common.serialization.CalendarSerializer;
import com.beyondbit.smartbox.ptservice.QueryProjectPictureResponse;
import com.beyondbit.smartbox.response.FindDeptCalendarsResponse;
import com.beyondbit.smartbox.response.GetUserStatusResponse;
import com.beyondbit.smartbox.response.QueryCallBoardResponse;
import com.beyondbit.smartbox.response.serialization.ResponseSerializer;
import commons.org.apache.commons.lang.time.DateUtils;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DocTask [] docTask=new DocTask[1];
		// docTask[0]=new DocTask();
		// docTask[0].setTaskId("TaskId");
		// docTask[0].setTitle("title");
		// docTask[0].setUrgency("Urgency");
		// docTask[0].setSendTime(Calendar.getInstance());
		// docTask[0].setSender("Sender");
		// docTask[0].setPublish("Publish");
		// docTask[0].setFlowId("FlowId");
		// docTask[0].setFlowType("FlowType");
		// docTask[0].setHasAttach(true);
		// docTask[0].setNumber("Number");
		// docTask[0].setHasNeedCorrect(false);
		try {
//			Date d=DateUtils.parseDate("2014-02-17T10:59:00+08:00", new String[]{"yyyy-MM-dd'T'HH:mm:ssZZ"});
//			Date d=DateUtils.parseDate("2011-08-08T12:02:00.757", new String[]{"yyyy-MM-dd'T'HH:mm:ssZZ","yyyy-MM-dd'T'HH:mm:ss.SSS"});
//			Date d=new ISODateFormat().parse("2011-08-08T12:02:00Z");
			
//			Date d=new ISODateFormat().parse("2013-05-17T17:20:42.98");
			Date d=new ISODateFormat().parse("2014-06-26T01:12:00+08:00");
//			Date d=new ISODateFormat().parse("2014-09-10T13:57:13.3927068+08:00");


//			Date d=new ISODateFormat().parse("2011-08-22T14:12:00.6");
//			String s=new ISODateFormat().format(new Date());
			System.out.println(d);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// QueryDocListResponse queryDocListRequest = new
		// QueryDocListResponse();
		// queryDocListRequest.setDocTask(docTask);
		// queryDocListRequest.setTotal(1);
		// String s = ResponseSerializer.serialize(queryDocListRequest);
		// System.out.println("ssss==="+s);

		// Response r = ResponseDocument.Factory.parse(s).getResponse();
//		UserStatusList ul = new UserStatusList();
//
//		UserStatus[] us = new UserStatus[2];
//
//		UserStatus ss = new UserStatus();
//		ss.setDescription("setDescription1");
//		ss.setStatus(StatusType.Busy);
//		ss.setUserUid("001");
//		us[0] = ss;
//		UserStatus ss2 = new UserStatus();
//		ss2.setDescription("setDescription2");
//		ss2.setStatus(StatusType.DND);
//		ss2.setUserUid("002");
//		us[1] = ss2;
//
//		ul.setUserStatus(us);

		// GetUserStatusResponse getUserStatusResponse = new
		// GetUserStatusResponse();
		// getUserStatusResponse.setUserStatusList(ul);
		// String s = ResponseSerializer.serialize(getUserStatusResponse);

		// SetSelfStatusRequest setSelfStatusRequest = new
		// SetSelfStatusRequest();
		// setSelfStatusRequest.setDescription("setDescription");
		// setSelfStatusRequest.setStatus(StatusType.Busy);
		// RequestSerializer.serialize(setSelfStatusRequest);
		// System.out.println("ssss===" + s);
		// E:\mycode\xsd2javacreate\pic
//		File imageFile = new File("E:\\mycode\\xsd2javacreate\\pic\\imga.png");
//		byte[][] bs = new byte[2][];
//		try {
//			bs[0] = getBytesFromFile(imageFile);
//			bs[1] = getBytesFromFile(imageFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// FIXME
		/**
		 * ͼƬת����Ҫ�õ�android��base64�� ��android��Ŀ��import
		 * org.w3c.dom.bootstrap.DOMImplementationRegistry;��������
		 * android.jar��û������� ֻ����jdk rt.jar���� ������Ҳ�Ǳ��� public class
		 * QueryProjectPictureResponseSerializer {
		 * 
		 * public static void AppendChildElement(Document doc,
		 * QueryProjectPictureResponse obj, Element parentElement) { for(byte[]
		 * bytesObj : obj.getPicture()){ Element PictureElement =
		 * doc.createElementNS
		 * ("http://www.beyondbit.com/smartbox/ptservice","pts:Picture");
		 * parentElement.setTextContent(Base64.encodeToString(bytesObj,
		 * Base64.NO_WRAP)); ����Ҫ�ĳ����� parentElement.appendChild(PictureElement);
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 */
		// QueryProjectPictureResponse queryProjectPictureResponse = new
		// QueryProjectPictureResponse();
		// queryProjectPictureResponse.setPicture(bs);
		// String s1 =
		// ResponseSerializer.serialize(queryProjectPictureResponse);
		// System.out.println("ssss111===" + s1);
//		Calendar[] cs = new Calendar[2];
//		Calendar c = new Calendar();
//		c.setAttendees("attend");
//		c.setAttendeNames("attend");
//		c.setEnd(java.util.Calendar.getInstance());
//		c.setExtendField1("attend");
//		c.setIsAllDayEvent("attend");
//		c.setIsMeetingRequest("attend");
//		c.setStart(java.util.Calendar.getInstance());
//		c.setUserName("UserName");
//		c.setLocation("Location");
//		cs[0] = c;
//		cs[1] = c;
//		FindDeptCalendarsResponse findDeptCalendarsResponse = new FindDeptCalendarsResponse();
//		findDeptCalendarsResponse.setCalendar(cs);
//		String s2 = ResponseSerializer.serialize(findDeptCalendarsResponse);
//		// System.out.println("ssss111===" + s2);
//
//		CallBoard[] cbs = new CallBoard[2];
//		CallBoard cb = new CallBoard();
//		cb.setDisableTime(java.util.Calendar.getInstance());
//		cb.setID("id");
//		cb.setPublishDept("PublishDept");
//		cb.setPublisher("Publisher");
//		cb.setPublishTime(java.util.Calendar.getInstance());
//		cb.setReaded(false);
//		cb.setTitle("Title");
//		cb.setType("Type");
//		cbs[0] = cb;
//		cbs[1] = cb;
//		QueryCallBoardResponse queryCallBoardResponse = new com.beyondbit.smartbox.response.QueryCallBoardResponse();
//		queryCallBoardResponse.setTotal(1);
//		queryCallBoardResponse.setUnReadedCount(2);
//		queryCallBoardResponse.setCallBoard(cbs);
//
//		String s3 = ResponseSerializer.serialize(queryCallBoardResponse);
//
//		String s4 = "<Calendar><c:ItemID>AAMkAVfAAClXAljAAA=</c:ItemID><c:Subject>2222</c:Subject><c:Start>2014-02-10T14:02:00+08:00</c:Start><c:End>2014-02-10T16:02:00+08:00</c:End><c:IsAllDayEvent>0</c:IsAllDayEvent><c:IsMeetingRequest>0</c:IsMeetingRequest><c:IsReadOnly>0</c:IsReadOnly><c:UserName>�����</c:UserName><c:Attendees/><c:AttendeNames>�Ĳ��,����</c:AttendeNames><c:OtherAttendees/><c:Location>�Ǻ�</c:Location></Calendar><Calendar><c:ItemID>AAMkAGU5MGQwMTYxLWUwMGMtNDgzZS1hZTU4LTU0NzcyYjMwYzJhNABGAAAAAAAI6wDK1HL8RYWZd7DWjSPCBwB151kJzFP3S5rEmRC282VfAAAAI0NTAAB151kJzFP3S5rEmRC282VfAAClXAlhAAA=</c:ItemID><c:Subject>����̾��</c:Subject><c:Start>2014-02-10T14:02:00+08:00</c:Start><c:End>2014-02-10T16:02:00+08:00</c:End><c:IsAllDayEvent>0</c:IsAllDayEvent><c:IsMeetingRequest>0</c:IsMeetingRequest><c:IsReadOnly>0</c:IsReadOnly><c:UserName>222</c:UserName><c:Attendees/><c:AttendeNames/><c:OtherAttendees/><c:Location>3333</c:Location></Calendar><Calendar><c:ItemID>AAMkAGU5MGQwMTYxLWUwMGMtNDgzZS1hZTU4LTU0NzcyYjMwYzJhNABGAAAAAAAI6wDK1HL8RYWZd7DWjSPCBwB151kJzFP3S5rEmRC282VfAAAAI0NTAAB151kJzFP3S5rEmRC282VfAAClXAliAAA=</c:ItemID><c:Subject>������</c:Subject><c:Start>2014-02-10T14:03:00+08:00</c:Start><c:End>2014-02-10T16:03:00+08:00</c:End><c:IsAllDayEvent>0</c:IsAllDayEvent><c:IsMeetingRequest>0</c:IsMeetingRequest><c:IsReadOnly>0</c:IsReadOnly><c:UserName>�����</c:UserName><c:Attendees/><c:AttendeNames/><c:OtherAttendees/><c:Location>����</c:Location></Calendar><Calendar><c:ItemID>AAMkAGU5MGQwMTYxLWUwMGMtNDgzZS1hZTU4LTU0NzcyYjMwYzJhNABGAAAAAAAI6wDK1HL8RYWZd7DWjSPCBwB151kJzFP3S5rEmRC282VfAAAAI0NTAAAJOY+U3mkGRYhVvZPcwVTFAAgouYYIAAA=</c:ItemID><c:Subject>���Ż���[�����ճ�]</c:Subject><c:Start>2014-02-10T15:30:00+08:00</c:Start><c:End>2014-02-10T18:00:00+08:00</c:End><c:IsAllDayEvent>0</c:IsAllDayEvent><c:IsMeetingRequest>0</c:IsMeetingRequest><c:IsReadOnly>1</c:IsReadOnly><c:UserName>�����ճ̹���Ա</c:UserName><c:Attendees/><c:AttendeNames>�����ճ̹���Ա,��Ӧ��,����,������,���,�Ĳ��,����,�����,����˳,������,�����,�ľ�,������,��ǿ,�Ҵ���,������,�����,��ѧ��,ʯ����,������,����</c:AttendeNames><c:OtherAttendees/><c:Location>���������</c:Location></Calendar><Calendar><c:ItemID>AAMkAGU5MGQwMTYxLWUwMGMtNDgzZS1hZTU4LTU0NzcyYjMwYzJhNABGAAAAAAAI6wDK1HL8RYWZd7DWjSPCBwB151kJzFP3S5rEmRC282VfAAAAI0NTAAB151kJzFP3S5rEmRC282VfAAClXAlkAAA=</c:ItemID><c:Subject>̫��׃</c:Subject><c:Start>2014-02-11T14:03:00+08:00</c:Start><c:End>2014-02-11T16:03:00+08:00</c:End><c:IsAllDayEvent>0</c:IsAllDayEvent><c:IsMeetingRequest>0</c:IsMeetingRequest><c:IsReadOnly>0</c:IsReadOnly><c:UserName>�����</c:UserName><c:Attendees/><c:AttendeNames>�Ĳ��</c:AttendeNames><c:OtherAttendees/><c:Location>�ջ���</c:Location></Calendar>";
//		s3 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Response xmlns:c=\"http://www.beyondbit.com/smartbox/common\" d1p1:type=\"FindPersonnelCalendarsResponse\" xmlns:d1p1=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.beyondbit.com/smartbox/response\"><Calendar><c:ItemID>AAMkAVfAAClXAljAAA=</c:ItemID><c:Subject>HHHHHH</c:Subject></Calendar></Response>";
//		System.out.println("ssss111===" + s3);
		// Object obj=convertXmlStrToObject(SetSelfStatusRequest.class, s);
		// Object obj=convertXmlStrToObject(Response.class,
		// \"<Response xmlns:c=\"http://www.beyondbit.com/smartbox/common\" d1p1:type=\"GetContactResponse\" xmlns:d1p1=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.beyondbit.com/smartbox/response\"><Contact></Contact></Response>");
//		foo(s3);
	}

	private static void foo(String s) {
		// rootElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance",
		// "type");
		// rootElement.getNamespaceURI();
		// rootElement.getNodeName().eq
		try {
			// �õ�DOM�������Ĺ���ʵ��
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			// ��DOM�����л��DOM������
			dbFactory.setNamespaceAware(true);
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			StringBufferInputStream sb = new StringBufferInputStream(s);
			// ��Ҫ������xml�ĵ�����DOM������
			Document doc = dbBuilder.parse(sb);
			// String s5=doc.getDoctype().getName();
			// Attr
			// attr=doc.getDocumentElement().getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance",
			// "type");
			Element root = doc.getDocumentElement();

			NamedNodeMap e = doc.getDocumentElement().getAttributes();

			MyNode myNode = new MyNode(root);
//			String nameSpace=null;
			String typeName=root.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "type").getNodeValue();
//			String[] str = typeName.split("\\:");
//			if (str.length > 1) {
//				typeName = str[1];
//				nameSpace = root.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", str[0]).getNodeValue();
//			} else{
//				nameSpace = root.getAttribute("xmlns");
//			}
			String nameSpace=myNode.getTypeNameSpace(myNode.getNode());
			
			String jiedianName = myNode.getName();
			System.out.println("typeName=" + typeName);
			System.out.println("jiedianName=" + jiedianName);
			System.out.println("The nameSpace is:" + nameSpace);
//			MyNode myNode = new MyNode(doc);
			
			if (myNode.equalsName("Response") && myNode.equalsNameSpace("http://www.beyondbit.com/smartbox/response/")) {
				stepThrough2(myNode);
			}

			// stepThrough(doc);
			// stepThrough1(doc);

			// stepThrough3(doc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void stepThrough3(Document doc) {
		QueryCallBoardResponse queryCallBoardResponse = new QueryCallBoardResponse();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();

		// int len=0;
		// for (int i = 0; i < nodeList.getLength(); i++) {
		// Node n = nodeList.item(i);
		// if (n.getNodeName().contains("CallBoard")) {
		// len++;
		// }
		// }
		ArrayList<CallBoard> scList = new ArrayList<CallBoard>();
		// CallBoard[] cs = new CallBoard[len];
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			System.out.print("�ֶ���=" + n.getNodeName());
			System.out.println("\t�ֶ�ֵ=" + n.getTextContent());
			if (n.getNodeName().contains("Total")) {
				queryCallBoardResponse.setTotal(Integer.parseInt(n.getTextContent()));
			}

			if (n.getNodeName().contains("UnReadedCount")) {
				// FIXME
				// �����long ��ҪLong.parseLong(n.getTextContent())��
				queryCallBoardResponse.setUnReadedCount(Integer.parseInt(n.getTextContent()));
			}
			if (n.getNodeName().contains("CallBoard")) {
				// cs[callBoardLen] = addElement(n);;
				scList.add(addElement(n));
				// callBoardLen++;
				System.out.println("����=================CallBoard=======================\r\n\r\n");
			}
		}

		queryCallBoardResponse.setCallBoard((CallBoard[]) (scList.toArray()));
		System.out.println("queryCallBoardResponse======" + queryCallBoardResponse.getTotal());
		System.out.println("queryCallBoardResponse======" + queryCallBoardResponse.getUnReadedCount());
		System.out.println("queryCallBoardResponse======" + queryCallBoardResponse.getCallBoard()[0].getReaded());
		System.out.println("queryCallBoardResponse======" + queryCallBoardResponse.getCallBoard()[1].getDisableTime().getTime());
	}

	private static CallBoard addElement(Node n) {
		NodeList nodeL = n.getChildNodes();
		System.out.println("��ʼ=================CallBoard========================\r\n");
		CallBoard c = new CallBoard();
		for (int j = 0; j < nodeL.getLength(); j++) {
			Node n1 = nodeL.item(j);
			// if (n1.getNodeName().contains("UserStatus")) {
			System.out.print("�ֶ���=" + n1.getNodeName());
			System.out.println("\t�ֶ�ֵ=" + n1.getTextContent());
			if (n1.getNodeName().contains("ID")) {
				c.setID(n1.getTextContent());
			} else if (n1.getNodeName().contains("Title")) {
				c.setTitle(n1.getTextContent());
			} else if (n1.getNodeName().contains("PublishDept")) {
				c.setPublishDept(n1.getTextContent());
			} else if (n1.getNodeName().contains("Publisher")) {
				c.setPublisher(n1.getTextContent());
			} else if (n1.getNodeName().contains("PublishTime")) {
				// FIXME
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				Date d = null;
				try {
					d = formatter.parse(n1.getTextContent());

					if (d == null) {
					} else {
						java.util.Calendar cal = java.util.Calendar.getInstance();
						cal.setTime(d);
						c.setPublishTime(cal);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (n1.getNodeName().contains("DisableTime")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				Date d = null;
				try {
					d = formatter.parse(n1.getTextContent());

					if (d == null) {
					} else {
						java.util.Calendar cal = java.util.Calendar.getInstance();
						cal.setTime(d);
						c.setDisableTime(cal);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (n1.getNodeName().contains("Readed")) {
				System.out.println(n1.getTextContent());
				c.setReaded(Boolean.parseBoolean(n1.getTextContent()));
				System.out.println(c.getReaded());
			}
		}
		return c;
	}

	private static void stepThrough2(MyNode myNode) {
		FindDeptCalendarsResponse findDeptCalendarsResponse = new FindDeptCalendarsResponse();
		List<MyNode> nodeList = myNode.getMyNodeList();

		// bs[0] = "s".getBytes();
		// bs[1] = "d".getBytes();

		// String vvv="sddd";
		// byte[] bbbbbbb=new byte[vvv.length()];
		// vvv.getBytes(0, vvv.length(), bbbbbbb, 0);
		// for (int i = 0; i < b.length; i++) {
		// b[i]=Byte.parseByte(charAt(i));
		// }

		// System.out.println(bbbbbbb);
		com.beyondbit.smartbox.common.Calendar[] cs = new com.beyondbit.smartbox.common.Calendar[nodeList.size()];
		for (int i = 0; i < nodeList.size(); i++) {
			MyNode n = nodeList.get(i);
			// System.out.print("�ֶ���=" + n.getNodeName());
			// System.out.println("\t�ֶ�ֵ=" + n.getTextContent());
			if (n.equalsName("Calendar") && n.equalsNameSpace("http://www.beyondbit.com/smartbox/response/")) {
				cs[i] = CalendarSerializer.parseChildElement(n);
				System.out.println("����=================Calendar=======================\r\n\r\n");
			}
		}
		findDeptCalendarsResponse.setCalendar(cs);
		System.out.println("=findDeptCalendarsResponse=====================" + findDeptCalendarsResponse.getCalendar()[0].getItemID());
		System.out.println("=findDeptCalendarsResponse=====================" + findDeptCalendarsResponse.getCalendar()[0].getSubject());
	}

	private static void stepThrough1(MyNode myNode) {
		QueryProjectPictureResponse queryProjectPictureResponse = new QueryProjectPictureResponse();
		List<MyNode> nodeList =  myNode.getMyNodeList();
		
		
		
		byte[][] bs = new byte[nodeList.size()][];

		for (int i = 0; i < nodeList.size(); i++) {
			MyNode n = nodeList.get(i);
			
			bs[i] =UtilTextContent.toBytes(n.getTextContent());
		}
		queryProjectPictureResponse.setPicture(bs);
	}

	private static void stepThrough(Document doc) {
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		UserStatusList ul = new UserStatusList();
		GetUserStatusResponse getUserStatusResponse = new GetUserStatusResponse();

		// NodeList s1= root.getElementsByTagName("req:Status");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node n = nodeList.item(i);
			// System.out.println(n.getNodeName());
			// System.out.println(n.getNodeType());
			if (n.getNodeName().contains("UserStatusList")) {
				NodeList nodeL = n.getChildNodes();
				System.out.println("��ʼ=================UserStatusList========================\r\n");
				UserStatus[] us = new UserStatus[nodeL.getLength()];
				for (int j = 0; j < nodeL.getLength(); j++) {
					Node n1 = nodeL.item(j);
					if (n1.getNodeName().contains("UserStatus")) {
						NodeList nodeL1 = n1.getChildNodes();
						System.out.println("===============UserStatus=================");
						UserStatus ss = new UserStatus();
						for (int k = 0; k < nodeL1.getLength(); k++) {
							Node n11 = nodeL1.item(k);

							ss.setDescription("setDescription1");
							if (n11.getNodeName().contains("Description")) {
								ss.setDescription(n11.getTextContent());
							}
							if (n11.getNodeName().contains("Status")) {
								ss.setStatus(StatusType.valueOf(n11.getTextContent()));
							}
							if (n11.getNodeName().contains("UserUid")) {
								ss.setUserUid(n11.getTextContent());
							}

							System.out.print("�ֶ���=" + n11.getNodeName());
							System.out.println("\t�ֶ�ֵ=" + n11.getTextContent());
						}
						us[j] = ss;
						System.out.println("===============UserStatus=================\r\n\r\n");
					}
				}
				System.out.println("����=================UserStatusList=======================\r\n\r\n");
				ul.setUserStatus(us);
			}
		}
		// stepThrough(root);
		getUserStatusResponse.setUserStatusList(ul);
		System.out.println(getUserStatusResponse.getUserStatusList().getUserStatus()[0].getStatus() + "===result Statustype");

	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);// ��ȡ�ļ���С
		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// �ļ�̫���޷���ȡ
			throw new IOException("File is to large " + file.getName());
		}
		// ����һ������������ļ����
		byte[] bytes = new byte[(int) length];
		// ��ȡ��ݵ�byte������
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}// ȷ��������ݾ��ȡ
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		// Close the input stream and return bytes
		is.close();
		return bytes;
	}
}
