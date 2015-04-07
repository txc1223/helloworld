package com.beyondbit.xsd;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class XSDSerGen {
	private String outDir;
	private XSDInfo xsdInfo;

	public String getOutDir() {
		return outDir;
	}

	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	public void genSerClass(XSDInfo xsdInfo) {
		this.xsdInfo = xsdInfo;

		for (XSDType xsdType : xsdInfo.getTypeMap().values()) {
			genSerClass(xsdType,
					xsdInfo.getRootElementMap().get(xsdType.getName()));
		}
	}

	private void genSerClass(XSDType xsdType, XSDKey rootElementKey) {
		Set<XSDKey> importXsdTypes = new LinkedHashSet<XSDKey>();
		Set<XSDKey> importSerXsdTypes = new LinkedHashSet<XSDKey>();

		String packageName = convertPackageName(xsdType.getName().getNs())
				+ ".serialization";

		StringBuilder builder = new StringBuilder();
		// pacakge name
		builder.append("package " + packageName + ";\r\n");
		builder.append("\r\n");

		// import
		builder.append("import java.io.StringWriter; \r\n");
		builder.append("import java.io.ByteArrayInputStream; \r\n");
		builder.append("import java.text.SimpleDateFormat; \r\n");
		builder.append("import java.util.Date;\r\n");
		builder.append("import java.util.TimeZone;\r\n");

		builder.append("import java.util.HashMap;\r\n");
		builder.append("import java.util.List;\r\n");
		builder.append("import java.util.ArrayList;\r\n");

		builder.append("import javax.xml.parsers.DocumentBuilder; \r\n");
		builder.append("import javax.xml.parsers.DocumentBuilderFactory; \r\n");
		builder.append("import javax.xml.parsers.ParserConfigurationException; \r\n");

		builder.append("import javax.xml.transform.OutputKeys;\r\n");
		builder.append("import javax.xml.transform.TransformerConfigurationException; \r\n");
		builder.append("import javax.xml.transform.Transformer;\r\n");
		builder.append("import javax.xml.transform.TransformerFactory; \r\n");
		builder.append("import javax.xml.transform.dom.DOMSource;\r\n");
		builder.append("import javax.xml.transform.stream.StreamResult; \r\n");

		builder.append("import org.w3c.dom.Document; \r\n");
		builder.append("import org.w3c.dom.Element; \r\n");
		builder.append("import org.w3c.dom.Node; \r\n");
		builder.append("import org.w3c.dom.NamedNodeMap; \r\n");

		builder.append("import util.MyNode; \r\n");
		builder.append("import util.UtilTextContent; \r\n");
		builder.append("import android.util.Base64; \r\n");

		// builder.append("import org.w3c.dom.bootstrap.DOMImplementationRegistry; \r\n");
		// builder.append("import org.w3c.dom.ls.DOMImplementationLS; \r\n");
		// builder.append("import org.w3c.dom.ls.LSOutput; \r\n");
		// builder.append("import org.w3c.dom.ls.LSSerializer; \r\n");
		// builder.append(getImportType(xsdType.getName()));
		if (!importXsdTypes.contains(xsdType.getName()))
			importXsdTypes.add(xsdType.getName());

		// class
		String classStr = "public class %s {\r\n%s}";
		String className = xsdType.getName().getKey() + "Serializer";
		// method
		StringBuilder mthBuilder = new StringBuilder();
		mthBuilder.append("\r\n");

		// method -> AppendRootElement
		if (rootElementKey != null) {
			StringBuilder serBuilder = new StringBuilder();

			serBuilder.append("	public static String serialize("
					+ xsdType.getName().getKey() + " obj) {\r\n");
			serBuilder
					.append("		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();\r\n");
			serBuilder.append("		DocumentBuilder builder = null;\r\n");
			serBuilder.append("		try {\r\n");
			serBuilder
					.append("			builder = builderFactory.newDocumentBuilder();\r\n");
			serBuilder
					.append("		} catch (ParserConfigurationException e) {\r\n");
			serBuilder.append("			e.printStackTrace();\r\n");
			serBuilder.append("		}\r\n");
			serBuilder.append("\r\n");
			serBuilder.append("		Document doc = builder.newDocument();\r\n");
			serBuilder.append("\r\n");
			serBuilder.append("		AppendRootElement(doc, obj);\r\n");
			serBuilder.append("\r\n");

			// serBuilder.append("		ByteArrayOutputStream baos = new ByteArrayOutputStream();\r\n");
			// serBuilder.append("\r\n");
			// serBuilder.append("		DOMImplementationLS ls = null;\r\n");
			// serBuilder.append("		try {\r\n");
			// serBuilder.append("			ls = (DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation(\"LS\");\r\n");
			// serBuilder.append("		} catch (Exception e) {\r\n");
			// serBuilder.append("			e.printStackTrace();\r\n");
			// serBuilder.append("		}\r\n");
			// serBuilder.append("\r\n");
			// serBuilder.append("		LSSerializer ser = ls.createLSSerializer();\r\n");
			// serBuilder.append("		LSOutput out = ls.createLSOutput();\r\n");
			// serBuilder.append("		out.setByteStream(baos);\r\n");
			// serBuilder.append("		ser.write(doc, out);\r\n");
			// serBuilder.append("\r\n");
			// serBuilder.append("		try {\r\n");
			// serBuilder.append("			return new String(baos.toByteArray(), \"UTF-8\");\r\n");
			// serBuilder.append("		} catch (Exception e) {\r\n");
			// serBuilder.append("			e.printStackTrace();\r\n");
			// serBuilder.append("		}\r\n");
			// serBuilder.append("\r\n");

			serBuilder
					.append("		TransformerFactory transFactory = TransformerFactory.newInstance();\r\n");
			serBuilder.append("\r\n");
			serBuilder.append("		Transformer transformer = null;\r\n");
			serBuilder.append("		try {\r\n");
			serBuilder
					.append("			transformer = transFactory.newTransformer();\r\n");
			serBuilder.append("		} catch (Exception e) {\r\n");
			serBuilder.append("			e.printStackTrace();\r\n");
			serBuilder.append("		}\r\n");
			serBuilder.append("\r\n");
			serBuilder
					.append("		StringWriter buffer = new StringWriter();\r\n");
			serBuilder
					.append("		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, \"yes\");\r\n");
			serBuilder.append("\r\n");
			serBuilder.append("		try {\r\n");
			serBuilder
					.append("			transformer.transform(new DOMSource(doc), new StreamResult(buffer));\r\n");
			serBuilder.append("			return buffer.toString();\r\n");
			serBuilder.append("		} catch (Exception e) {\r\n");
			serBuilder.append("			e.printStackTrace();\r\n");
			serBuilder.append("		}\r\n");
			serBuilder.append("\r\n");

			serBuilder.append("		return null;\r\n");
			serBuilder.append("	}\r\n");

			mthBuilder.append(serBuilder);
			mthBuilder.append("\r\n");

			StringBuilder remBuilder = new StringBuilder();
			remBuilder
					.append("	public static void AppendRootElement(Document doc, "
							+ xsdType.getName().getKey() + " obj) {\r\n");
			if (!xsdType.getName().getKey().contains("Response")) {
				remBuilder
						.append("		Element rootElement = doc.createElementNS(\""
								+ rootElementKey.getNs()
								+ "\",\""
								+ convertPrefName(rootElementKey) + "\");\r\n");

				remBuilder.append("\r\n");
				remBuilder
						.append("		AppendChildElement(doc, obj, rootElement,null);\r\n");
				remBuilder.append("\r\n");
				remBuilder.append("		doc.appendChild(rootElement);\r\n");
			}
			remBuilder.append("	}\r\n");

			mthBuilder.append(remBuilder);
			mthBuilder.append("\r\n");

			StringBuilder unSerBuilder = new StringBuilder();
			unSerBuilder.append("public static " + xsdType.getName().getKey()
					+ " unSerialize(String s) {\r\n");
			unSerBuilder.append("	try {\r\n");
			unSerBuilder
					.append("		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();\r\n");
			unSerBuilder.append("		dbFactory.setNamespaceAware(true);\r\n");
			// 从DOM工厂中获得DOM解析器
			unSerBuilder
					.append("		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();\r\n");

			unSerBuilder
					.append("		ByteArrayInputStream sb = new ByteArrayInputStream(s.getBytes());\r\n");

			// 把要解析的xml文档读入DOM解析器
			unSerBuilder.append("		Document doc = dbBuilder.parse(sb);\r\n");
			unSerBuilder
					.append("		Element root = doc.getDocumentElement();\r\n");

			unSerBuilder
					.append("		NamedNodeMap e = doc.getDocumentElement().getAttributes();\r\n");

			// unSerBuilder.append("		String typeName = null;\r\n");
			// ee.getOwnerDocument().getNodeName();

			unSerBuilder.append("		MyNode myNode = new MyNode(root);\r\n");
			// String typeName =
			// root.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance",
			// "type").getNodeValue();

			// String[] str = typeName.split("\\:");
			// if (str.length > 1) {
			// typeName = str[1];
			// }
			//
			// String jiedianName = myNode.getName();

			unSerBuilder
					.append("		String typeName = root.getAttributeNodeNS(\"http://www.w3.org/2001/XMLSchema-instance\", \"type\").getNodeValue();\r\n");
			unSerBuilder
					.append("		String[] str = typeName.split(\"\\\\:\");\r\n");
			unSerBuilder.append("		if (str.length > 1) {\r\n");
			unSerBuilder.append("			typeName = str[1];\r\n");
			unSerBuilder.append("		} \r\n");

			unSerBuilder.append("		String jiedianName = myNode.getName();\r\n");
			// unSerBuilder.append("		for (String name : map.keySet()) {\r\n");
			// unSerBuilder.append("			String value = map.get(name);\r\n");
			// unSerBuilder.append("			jiedianName = jiedianName.replaceAll(name, value);\r\n");
			// unSerBuilder.append("		}\r\n");
			unSerBuilder
					.append("		System.out.println(\"typeName=\" + typeName);\r\n");
			unSerBuilder
					.append("		System.out.println(\"jiedianName=\" + jiedianName);\r\n");

			// 取得要元素名
			unSerBuilder
					.append("		System.out.println(\"The root element is:\" + root.getNodeName());\r\n");
			// unSerBuilder.append("		MyNode myNode = new MyNode(jiedianName, map, doc.getDocumentElement().getChildNodes(), \"\");\r\n");

			unSerBuilder.append("		if (myNode.equalsName(\""
					+ xsdType.getName().getKey()
					+ "\") && myNode.equalsNameSpace(\""
					+ rootElementKey.getNs() + "\")) {\r\n");
			if (!xsdType.getName().getKey().contains("Request")) {
				unSerBuilder
						.append("			String typeNameSpace=myNode.getTypeNameSpace(myNode.getNode());\r\n");
				unSerBuilder
						.append("			return parseChildElement(null,typeName, myNode,typeNameSpace);\r\n");
			}
			unSerBuilder.append("		}\r\n");
			unSerBuilder.append("		return null;\r\n");

			unSerBuilder.append("	} catch (Exception e) {\r\n");
			unSerBuilder.append("		e.printStackTrace();\r\n");
			unSerBuilder.append("	}\r\n");

			unSerBuilder.append("	return null;\r\n");
			unSerBuilder.append("}\r\n");

			// if (typeName.equals("FindPersonnelCalendarsResponse")) {
			// return
			// FindPersonnelCalendarsResponseSerializer.parseChildElement(nodeList);
			// }

			mthBuilder.append(unSerBuilder);
			mthBuilder.append("\r\n");

		}

		// method -> AppendChildElement
		boolean acEnd = false;

		StringBuilder acBuilder = new StringBuilder();
		if (!xsdType.getName().getNs().contains("response")) {
			acBuilder
					.append("	public static void AppendChildElement(Document doc, "
							+ xsdType.getName().getKey()
							+ " obj, Element parentElement,Class clazz) {\r\n");

			if (xsdType.getEnumStrings() != null
					&& xsdType.getEnumStrings().size() > 0) {
				acBuilder
						.append("		parentElement.setTextContent(obj.toString());\r\n");
			}

			if (xsdType.getBaseName() != null) {
				if (!importXsdTypes.contains(xsdType.getBaseName()))
					importXsdTypes.add(xsdType.getBaseName());

				if (!importSerXsdTypes.contains(xsdType.getBaseName()))
					importSerXsdTypes.add(xsdType.getBaseName());

				if (xsdType.getBaseName().getNs()
						.equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
					acBuilder.append("		return obj.toString();\r\n");
					acEnd = true;
				}
				// else {
				// String baseClassName = xsdType.getBaseName().getKey() +
				// "Serializer";
				// acBuilder.append("		" + baseClassName +
				// ".AppendChildElement(doc, obj, parentElement);\r\n");
				// }
			}

			if (!acEnd) {
				// boolean hasTime = false;
				for (XSDElement xsdElement : xsdType.getElements().values()) {
					if (!importXsdTypes.contains(xsdElement.getTypeName()))
						importXsdTypes.add(xsdElement.getTypeName());

					if (!importSerXsdTypes.contains(xsdElement.getTypeName()))
						importSerXsdTypes.add(getClassName(xsdElement
								.getTypeName()));

					if (xsdElement.getMaxOccurs().equalsIgnoreCase("unbounded")) {
						String typeNameStr = getTypeStringPre(xsdElement
								.getTypeName());
						String fName = typeNameStr.substring(0, 1)
								.toLowerCase()
								+ typeNameStr.substring(1)
								+ "Obj";
						acBuilder.append("		"
								+ "if(obj.get"
								+ firstUpperString(xsdElement.getName()
										.getKey()) + "()!=null)\r\n");
						acBuilder.append("		for("
								+ getTypeString(xsdElement.getTypeName())
								+ " "
								+ fName
								+ " : "
								+ "obj.get"
								+ firstUpperString(xsdElement.getName()
										.getKey()) + "()" + "){\r\n");
						String fieldName = xsdElement.getName().getKey()
								+ "Element";
						acBuilder.append("			Element " + fieldName
								+ " = doc.createElementNS(\""
								+ xsdElement.getName().getNs() + "\",\""
								+ convertPrefName(xsdElement.getName())
								+ "\");\r\n");
						if (xsdElement
								.getTypeName()
								.getNs()
								.equalsIgnoreCase(
										"http://www.w3.org/2001/XMLSchema")) {
							if ("byte[]".equals(getTypeString(xsdElement
									.getTypeName()))) {
								// Base64.encodeToString(bytesObj,
								// Base64.NO_WRAP)
								acBuilder
										.append("		"
												+ fieldName
												+ ".setTextContent(Base64.encodeToString("
												+ fName
												+ ", Base64.NO_WRAP));\r\n");
							} else {
								acBuilder.append("		" + fieldName
										+ ".setTextContent(" + fName
										+ " + \"\");\r\n");
							}
						} else {
							String childClassName = getClassName(
									xsdElement.getTypeName()).getKey()
									+ "Serializer";
							acBuilder.append("			" + childClassName
									+ ".AppendChildElement(doc, " + fName
									+ ", " + fieldName + ","
									+ xsdElement.getTypeName().getKey()
									+ ".class);\r\n");
						}

						acBuilder.append("			parentElement.appendChild("
								+ fieldName + ");\r\n");
						acBuilder.append("		}\r\n");
						acBuilder.append("\r\n");
					} else {
						// if (obj.getHasReminderOffset()&&
						// obj.getReminderOffset()!=null) {
						// if ("1".equals(max) && "0".equals(min) &&
						// !type.contains("String")) {
						if (!xsdElement.getTypeName().getKey()
								.equalsIgnoreCase("String")) {
							acBuilder.append("		"
									+ "if(obj.getHas"
									+ firstUpperString(xsdElement.getName()
											.getKey()) + "()){\r\n");
						} else {
							acBuilder.append("		"
									+ "if(obj.get"
									+ firstUpperString(xsdElement.getName()
											.getKey()) + "()!=null){\r\n");
						}
						String fieldName = xsdElement.getName().getKey()
								+ "Element";
						acBuilder.append("		Element " + fieldName
								+ " = doc.createElementNS(\""
								+ xsdElement.getName().getNs() + "\",\""
								+ convertPrefName(xsdElement.getName())
								+ "\");\r\n");
						if (xsdElement
								.getTypeName()
								.getNs()
								.equalsIgnoreCase(
										"http://www.w3.org/2001/XMLSchema")) {
							String proStr;
							if (xsdElement.getTypeName().getKey()
									.equalsIgnoreCase("dateTime")) {
								// if (!hasTime) {

								// ViewStartTimeElement.setTextContent(UtilTextContent.date2String(obj.getViewStartTime().getTime()));
								// acBuilder.append("		String strTz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT);\r\n");
								// acBuilder.append("		String strTz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT);\r\n");
								// acBuilder.append("		strTz = strTz.substring(strTz.length() - 5).substring(0, 3)+\":00\";\r\n");
								// hasTime = true;
								// }
								proStr = "UtilTextContent.date2String(obj.get"
										+ firstUpperString(xsdElement.getName()
												.getKey()) + "().getTime())";
							} else {
								proStr = "obj.get"
										+ firstUpperString(xsdElement.getName()
												.getKey()) + "() + \"\"";
							}
							// acBuilder.append("		" +
							// "if(!\"null\".equals(obj.get"
							// + firstUpperString(xsdElement.getName().getKey())
							// +
							// "()+\"\"))\r\n");
							acBuilder.append("			" + fieldName
									+ ".setTextContent(" + proStr + ");\r\n");
						} else {
							String childStr = "obj.get"
									+ firstUpperString(xsdElement.getName()
											.getKey()) + "()";
							String childClassName = getClassName(
									xsdElement.getTypeName()).getKey()
									+ "Serializer";

							acBuilder.append("			" + childClassName
									+ ".AppendChildElement(doc, " + childStr
									+ ", " + fieldName + ","
									+ xsdElement.getTypeName().getKey()
									+ ".class);\r\n");
						}

						acBuilder.append("		parentElement.appendChild("
								+ fieldName + ");\r\n");
						acBuilder.append("		}\r\n");
						acBuilder.append("\r\n");
					}
				}

				if (xsdInfo.getTypeParentMap().containsKey(xsdType.getName())) {
					Set<XSDType> childTypes = xsdInfo.getTypeParentMap().get(
							xsdType.getName());

					if (childTypes.size() > 0) {
						StringBuilder tcBuilder = new StringBuilder();
						tcBuilder.append("		Class<? extends "
								+ xsdType.getName().getKey()
								+ "> cls = obj.getClass();\r\n");
						tcBuilder.append("\r\n");

						boolean isFirst = true;
						for (XSDType childType : childTypes) {
							if (!importXsdTypes.contains(childType.getName()))
								importXsdTypes.add(childType.getName());

							if (!importSerXsdTypes
									.contains(childType.getName()))
								importSerXsdTypes.add(childType.getName());

							if (isFirst) {
								isFirst = false;

								tcBuilder.append("		if (cls.equals("
										+ convertPackageName(childType
												.getName().getNs()) + "."
										+ childType.getName().getKey()
										+ ".class)) {\r\n");
								tcBuilder
										.append("			if (!cls.equals(clazz)) \r\n");

								if (xsdType.getName().getNs()
										.equals(childType.getName().getNs())) {
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2001/XMLSchema-instance\",\"xsi:type\",\""
													+ convertPrefNamePre(xsdType
															.getName())
													+ ":\""
													+ "+obj.getClass().getSimpleName()"
													+ ");\r\n");
								} else {
									// rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/",
									// "xmlns:and",
									// "http://www.beyondbit.com/smartbox/android");
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2000/xmlns/\",\"xmlns:"
													+ convertPrefNamePre(childType
															.getName())
													+ "\", \""
													+ childType.getName()
															.getNs()
													+ "\");\r\n");
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2001/XMLSchema-instance\",\"xsi:type\",\""
													+ convertPrefNamePre(childType
															.getName())
													+ ":\""
													+ "+obj.getClass().getSimpleName()"
													+ ");\r\n");
								}

								tcBuilder
										.append("			"
												+ convertPackageName(childType
														.getName().getNs())
												+ ".serialization"
												+ "."
												+ childType.getName().getKey()
												+ "Serializer.AppendChildElement(doc, ("
												+ convertPackageName(childType
														.getName().getNs())
												+ "."
												+ childType.getName().getKey()
												+ ") obj, parentElement,null);\r\n");
								tcBuilder.append("		}");
							} else {
								tcBuilder.append("	 else if (cls.equals("
										+ convertPackageName(childType
												.getName().getNs()) + "."
										+ childType.getName().getKey()
										+ ".class)) {\r\n");
								tcBuilder
										.append("			if (!cls.equals(clazz)) \r\n");
								if (xsdType.getName().getNs()
										.equals(childType.getName().getNs())) {
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2001/XMLSchema-instance\",\"xsi:type\",\""
													+ convertPrefNamePre(xsdType
															.getName())
													+ ":\""
													+ "+obj.getClass().getSimpleName()"
													+ ");\r\n");
								} else {
									// rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/",
									// "xmlns:and",
									// "http://www.beyondbit.com/smartbox/android");
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2000/xmlns/\",\"xmlns:"
													+ convertPrefNamePre(childType
															.getName())
													+ "\", \""
													+ childType.getName()
															.getNs()
													+ "\");\r\n");
									tcBuilder
											.append("			parentElement.setAttributeNS(\"http://www.w3.org/2001/XMLSchema-instance\",\"xsi:type\",\""
													+ convertPrefNamePre(childType
															.getName())
													+ ":\""
													+ "+obj.getClass().getSimpleName()"
													+ ");\r\n");
								}
								tcBuilder
										.append("			"
												+ convertPackageName(childType
														.getName().getNs())
												+ ".serialization"
												+ "."
												+ childType.getName().getKey()
												+ "Serializer.AppendChildElement(doc, ("
												+ convertPackageName(childType
														.getName().getNs())
												+ "."
												+ childType.getName().getKey()
												+ ") obj, parentElement,null);\r\n");
								tcBuilder.append("		}");
							}
						}

						tcBuilder.append("\r\n");
						acBuilder.append(tcBuilder);
					}
				}
			}

			acBuilder.append("	}\r\n");
		}
		if (!xsdType.getName().getNs().contains("request")) {
			acBuilder
					.append("	public static "
							+ xsdType.getName().getKey()
							+ " parseChildElement("
							+ xsdType.getName().getKey()
							+ " "
							+ firstLowerString(xsdType.getName().getKey())
							+ ",String typeName,MyNode node,String typeNameSpace) {\r\n");

			// 如果有list类型 就声明
			for (XSDElement xsdElement : xsdType.getElements().values()) {
				if (xsdElement.getMaxOccurs().equalsIgnoreCase("unbounded")) {
					String listName = xsdElement.getName().getKey()
							.replace("[]", "")
							+ "ListData";
					listName = firstLowerString(listName);
					acBuilder.append("		ArrayList<"
							+ getTypeString(xsdElement.getTypeName()) + "> "
							+ listName + "=new ArrayList<"
							+ getTypeString(xsdElement.getTypeName())
							+ "> ();\r\n");
				}
			}

			// 如果有子节点 就要判断 传入参数是否为空
			String fName = xsdType.getName().getKey().substring(0, 1)
					.toLowerCase()
					+ xsdType.getName().getKey().substring(1);
			if (xsdType.getElements().values().size() > 0) {
				// acBuilder.append("		" + xsdType.getName().getKey() + " " +
				// fName
				// + " = new " + xsdType.getName().getKey() + "();\r\n");

				acBuilder.append("		if ("
						+ firstLowerString(xsdType.getName().getKey())
						+ " == null)\r\n");
				acBuilder.append("			"
						+ firstLowerString(xsdType.getName().getKey())
						+ " = new " + xsdType.getName().getKey() + "();\r\n");

			}
			// 如果是枚举 或者字节点下有对象 就进行for循环 赋值

			// 如果有If else的深层对象 就生成if else 代码 生成后的代码acsBuilder 可以加入各中情况中
			StringBuilder acsBuilder = new StringBuilder();
			if (xsdInfo.getTypeParentMap().containsKey(xsdType.getName())) {

				Set<XSDType> childTypes = xsdInfo.getTypeParentMap().get(
						xsdType.getName());

				if (childTypes.size() > 0) {
					StringBuilder tcBuilder = new StringBuilder();

					boolean isFirst = true;
					for (XSDType childType : childTypes) {
						if (!importXsdTypes.contains(childType.getName()))
							importXsdTypes.add(childType.getName());

						if (!importSerXsdTypes.contains(childType.getName()))
							importSerXsdTypes.add(childType.getName());

						if (isFirst) {
							isFirst = false;

							tcBuilder.append("		if (typeName.equals(\""
									+ childType.getName().getKey()
									+ "\")&& typeNameSpace.equals(\""
									+ childType.getName().getNs()
									+ "\")) {\r\n");
							tcBuilder.append("			"
									+ firstLowerString(xsdType.getName()
											.getKey()) + "= new "
									+ childType.getName().getKey() + "();\r\n");
							tcBuilder.append("			"
									+ childType.getName().getKey()
									+ "Serializer.parseChildElement(("
									+ childType.getName().getKey()
									+ ")"
									+ firstLowerString(xsdType.getName()
											.getKey())
									+ ",typeName,node,typeNameSpace);\r\n");
							tcBuilder.append("		}");
						} else {
							tcBuilder.append("		 else if (typeName.equals(\""
									+ childType.getName().getKey()
									+ "\")&& typeNameSpace.equals(\""
									+ childType.getName().getNs()
									+ "\")) {\r\n");
							tcBuilder.append("			"
									+ firstLowerString(xsdType.getName()
											.getKey()) + "= new "
									+ childType.getName().getKey() + "();\r\n");
							tcBuilder.append("			"
									+ childType.getName().getKey()
									+ "Serializer.parseChildElement(("
									+ childType.getName().getKey()
									+ ")"
									+ firstLowerString(xsdType.getName()
											.getKey())
									+ ",typeName,node,typeNameSpace);\r\n");
							tcBuilder.append("		}");
						}
					}

					tcBuilder.append("\r\n");
					acsBuilder.append(tcBuilder);
				}

			}
			acBuilder.append(acsBuilder);

			if ((xsdType.getEnumStrings() != null && xsdType.getEnumStrings()
					.size() > 0) || xsdType.getElements().values().size() > 0) {
				//
				acBuilder
						.append("		List<MyNode> nodeList=node.getMyNodeList();\r\n");
				acBuilder.append("		int len=nodeList.size();\r\n");
				acBuilder.append("		for (int i = 0; i < len; i++) {\r\n");
				acBuilder.append("			MyNode n = nodeList.get(i);\r\n");
			}
			// 如果是枚举 就这样结尾 里面可能有 if else 深层对象解析（acsBuilder）
			if (xsdType.getEnumStrings() != null
					&& xsdType.getEnumStrings().size() > 0) {

				// acBuilder.append("				for (int i = 0; i < nodeList.size(); i++) {\r\n");
				// acBuilder.append("					MyNode n = nodeList.get(i);\r\n");
				acBuilder.append("			return " + xsdType.getName().getKey()
						+ ".valueOf(n.getTextContent());\r\n");
				acBuilder.append("		}\r\n");
				// acBuilder.append(acsBuilder);
				acBuilder.append("			return null;\r\n");
				// acBuilder.append("		}\r\n");
			}
			// 如果有多个子节点
			if (xsdType.getElements().values().size() > 0) {
				// acBuilder.append("		public static " +
				// xsdType.getName().getKey()
				// +
				// " parseChildElement(String typeName, List<MyNode> nodeList) {\r\n");
				// acBuilder.append(acsBuilder);
				// if (typeName.equals("FindPersonnelCalendarsResponse")) {
				// return
				// FindPersonnelCalendarsResponseSerializer.parseChildElement(nodeList);
				// }

				// String fName = xsdType.getName().getKey().substring(0,
				// 1).toLowerCase() + xsdType.getName().getKey().substring(1);
				// acBuilder.append("		" + xsdType.getName().getKey() + " " +
				// fName
				// + " = new " + xsdType.getName().getKey() + "();\r\n");

				for (XSDElement xsdElement : xsdType.getElements().values()) {
					if (!importXsdTypes.contains(xsdElement.getTypeName()))
						importXsdTypes.add(xsdElement.getTypeName());

					if (!importSerXsdTypes.contains(xsdElement.getTypeName()))
						importSerXsdTypes.add(getClassName(xsdElement
								.getTypeName()));
					// 子节点如果是list类型
					if (xsdElement.getMaxOccurs().equalsIgnoreCase("unbounded")) {
						// return findPersonnelCalendarsResponse;
						String listName = xsdElement.getName().getKey()
								.replace("[]", "")
								+ "ListData";
						listName = firstLowerString(listName);
						// list中的元素如果是基本类型
						if (xsdElement
								.getTypeName()
								.getNs()
								.equalsIgnoreCase(
										"http://www.w3.org/2001/XMLSchema")) {
							// acBuilder.append("		ArrayList<" +
							// getTypeString(xsdElement.getTypeName()) + "> " +
							// listName + "=new ArrayList<" +
							// getTypeString(xsdElement.getTypeName())
							// + "> ();\r\n");
							acBuilder.append("		if (n.equalsName(\""
									+ xsdElement.getName().getKey()
									+ "\") && n.equalsNameSpace(\""
									+ xsdElement.getName().getNs()
									+ "\")) {\r\n");
							// acBuilder.append("				for (int i = 0; i < nodeList.size(); i++) {\r\n");
							// acBuilder.append("					MyNode n = nodeList.get(i);\r\n");
							acBuilder.append("			//"
									+ xsdElement.getTypeName().getKey()
									+ ";\r\n");
							if ("byte[]".equals(getTypeString(xsdElement
									.getTypeName()))) {
								// Base64.encodeToString(bytesObj,
								// Base64.NO_WRAP)
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toBytes(n.getTextContent()));\r\n");
							} else if ("int".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toInt(n.getTextContent()));\r\n");
							} else if ("long".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toLong(n.getTextContent()));\r\n");
							} else if ("boolean"
									.equals(getTypeString(xsdElement
											.getTypeName()))) {
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toBoolean(n.getTextContent()));\r\n");
							} else if ("double".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toDouble(n.getTextContent()));\r\n");
							} else if (xsdElement.getTypeName().getKey()
									.equalsIgnoreCase("dateTime")) {
								acBuilder
										.append("		"
												+ listName
												+ ".add(UtilTextContent.toCalendar(n.getTextContent()));\r\n");
							} else {
								acBuilder.append("		" + listName
										+ ".add(n.getTextContent());\r\n");
							}

							acBuilder.append("		continue;\r\n");
							acBuilder.append("	}\r\n");
							if (!"byte[]".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder.append("		"
										+ fName
										+ ".set"
										+ firstUpperString(xsdElement.getName()
												.getKey())
										+ "("
										+ listName
										+ ".toArray(new "
										+ getTypeString(xsdElement
												.getTypeName()) + "["
										+ listName + ".size()]));\r\n");
							} else {
								// acBuilder.append("			" + fName + ".set" +
								// firstUpperString(xsdElement.getName().getKey())
								// +
								// "(" + listName + ".toArray(new byte" + "[" +
								// listName
								// + ".size()][]));\r\n");
							}
							// acBuilder.append("			}\r\n");
						} else {
							// list中的元素如果是自定义类型
							acBuilder.append("			//"
									+ getTypeString(xsdElement.getTypeName())
									+ ";\r\n");
							// acBuilder.append("		ArrayList<" +
							// getTypeString(xsdElement.getTypeName()) + "> " +
							// listName + "=new ArrayList<" +
							// getTypeString(xsdElement.getTypeName())
							// + "> ();\r\n");
							// acBuilder.append("			for (int i = 0; i < nodeList.size(); i++) {\r\n");
							// acBuilder.append("			MyNode n = nodeList.get(i);\r\n");
							// unSerBuilder.append("	if (n.getNodeName().contains(\"Calendar\")) {\r\n");
							acBuilder.append("		if (n.equalsName(\""
									+ xsdElement.getName().getKey()
									+ "\") && n.equalsNameSpace(\""
									+ xsdElement.getName().getNs()
									+ "\")) {\r\n");
							acBuilder.append("		"
									+ listName
									+ ".add(("
									+ xsdElement.getTypeName().getKey()
									+ ")"
									+ getClassName(xsdElement.getTypeName())
											.getKey()
									+ "Serializer.parseChildElement(null,\""
									+ xsdElement.getTypeName().getKey()
									+ "\",n,\""
									+ xsdElement.getTypeName().getNs()
									+ "\"));\r\n");
							acBuilder.append("			continue;\r\n");
							acBuilder.append("		}\r\n");
							// acBuilder.append("		}\r\n");
							// acBuilder.append("		" + fName + ".set" +
							// firstUpperString(xsdElement.getName().getKey()) +
							// "("
							// + listName + ".toArray(new "
							// + getTypeString(xsdElement.getTypeName()) + "[" +
							// listName + ".size()]));\r\n");
						}

						// acBuilder.append("		return " + fName + ";\r\n");
						// acBuilder.append("		}\r\n");
						acBuilder.append("\r\n");
					} else {
						// 子节点如果不是list类型
						acBuilder.append("			//"
								+ xsdElement.getTypeName().getKey() + ";\r\n");
						// acBuilder.append("				for (int i = 0; i < nodeList.size(); i++) {\r\n");
						// acBuilder.append("					MyNode n = nodeList.get(i);\r\n");

						acBuilder.append("			if (n.equalsName(\""
								+ xsdElement.getName().getKey()
								+ "\") && n.equalsNameSpace(\""
								+ xsdElement.getName().getNs() + "\")) {\r\n");
						// 如果是基本类型

						if (xsdElement
								.getTypeName()
								.getNs()
								.equalsIgnoreCase(
										"http://www.w3.org/2001/XMLSchema")) {
							if ("byte[]".equals(getTypeString(xsdElement
									.getTypeName()))) {
								// Base64.encodeToString(bytesObj,
								// Base64.NO_WRAP)
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toBytes(n.getTextContent()));\r\n");
							} else if ("int".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toInt(n.getTextContent()));\r\n");
							} else if ("long".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toLong(n.getTextContent()));\r\n");
							} else if ("boolean"
									.equals(getTypeString(xsdElement
											.getTypeName()))) {
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toBoolean(n.getTextContent()));\r\n");
							} else if ("double".equals(getTypeString(xsdElement
									.getTypeName()))) {
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toDouble(n.getTextContent()));\r\n");
							} else if (xsdElement.getTypeName().getKey()
									.equalsIgnoreCase("dateTime")) {
								acBuilder
										.append("			"
												+ fName
												+ ".set"
												+ firstUpperString(xsdElement
														.getName().getKey())
												+ "(UtilTextContent.toCalendar(n.getTextContent()));\r\n");
							} else {
								acBuilder.append("			"
										+ fName
										+ ".set"
										+ firstUpperString(xsdElement.getName()
												.getKey())
										+ "(n.getTextContent());\r\n");
							}
						} else {
							// 如果是自定义类型 就用自定义类型解析器解析
							acBuilder.append("			"
									+ fName
									+ ".set"
									+ firstUpperString(xsdElement.getName()
											.getKey())
									+ "(("
									+ xsdElement.getTypeName().getKey()
									+ ")"
									+ getClassName(xsdElement.getTypeName())
											.getKey()
									+ "Serializer.parseChildElement(null,\""
									+ xsdElement.getTypeName().getKey()
									+ "\",n,\""
									+ xsdElement.getTypeName().getNs()
									+ "\"));\r\n");
						}
						acBuilder.append("			continue;\r\n");
						// acBuilder.append("						}\r\n");
						acBuilder.append("			}\r\n");

					}
				}

				// acBuilder.append("					return " + fName + ";\r\n");
				// acBuilder.append("				}\r\n");
				// 如果没有子节点 也没有枚举 并且不是if else 深层对象
				// acBuilder.append(acsBuilder);估计也不用写 应该没有内容
			} else if ((xsdType.getEnumStrings() == null || xsdType
					.getEnumStrings().size() <= 0)
					&& !xsdInfo.getTypeParentMap().containsKey(
							xsdType.getName())) {
				// acBuilder.append("		public static " +
				// xsdType.getName().getKey()
				// +
				// " parseChildElement(String typeName, List<MyNode> nodeList) {\r\n");
				// acBuilder.append(acsBuilder);
				// acBuilder.append("		return new " + xsdType.getName().getKey()
				// +
				// "();\r\n");
				// acBuilder.append("		}\r\n");
				// 如果没有子节点 也不是枚举 但有 if else 深层对象
			} else if ((xsdType.getEnumStrings() == null || xsdType
					.getEnumStrings().size() <= 0)) {
				// acBuilder.append("		public static " +
				// xsdType.getName().getKey()
				// +
				// " parseChildElement(String typeName, List<MyNode> nodeList) {\r\n");
				// acBuilder.append(acsBuilder);
				acBuilder.append("		return "
						+ firstLowerString(xsdType.getName().getKey())
						+ ";\r\n");
				acBuilder.append("		}\r\n");
			}

			// 如果是枚举 或者字节点下有对象 的结尾
			if ((xsdType.getEnumStrings() != null && xsdType.getEnumStrings()
					.size() > 0) || xsdType.getElements().values().size() > 0) {
				acBuilder.append("		}\r\n");
			}
			// 如果有list类型 以上有声明 这里就是赋值
			for (XSDElement xsdElement : xsdType.getElements().values()) {
				if (xsdElement.getMaxOccurs().equalsIgnoreCase("unbounded")) {
					String listName = xsdElement.getName().getKey()
							.replace("[]", "")
							+ "ListData";
					listName = firstLowerString(listName);
					if (xsdElement
							.getTypeName()
							.getNs()
							.equalsIgnoreCase(
									"http://www.w3.org/2001/XMLSchema")) {
						if (!"byte[]".equals(getTypeString(xsdElement
								.getTypeName()))) {
							acBuilder.append("			"
									+ fName
									+ ".set"
									+ firstUpperString(xsdElement.getName()
											.getKey()) + "(" + listName
									+ ".toArray(new "
									+ getTypeString(xsdElement.getTypeName())
									+ "[" + listName + ".size()]));\r\n");
						} else {
							acBuilder.append("			"
									+ fName
									+ ".set"
									+ firstUpperString(xsdElement.getName()
											.getKey()) + "(" + listName
									+ ".toArray(new byte" + "[" + listName
									+ ".size()][]));\r\n");
						}

					} else {
						acBuilder.append("		"
								+ fName
								+ ".set"
								+ firstUpperString(xsdElement.getName()
										.getKey()) + "(" + listName
								+ ".toArray(new "
								+ getTypeString(xsdElement.getTypeName()) + "["
								+ listName + ".size()]));\r\n");
					}
				}

			}

			// 如果不是枚举 并且没有If else的深层对象解析 新建的对象 在这返回
			if (((xsdType.getEnumStrings() == null || xsdType.getEnumStrings()
					.size() <= 0) && !xsdInfo.getTypeParentMap().containsKey(
					xsdType.getName()))
					|| xsdType.getElements().values().size() > 0) {
				//
				acBuilder.append("		return " + fName + ";\r\n");
				acBuilder.append("	}\r\n");
			}
			// acBuilder.append("					return " + fName + ";\r\n");
		}
		mthBuilder.append(acBuilder);
		mthBuilder.append("\r\n");

		for (XSDKey xsdKey : importXsdTypes) {
			if (builder.indexOf("."+xsdKey.getKey() + ";") == -1)
				builder.append(getImportType(xsdKey));
		}

		for (XSDKey xsdKey : importSerXsdTypes) {
			if (builder.indexOf("."+xsdKey.getKey() + "Serializer;") == -1)
				builder.append(getSerImportType(xsdKey));
		}

		builder.append("\r\n");
		builder.append(String.format(classStr, className, mthBuilder));

		String classFilePath = getClassFilePath(packageName, className);

		try {
			File file = new File(classFilePath);
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			FileOutputStream fos = new FileOutputStream(classFilePath);
			fos.write(builder.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private XSDKey getClassName(XSDKey key) {
		if (key.getNs().equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
			return key;
		}
		Map<XSDKey, XSDType> map = xsdInfo.getTypeMap();
		while (true) {
			XSDType xSDType = map.get(key);
			System.out.println(key + "-----------key");

			XSDKey baseName = xSDType.getBaseName();

			if (baseName == null) {
				return xSDType.getName();
			} else {

				return getClassName(baseName);
			}
		}

		// return null;
	}

	private String getTypeString(XSDKey type) {
		if (type.getNs().equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
			if (type.getKey().equalsIgnoreCase("string")) {
				return "String";
			} else if (type.getKey().equalsIgnoreCase("int")) {
				return "int";
			} else if (type.getKey().equalsIgnoreCase("long")) {
				return "long";
			} else if (type.getKey().equalsIgnoreCase("base64Binary")) {
				return "byte[]";
			} else if (type.getKey().equalsIgnoreCase("boolean")) {
				return "boolean";
			} else if (type.getKey().equalsIgnoreCase("double")) {
				return "double";
			}

			System.out.print(type.getKey() + "\r\n");

			return "";
		} else {
			return type.getKey();
		}
	}

	private String getTypeStringPre(XSDKey type) {
		if (type.getNs().equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
			if (type.getKey().equalsIgnoreCase("string")) {
				return "String";
			} else if (type.getKey().equalsIgnoreCase("int")) {
				return "int";
			} else if (type.getKey().equalsIgnoreCase("long")) {
				return "long";
			} else if (type.getKey().equalsIgnoreCase("base64Binary")) {
				return "bytes";
			}

			System.out.print(type.getKey() + "\r\n");

			return "";
		} else {
			return type.getKey();
		}
	}

	private String getImportType(XSDKey type) {
		if (type.getNs().equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
			if (type.getKey().equalsIgnoreCase("string")) {

			}

			return "";
		} else {
			String packageName = convertPackageName(type.getNs());
			return "import " + packageName + "." + type.getKey() + ";\r\n";
		}
	}

	private String getSerImportType(XSDKey type) {
		if (type.getNs().equalsIgnoreCase("http://www.w3.org/2001/XMLSchema")) {
			if (type.getKey().equalsIgnoreCase("string")) {

			}

			return "";
		} else {
			String packageName = convertPackageName(type.getNs())
					+ ".serialization";
			return "import " + packageName + "." + type.getKey() + "Serializer"
					+ ";\r\n";
		}
	}

	private String getClassFilePath(String packageName, String className) {
		return outDir + "\\" + packageName.replace(".", "\\") + "\\"
				+ className + ".java";
	}

	private String firstUpperString(String text) {
		return text.substring(0, 1).toUpperCase() + text.substring(1);
	}

	private String firstLowerString(String text) {
		return text.substring(0, 1).toLowerCase() + text.substring(1);
	}

	private String convertPrefName(XSDKey xsdKey) {
		String[] nStrs = xsdKey.getNs().split("/");
		String lString = nStrs[nStrs.length - 1];

		String[] texts = splitString(lString);
		if (texts.length == 1)
			return lString.toLowerCase().substring(0,
					Math.min(3, lString.length()))
					+ ":" + xsdKey.getKey();

		String result = "";

		for (String text : texts) {
			result += text.substring(0, 1).toLowerCase();
		}

		return result + ":" + xsdKey.getKey();
	}

	private String convertPrefNamePre(XSDKey xsdKey) {
		String[] nStrs = xsdKey.getNs().split("/");
		String lString = nStrs[nStrs.length - 1];

		String[] texts = splitString(lString);
		if (texts.length == 1)
			return lString.toLowerCase().substring(0,
					Math.min(3, lString.length()));

		String result = "";

		for (String text : texts) {
			result += text.substring(0, 1).toLowerCase();
		}

		return result;
	}

	private String[] splitString(String text) {
		char[] tChars = text.toCharArray();

		Set<String> texts = new LinkedHashSet<String>();

		boolean lastCharLower = true;
		int lastP = 0;
		for (int i = 0; i < tChars.length; i++) {
			char nChar = tChars[i];
			boolean currentCharLower = Character.isLowerCase(nChar);

			if (!lastCharLower && currentCharLower && i > 1) {
				texts.add(text.substring(lastP, i - 1));
				lastP = i - 1;
			}
		}

		texts.add(text.substring(lastP, tChars.length));

		return texts.toArray(new String[texts.size()]);
	}

	private String convertPackageName(String ns) {
		try {
			String packageName = "";

			URI uri = new URI(ns);
			String host = uri.getHost().toLowerCase().trim();
			String path = uri.getPath().toLowerCase().trim();

			if (host.startsWith("www."))
				host = host.substring(4);

			String[] hostStrs = host.split("\\.");

			for (int i = hostStrs.length - 1; i >= 0; i--) {
				packageName += "." + hostStrs[i];
			}

			String[] pathStrs = path.split("/");

			for (int i = 0; i < pathStrs.length; i++) {
				if (!pathStrs[i].isEmpty())
					packageName += "." + pathStrs[i];
			}

			return packageName.substring(1);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
}
