package com.beyondbit.main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReqeustSer {
	public String ToXml(Object obj) {

		return "";
	}

	public void AppendRootElement(Document doc, Object obj) {
		Element rootElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request", "req:Request");
		rootElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
				"xsi:type", "req:SignInRequest");

		AppendChildElement(doc, obj, rootElement);
		
		doc.appendChild(rootElement);
	}

	public void AppendChildElement(Document doc, Object obj, Element rootElement) {
		Element userUidElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:userUid");
		userUidElement.setTextContent("xuli");
		rootElement.appendChild(userUidElement);

		Element userPwdElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:userPwd");
		userPwdElement.setTextContent("123456");
		rootElement.appendChild(userPwdElement);

		Element clientElement = doc.createElementNS(
				"http://www.beyondbit.com/smartbox/request", "req:client");
		clientElement.setTextContent("Phone/Android");
		rootElement.appendChild(clientElement);
	}
}
