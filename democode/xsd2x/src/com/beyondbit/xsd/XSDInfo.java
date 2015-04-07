package com.beyondbit.xsd;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class XSDInfo {
	private Map<XSDKey, XSDType> typeMap = new HashMap<XSDKey, XSDType>();
	private Map<XSDKey, Set<XSDType>> typeParentMap = new HashMap<XSDKey, Set<XSDType>>();

	private Map<XSDKey, XSDKey> rootElementMap = new HashMap<XSDKey, XSDKey>();

	public Map<XSDKey, XSDType> getTypeMap() {
		return typeMap;
	}

	public Map<XSDKey, XSDKey> getRootElementMap() {
		return rootElementMap;
	}

	public Map<XSDKey, Set<XSDType>> getTypeParentMap() {
		return typeParentMap;
	}

	public void addXSDType(XSDType xsdType) {
		typeMap.put(xsdType.getName(), xsdType);

		if (xsdType.getBaseName() != null) {
			Set<XSDType> types = typeParentMap.get(xsdType.getBaseName());

			if (types == null) {
				types = new LinkedHashSet<XSDType>();
				typeParentMap.put(xsdType.getBaseName(), types);
			}

			types.add(xsdType);
		}
	}

	public void addRootElement(XSDKey xsdTypKey, XSDKey xsdElementName) {
		rootElementMap.put(xsdTypKey, xsdElementName);
	}
}
