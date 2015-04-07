package com.beyondbit.xsd;

public class XSDElement {
	private XSDKey name;
	private XSDKey  typeName;
	private String defaultValue;
	private String minOccurs = "1";
	private String maxOccurs = "1";
	
	public XSDKey getName() {
		return name;
	}

	public void setName(XSDKey name) {
		this.name = name;
	}

	public XSDKey getTypeName() {
		return typeName;
	}

	public void setTypeName(XSDKey typeName) {
		this.typeName = typeName;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getMinOccurs() {
		return minOccurs;
	}

	public void setMinOccurs(String minOccurs) {
		this.minOccurs = minOccurs;
	}

	public String getMaxOccurs() {
		return maxOccurs;
	}

	public void setMaxOccurs(String maxOccurs) {
		this.maxOccurs = maxOccurs;
	}

}
