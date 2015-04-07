package com.beyondbit.xsd;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.beyondbit.util.UtilFileInsert;

public class XSDCreate {
	private String packageName;

	private String outDir;

	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	public void GenerateJavaFile(XSDInfo xsdInfo) {
		// 清除文件夹
		// for (XSDType xsdType : xsdInfo.getTypeMap().values()) {
		// String dirPath = createFileDir(xsdType.getName().getNs());
		// UtilFileInsert.deleteDirectory(dirPath);
		// }
		// 开始加文件
		for (XSDType xsdType : xsdInfo.getTypeMap().values()) {
			File file = createFile(xsdType);
			if (file.exists()) {
				UtilFileInsert.addStringInFile(file, getPackageName());
				// 如果是枚举 就造 造完结束
				if (xsdType.getEnumStrings().size() > 0) {
					// public enum CategoryType {
					// s,a;
					// }
					UtilFileInsert.addStringInFile(file, "public " + " enum " + xsdType.getName().getKey() + "{\r\n");
					StringBuffer sb = new StringBuffer();
					for (String enumString : xsdType.getEnumStrings()) {
						// enum string : Global
						sb.append(enumString + ",");

					}
					UtilFileInsert.addStringInFile(file, sb.substring(0, sb.length() - 1) + ";}");
					continue;
				}

				UtilFileInsert.addStringInFile(file, "public " + (xsdType.isAbstract() ? "abstract" : "") + " class " + xsdType.getName().getKey());

			}
			if (xsdType.getBaseName() != null) {
				UtilFileInsert.addStringInFile(file, "extends " + xsdType.getBaseName().getKey());
				// 如果继承的那个类 不和自己在同一个包里 就要导包
				if (!xsdType.getBaseName().getNs().equals(xsdType.getName().getNs()))
					UtilFileInsert.insertStringInFile(file, 2, getImportName(xsdType.getBaseName().getNs(), null, "import ", "." + xsdType.getBaseName().getKey()));

			}
			UtilFileInsert.addStringInFile(file, " implements Serializable{\r\n");
			UtilFileInsert.insertStringInFile(file, 2, "import java.io.Serializable;");
			// return;
			if (xsdType.isAbstract()) {
				UtilFileInsert.addStringInFile(file, "\r\n}");
				continue;
			}

			for (XSDElement xsdElement : xsdType.getElements().values()) {
				String typeNs = xsdElement.getTypeName().getNs();
				String type = xsdElement.getTypeName().getKey();
				// 如果是string 等基本类型就不用导包
				if (!typeNs.contains("http://www.w3.org/2001/XMLSchema"))
					UtilFileInsert.insertStringInFile(file, 2, getImportName(typeNs, null, "import ", "." + type));

				// 如果是date并且没有导过包 java需要导date包 可能与自定义的Calendar冲突 所以就变全名
				if ("dateTime".equals(type) && "http://www.w3.org/2001/XMLSchema".contains(typeNs)) {
					// UtilFileInsert.insertStringInFile(file, 2,
					// "import java.util.Calendar;");
					type = "java.util.Calendar";
				}

				String name = xsdElement.getName().getKey();
				String min = xsdElement.getMinOccurs();
				String max = xsdElement.getMaxOccurs();
				String defValue = xsdElement.getDefaultValue();

				UtilFileInsert.addStringInFile(file, createElement(type, name, min, max, defValue));

			}

			UtilFileInsert.addStringInFile(file, "\r\n}");
		}
	}

	private String createElement(String type, String name, String min, String max, String defValue) {
		StringBuffer sb = new StringBuffer();
		type = parseType(type);

		sb.append(createElementdeclare(type, max, toCaseName(name, false), defValue));
		sb.append(createElementSet(type, name, min, max));
		sb.append(createElementGet(type, name, max));

		return sb.toString();
	}

	/**
	 * 
	 * @param name
	 * @param isUpper
	 *            true 为首字母大写 false 小写
	 * @return
	 */
	private String toCaseName(String name, boolean isUpper) {
		String a3 = name.substring(0, 1);
		if (isUpper)
			return a3.toUpperCase() + name.substring(1); // 变量名首字母变大写
		else
			return a3.toLowerCase() + name.substring(1); // 变量名首字母变小写
	}

	private String createElementdeclare(String type, String max, String toLowerCaseName, String defValue) {
		StringBuffer sb = new StringBuffer();
		if ("String".equals(type) && defValue != null) {
			defValue = "\"" + defValue + "\"";
		}
		sb.append("private " + type + ("unbounded".equals(max) ? "[]" : "") + " " + toLowerCaseName + (defValue == null ? "" : "=" + defValue) + ";\r\n");
		return sb.toString();
	}

	private String createElementSet(String type, String name, String min, String max) {
		StringBuffer sb = new StringBuffer();
		String toUpperCaseName = toCaseName(name, true);
		String toLowerCaseName = toCaseName(name, false);
//		boolean hasBooleanField = false;

//		if ("1".equals(max) && "0".equals(min) && !type.contains("String")) {
		if (!"-1".equals(max) ) {
			sb.append(createElementdeclare("boolean", "1", "has" + toUpperCaseName, "false"));
//			hasBooleanField = true;
			sb.append(createElementGet("boolean", "has" + toUpperCaseName, "-1"));
			sb.append(createElementSet("boolean", "has" + toUpperCaseName, min, "-1"));
		}
		// public void setUserid(String userid) {
		// this.hasUserId=true;
		// this.userid = userid;
		// }
		//
		sb.append("public void set" + toUpperCaseName + "(" + type + ("unbounded".equals(max) ? "[]" : "") + " " + toLowerCaseName + "){\r\n");
//		if (hasBooleanField) {
		if (!"-1".equals(max) ) {
			sb.append("this." + "has" + toUpperCaseName + "=" + "true" + ";\r\n");
		}
		sb.append("this." + toLowerCaseName + "=" + toLowerCaseName + ";\r\n");
		sb.append("}\r\n");
		return sb.toString();
	}

	private String createElementGet(String type, String name, String max) {
		//
		// public String getUserid() {
		// return userid;
		// }
		//
		StringBuffer sb = new StringBuffer();
		String toUpperCaseName = toCaseName(name, true);
		String toLowerCaseName = toCaseName(name, false);
		if ("boolean".equals(type)) {
			sb.append("public " + type + ("unbounded".equals(max) ? "[]" : "") + " get" + toUpperCaseName + "(){\r\n");
		} else {
			sb.append("public " + type + ("unbounded".equals(max) ? "[]" : "") + " get" + toUpperCaseName + "(){\r\n");
		}
		sb.append("return " + toLowerCaseName + ";\r\n}\r\n");
		return sb.toString();
	}

	private String parseType(String type) {
		if ("string".equals(type) ) {
			return "String";
		} else if ("dateTime".equals(type)) {
			return "Calendar";
		} else if ("date".equalsIgnoreCase(type)) {
			return "Calendar";
		}else if ("base64Binary".equals(type)) {
			return "byte[]";
		}

		return type;
	}

	// 创建文件

	private File createFile(XSDType xsdType) {
		String dirPath = createFileDir(xsdType.getName().getNs());
		File picFileDir = new File(dirPath);// 仅创建路径的File对象
		if (!picFileDir.exists()) {
			picFileDir.mkdirs();// 如果路径不存在就先创建路径
		}
		// else {
		// picFileDir.delete();
		// picFileDir.mkdirs();
		// }
		File f = new File(picFileDir, xsdType.getName().getKey() + ".java");// 然后再创建路径和文件的File对象
		try {
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			} else {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	// 创建文件目录
	public String createFileDir(String ns) {
		StringBuffer sb = new StringBuffer();
		// StringBuffer packageNameTemp = new StringBuffer();
		// packageNameTemp.append();
		// File f = new File(".");
		// String absolutePath = f.getAbsolutePath();
		sb.append(outDir + "\\");

		// sb.append("./src/");
		// String ns = "http://www.beyondbit.com/smartbox/request";
		packageName = getImportName(ns, sb, "package ", "");
		// packageName=packageNameTemp.substring(0,
		// packageNameTemp.length()-1)+";\r\n";
		System.out.println(sb.toString() + "------createFileDir");
		return sb.substring(0, sb.length() - 1);
	}

	private String getPackageName() {
		return packageName.toLowerCase();
	}

	private String getImportName(String ns, StringBuffer sb, String prefix, String typeName) {
		String name;
		StringBuffer importName = new StringBuffer();
		importName.append(prefix);
		int index = ns.indexOf("http://");
		String s2 = ns.substring(index + 7, ns.length());
		String[] strs = s2.split("/");
		int len = strs.length;
		if (len > 0) {
			String[] strs2 = strs[0].split("\\.");
			if (strs2.length > 0) {
				for (int i = strs2.length; i > 0; i--) {
					if (!"www".equals(strs2[i - 1])) {
						if (sb != null)
							sb.append(strs2[i - 1].toLowerCase() + "\\");
						importName.append(strs2[i - 1] + ".");
					}
				}
			}
			for (int i = 1; i < strs.length; i++) {
				if (sb != null)
					sb.append(strs[i].toLowerCase() + "\\");
				importName.append(strs[i] + ".");
			}
		}
		name = importName.substring(0, importName.length() - 1).toLowerCase() + typeName + ";\r\n";
		return name;
	}
}