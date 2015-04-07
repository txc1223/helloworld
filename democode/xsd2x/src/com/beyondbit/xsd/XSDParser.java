package com.beyondbit.xsd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.jar.Attributes.Name;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.beyondbit.xsd.XSDType.ElementSetMode;

public class XSDParser {
	private XSDInfo xsdInfo;

	public XSDInfo getXsdInfo() {
		return xsdInfo;
	}

	public XSDParser() {
		this.xsdInfo = new XSDInfo();
	}

	public XSDParser(XSDInfo xsdInfo) {
		this.xsdInfo = xsdInfo;
	}

	public void printRootElement() {
		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");
		System.out.print("\r\n");
		System.out.print("type size " + xsdInfo.getRootElementMap().size()
				+ "\r\n");
		System.out.print("\r\n");

		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");

		for (Entry<XSDKey, XSDKey> entry : xsdInfo.getRootElementMap()
				.entrySet()) {
			System.out.print("type : \r\n");
			System.out.print("    ns : " + entry.getKey().getNs() + "\r\n");
			System.out.print("    name : " + entry.getKey().getKey() + "\r\n");
			System.out.print("\r\n");

			System.out.print("element name : \r\n");
			System.out.print("    ns : " + entry.getValue().getNs() + "\r\n");
			System.out
					.print("    name : " + entry.getValue().getKey() + "\r\n");
			System.out.print("\r\n");

			System.out
					.print("---------------------------------------------------------------");
			System.out.print("\r\n");
		}

		System.out.print("\r\n");
		System.out.print("type size " + xsdInfo.getRootElementMap().size()
				+ "\r\n");
		System.out.print("\r\n");

		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");
	}

	public void printType() {
		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");
		System.out.print("\r\n");
		System.out.print("type size " + xsdInfo.getTypeMap().size() + "\r\n");
		System.out.print("\r\n");

		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");

		for (XSDType xsdType : xsdInfo.getTypeMap().values()) {
			System.out.print("name : \r\n");
			System.out.print("    ns : " + xsdType.getName().getNs() + "\r\n");
			System.out.print("    name : " + xsdType.getName().getKey()
					+ "\r\n");
			System.out.print("\r\n");

			if (xsdType.getBaseName() != null) {
				System.out.print("base name : \r\n");
				System.out.print("    ns : " + xsdType.getBaseName().getNs()
						+ "\r\n");
				System.out.print("    name : " + xsdType.getBaseName().getKey()
						+ "\r\n");
				System.out.print("\r\n");
			}

			if (xsdType.isAbstract()) {
				System.out.print("abstract : true\r\n");
				System.out.print("\r\n");

				continue;
			}

			System.out.print("type mode "
					+ xsdType.getElementSetMode().toString() + "\r\n");
			System.out.print("\r\n");

			for (XSDElement xsdElement : xsdType.getElements().values()) {
				System.out.print("element : \r\n");
				System.out.print("    name : \r\n");
				System.out.print("        ns : " + xsdElement.getName().getNs()
						+ "\r\n");
				System.out.print("        name : "
						+ xsdElement.getName().getKey() + "\r\n");
				System.out.print("    type : \r\n");
				System.out.print("        ns : "
						+ xsdElement.getTypeName().getNs() + "\r\n");
				System.out.print("        name : "
						+ xsdElement.getTypeName().getKey() + "\r\n");
				System.out.print("    min occurs : "
						+ xsdElement.getMinOccurs() + "\r\n");
				System.out.print("    max occurs : "
						+ xsdElement.getMaxOccurs() + "\r\n");
				System.out.print("    default value : "
						+ xsdElement.getDefaultValue() + "\r\n");
				System.out.print("\r\n");
			}

			if (xsdType.getEnumStrings().size() > 0) {
				System.out.print("enum \r\n");
				for (String enumString : xsdType.getEnumStrings()) {
					System.out.print("enum string : " + enumString + "\r\n");
				}
				System.out.print("\r\n");
			}

			System.out
					.print("---------------------------------------------------------------");
			System.out.print("\r\n");
		}

		System.out.print("\r\n");
		System.out.print("type size " + xsdInfo.getTypeMap().size() + "\r\n");
		System.out.print("\r\n");

		System.out
				.print("---------------------------------------------------------------");
		System.out.print("\r\n");
	}

	public void parse(String filePath) {
		Document doc = getDocument(filePath);
		Element docElement = doc.getDocumentElement();
		parse(docElement);
	}

	private void parse(Element rootElement) {
		NamesapceInfo nsInfo = checkNS(rootElement);
		NodeList nodeList = rootElement.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				XSDKey xsdKey = getElementNS(element,
						(NamesapceInfo) nsInfo.clone());
				if (xsdKey.equals(XSDKey.COMPLEX_TYPE)) {
					xsdInfo.addXSDType(parseComplexTypeElement(element,
							(NamesapceInfo) nsInfo.clone()));
				} else if (xsdKey.equals(XSDKey.SIMPLE_TYPE)) {
					xsdInfo.addXSDType(parseSimpleTypeElement(element,
							(NamesapceInfo) nsInfo.clone()));
				} else if (xsdKey.equals(XSDKey.ELEMENT)) {
					parseRootElement(element, (NamesapceInfo) nsInfo.clone());
				}
			}
		}
	}

	private void parseRootElement(Element element, NamesapceInfo nsInfo) {
		nsInfo = checkNS(element, nsInfo);

		String elementName = element.getAttribute("name");
		String elementType = element.getAttribute("type");

		XSDKey typeKey = convertNS(elementType, nsInfo);
		XSDKey elementNameKey = convertNS(elementName, nsInfo);

		xsdInfo.addRootElement(typeKey, elementNameKey);
	}

	private XSDType parseSimpleTypeElement(Element element, NamesapceInfo nsInfo) {
		XSDType xsdType = new XSDType();

		nsInfo = checkNS(element, nsInfo);

		String simpleTypeName = element.getAttribute("name");
		xsdType.setName(convertNS(simpleTypeName, nsInfo));

		xsdType.setElementSetMode(ElementSetMode.Enum);

		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element ele = (Element) node;
				XSDKey xsdKey = getElementNS(ele, nsInfo);
				if (xsdKey.equals(XSDKey.RESTRICTION)) {
					parseRestriction(ele, (NamesapceInfo) nsInfo.clone(),
							xsdType);
				}
			}
		}

		return xsdType;
	}

	private void parseRestriction(Element element, NamesapceInfo nsInfo,
			XSDType xsdType) {
		nsInfo = checkNS(element, nsInfo);

		NodeList nodeList = element.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element ele = (Element) node;
				XSDKey xsdKey = getElementNS(ele, nsInfo);
				if (xsdKey.equals(XSDKey.ENUMERATION)) {
					xsdType.getEnumStrings().add(ele.getAttribute("value"));
				}
			}
		}
	}

	private XSDType parseComplexTypeElement(Element element,
			NamesapceInfo nsInfo) {
		XSDType xsdType = new XSDType();

		nsInfo = checkNS(element, nsInfo);

		String complexTypeName = element.getAttribute("name");
		xsdType.setName(convertNS(complexTypeName, nsInfo));

		if (element.hasAttribute("abstract"))
			xsdType.setAbstract(Boolean.parseBoolean(element
					.getAttribute("abstract")));

		if (!xsdType.isAbstract()) {
			NodeList nodeList = element.getChildNodes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == node.ELEMENT_NODE) {
					Element ele = (Element) node;
					XSDKey xsdKey = getElementNS(ele, nsInfo);
					if (xsdKey.equals(XSDKey.SEQUENCE)
							|| xsdKey.equals(XSDKey.ALL)) {
						if (xsdKey.equals(XSDKey.SEQUENCE))
							xsdType.setElementSetMode(ElementSetMode.Sequence);
						else
							xsdType.setElementSetMode(ElementSetMode.All);

						for (XSDElement xsdElement : parseSequenceOrAll(ele,
								(NamesapceInfo) nsInfo.clone())) {
							xsdType.getElements().put(xsdElement.getName(),
									xsdElement);
						}
					} else if (xsdKey.equals(XSDKey.COMPLEX_CONTENT)) {
						xsdType.setComplex(true);
						parseComplexContext(ele,
								(NamesapceInfo) nsInfo.clone(), xsdType);
					}
				}
			}
		}

		return xsdType;
	}

	private void parseComplexContext(Element element, NamesapceInfo nsInfo,
			XSDType xsdType) {
		nsInfo = checkNS(element, nsInfo);
		NodeList nodeList = element.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element ele = (Element) node;
				XSDKey xsdKey = getElementNS(ele, nsInfo);
				if (xsdKey.equals(XSDKey.EXTENSION)) {
					XSDKey baseType = convertNS(ele.getAttribute("base"),
							nsInfo);
					xsdType.setBaseName(baseType);

					parseExtension(ele, (NamesapceInfo) nsInfo.clone(), xsdType);
				}
			}
		}
	}

	private void parseExtension(Element element, NamesapceInfo nsInfo,
			XSDType xsdType) {

		nsInfo = checkNS(element, nsInfo);
		NodeList nodeList = element.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element ele = (Element) node;
				XSDKey xsdKey = getElementNS(ele, nsInfo);

				if (xsdKey.equals(XSDKey.SEQUENCE) || xsdKey.equals(XSDKey.ALL)) {
					if (xsdKey.equals(XSDKey.SEQUENCE))
						xsdType.setElementSetMode(ElementSetMode.Sequence);
					else
						xsdType.setElementSetMode(ElementSetMode.All);

					for (XSDElement xsdElement : parseSequenceOrAll(ele,
							(NamesapceInfo) nsInfo.clone())) {
						xsdType.getElements().put(xsdElement.getName(),
								xsdElement);
					}
				}
			}
		}
	}

	private Set<XSDElement> parseSequenceOrAll(Element element,
			NamesapceInfo nsInfo) {
		Set<XSDElement> elementSet = new LinkedHashSet<XSDElement>();

		nsInfo = checkNS(element, nsInfo);
		NodeList nodeList = element.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element ele = (Element) node;
				XSDKey xsdKey = getElementNS(ele, nsInfo);
				if (xsdKey.equals(XSDKey.ELEMENT)) {
					XSDElement xsdElement = new XSDElement();

					if (ele.hasAttribute("name"))
						xsdElement.setName(new XSDKey(nsInfo.targertNS, ele
								.getAttribute("name")));

					if (ele.hasAttribute("type")) {
						String typeValue = ele.getAttribute("type");
						xsdElement.setTypeName(convertNS(typeValue, nsInfo));
					}

					if (ele.hasAttribute("minOccurs"))
						xsdElement.setMinOccurs(ele.getAttribute("minOccurs"));

					if (ele.hasAttribute("maxOccurs"))
						xsdElement.setMaxOccurs(ele.getAttribute("maxOccurs"));

					if (ele.hasAttribute("default"))
						xsdElement.setDefaultValue(ele.getAttribute("default"));

					elementSet.add(xsdElement);
				}
			}
		}

		return elementSet;
	}

	private XSDKey convertNS(String value, NamesapceInfo nsInfo) {
		String[] valueStrs = value.split(":");
		if (valueStrs.length == 2) {
			String ns = nsInfo.getPreNSMap().get(valueStrs[0]);

			return new XSDKey(ns, valueStrs[1]);
		} else {
			return new XSDKey(nsInfo.targertNS, value);
		}
	}

	private XSDKey getElementNS(Element element, NamesapceInfo nsInfo) {
		if (element.getNodeName().contains(":")) {
			String[] nodeNameStrs = element.getNodeName().split(":");
			if (nodeNameStrs.length == 2) {
				String pre = nodeNameStrs[0];
				return new XSDKey(nsInfo.preNSMap.get(pre), nodeNameStrs[1]);
			}
		}

		return new XSDKey(nsInfo.targertNS, element.getNodeName());
	}

	private NamesapceInfo checkNS(Element element) {
		return checkNS(element, new NamesapceInfo());
	}

	private NamesapceInfo checkNS(Element element, NamesapceInfo nsInfo) {
		NamesapceInfo resultNSInfo = (NamesapceInfo) nsInfo.clone();

		NamedNodeMap attrMap = element.getAttributes();

		for (int i = 0; i < attrMap.getLength(); i++) {
			Node attrNode = attrMap.item(i);

			if (attrNode.getNodeName().equalsIgnoreCase("targetNamespace")) {
				resultNSInfo.setTargertNS(attrNode.getNodeValue());
			} else if (attrNode.getNodeName().contains(":")) {
				String[] nameStrs = attrNode.getNodeName().split(":");
				if (nameStrs.length == 2
						&& nameStrs[0].equalsIgnoreCase("xmlns")) {
					resultNSInfo.getPreNSMap().put(nameStrs[1],
							attrNode.getNodeValue());
				}
			}
		}

		return resultNSInfo;
	}

	private Document getDocument(String filePath) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			return builder.parse(new FileInputStream(filePath));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private class NamesapceInfo {
		private String targertNS;
		private Map<String, String> preNSMap = new HashMap<String, String>();

		public String getTargertNS() {
			return targertNS;
		}

		public void setTargertNS(String targertNS) {
			this.targertNS = targertNS;
		}

		public Map<String, String> getPreNSMap() {
			return preNSMap;
		}

		@Override
		protected Object clone() {
			NamesapceInfo nsInfo = new NamesapceInfo();
			nsInfo.targertNS = targertNS;

			for (Entry<String, String> entry : preNSMap.entrySet()) {
				nsInfo.preNSMap.put(entry.getKey(), entry.getValue());
			}

			return nsInfo;
		}
	}
}
