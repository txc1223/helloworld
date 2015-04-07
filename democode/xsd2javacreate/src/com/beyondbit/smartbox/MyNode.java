package com.beyondbit.smartbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyNode {
	private String name;
	// private HashMap<String, String> nameSpaceMap = new HashMap<String,
	// String>();
	private List<MyNode> myNodeList = new ArrayList<MyNode>();
	// private String textContent;
	private Node node;
	private String nodeNameSpace;
	private String typeNameSpace;

	public MyNode(Node node) {
		super();
		this.node = node;
		// String
		// typeName=node.getAttributes().getNamedItemNS("http://www.w3.org/2001/XMLSchema-instance",
		// "type").getNodeValue();
		// String[] str = typeName.split("\\:");
		// if (str.length > 1) {
		// typeName = str[1];
		// typeNameSpace =
		// node.getAttributes().getNamedItemNS("http://www.w3.org/2000/xmlns/",
		// str[0]).getNodeValue();
		// } else{
		// typeNameSpace =
		// node.getAttributes().getNamedItem("xmlns").getNodeValue();
		// }

		// setNameSpaceMap(nameSpaceMap);
		getRealName(node.getNodeName());
		setNodeList(node.getChildNodes());
		// this.textContent = textContent;
		// this.myNodeList = myNodeList;
	}

	public  String getTypeNameSpace(Node node) {
//		if (node.getAttributes().getNamedItemNS("http://www.w3.org/2001/XMLSchema-instance", "type") == null) {
//			Node n = node.getParentNode();
//			if (n == null) {
//				return null;
//			}
//			return getTypeNameSpace(n);
//		} else {
			String typeName = node.getAttributes().getNamedItemNS("http://www.w3.org/2001/XMLSchema-instance", "type").getNodeValue();
			String[] strs = typeName.split("\\:", 2);
			String pre = strs.length == 1? null: strs[0];
			return getTypeNameSpaceByPre(pre, node);
//			if (str.length > 1) {
//				typeName = str[1];
//				if(node.getAttributes().getNamedItemNS("http://www.w3.org/2000/xmlns/", str[0]).getNodeValue()==null){
//					Node n=node.getParentNode();
//					getTypeNameSpace(n);
//				}
//			} else {
//				typeNameSpace = node.getAttributes().getNamedItem("xmlns").getNodeValue();
//			}
//			System.out.println(typeNameSpace+"--------------typeNameSpace");
//			return typeNameSpace;
//		}
		// Element currentNode = (Element)
		// doc.getElementsByTagName("req:Request").item(0);
		// String attributeValue =
		// currentNode.getAttributes().getNamedItemNS("http://www.w3.org/2001/XMLSchema-instance",
		// "type").getNodeValue();

		// String ddddString =
		// currentNode.getAttributeNodeNS("http://www.w3.org/2000/xmlns/",
		// "req").getNodeValue();
		// currentNode.getChildNodes().item(0).getBaseURI();
		// currentNode.getAttributeNodeNS("", "") == null;
		// currentNode.getParentNode() != NullPointerException
		// System.out.println("ns value is " +
		// currentNode.getChildNodes().item(0).getNamespaceURI());
		// System.out.println("Attribute value is " + ddddString);

	}
	public String getTypeNameSpaceByPre(String str ,Node node){
		Node ns;
		if((ns = getNS(str, node))==null){
			Node parentNode=node.getParentNode();
			if(parentNode == null)
				return null;
			else
				return getTypeNameSpaceByPre(str, parentNode);
		}else{
			return ns.getNodeValue();
		}
	}
	
	private Node getNS(String str, Node node){
		if(str == null )
			return node.getAttributes().getNamedItem("xmlns");
		else
			return node.getAttributes().getNamedItemNS("http://www.w3.org/2000/xmlns/", str);
	}
	// public MyNode(Node node, HashMap<String, String> nameSpaceMap) {
	// super();
	// this.node = node;
	// // setNameSpaceMap(nameSpaceMap);
	// getRealName(node.getNodeName());
	// setNodeList(node.getChildNodes());
	// // this.textContent = textContent;
	// // this.myNodeList = myNodeList;
	// }

	public boolean equalsNameSpace(String nameSpace) {
		// String[] s = this.name.split("\\:");
		// if (s.length > 1) {
		// return nameSpace.equals(nameSpaceMap.get(s[0] + ":"));
		// } else {
		return nameSpace.equals(nodeNameSpace);
		// }

	}

	private void getRealName(String name) {
		nodeNameSpace = node.getNamespaceURI();
		
		String tampName = name;
		String tampNames[] = tampName.split("\\:", 2);
		if (tampNames.length > 1) {
			tampName = tampNames[1];
			// nodeNameSpace =nameSpaceMap.get(tampNames[0]);
		} else {
			// nodeNameSpace = nameSpaceMap.get("");
		}
		this.name = tampName;
		// String[] s = node.getNodeName().split("\\:");
		// if (s.length > 1) {
		// nodeNameSpace = (nameSpaceMap.get(s[0] + ":"));
		// } else {
		// nodeNameSpace = (nameSpaceMap.get(""));
		// }
		//
		// this.nameSpaceMap = nameSpaceMap;

	}

	public boolean equalsName(String name) {
		// String ns[] = name.split("\\:");
		// if (ns.length > 1) {
		// name = ns[1];
		// }
		// String tampName = this.name;
		// String tampNames[] = tampName.split("\\:");
		// if (tampNames.length > 1) {
		// tampName = tampNames[1];
		// }
		return this.name.equals(name);
	}

	public String getName() {
		return node.getNodeName();
	}

	// public HashMap<String, String> getNameSpaceMap() {
	//
	// return nameSpaceMap;
	// }

	public void setName(String name) {
		this.name = name;
	}

	// public void setNameSpaceMap(HashMap<String, String> nameSpaceMap) {
	// NamedNodeMap e = node.getAttributes();
	// if (e != null) {
	// int len = e.getLength();
	// for (int i = 0; i < len; i++) {
	// Node n = e.item(i);
	// if (n.getNodeName().contains("xmlns:")) {
	// nameSpaceMap.put(n.getNodeName().replace("xmlns:", ""),
	// n.getNodeValue());
	// } else if (n.getNodeName().equals("xmlns")) {
	// nameSpaceMap.put("", n.getNodeValue());
	// }
	// }
	// }
	// this.nameSpaceMap = nameSpaceMap;
	// }

	public void setNodeList(NodeList nodeList) {
		int len = nodeList.getLength();
		for (int i = 0; i < len; i++) {
			Node node = nodeList.item(i);
			// if (node.getNodeName().contains("xmlns:")) {
			// nameSpaceMap.put(node.getNodeName().replace("xmlns:", "") + ":",
			// node.getNodeValue() + "/");
			// } else if (node.getNodeName().contains("xmlns=")) {
			// nameSpaceMap.put("", node.getNodeValue() + "/");
			// }
			MyNode myNode = new MyNode(node);
			myNodeList.add(myNode);
		}
	}

	public String getTextContent() {
		return node.getTextContent();
	}

	// public void setTextContent(String textContent) {
	// this.textContent = textContent;
	// }

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public List<MyNode> getMyNodeList() {
		return myNodeList;
	}

	public void setMyNodeList(List<MyNode> myNodeList) {
		this.myNodeList = myNodeList;
	}

}
