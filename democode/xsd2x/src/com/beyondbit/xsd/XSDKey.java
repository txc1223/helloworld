package com.beyondbit.xsd;

public class XSDKey {
	public static final XSDKey COMPLEX_TYPE = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "complexType");
	public static final XSDKey SIMPLE_TYPE = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "simpleType");
	public static final XSDKey SEQUENCE = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "sequence");
	public static final XSDKey ALL = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "all");
	public static final XSDKey ELEMENT = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "element");
	public static final XSDKey COMPLEX_CONTENT = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "complexContent");
	public static final XSDKey EXTENSION = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "extension");
	public static final XSDKey RESTRICTION = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "restriction");
	public static final XSDKey ENUMERATION = new XSDKey(
			"http://www.w3.org/2001/XMLSchema", "enumeration");

	private String ns;
	private String key;

	public String getNs() {
		return ns;
	}

	public String getKey() {
		return key;
	}

	public XSDKey(String ns, String key) {
		this.ns = ns;
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj.getClass() != XSDKey.class)
			return false;

		XSDKey xsdKey = (XSDKey) obj;

		return xsdKey.key.equalsIgnoreCase(key)
				&& xsdKey.ns.equalsIgnoreCase(ns);
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return escape(ns) + ":" + key;
	}

	private String escape(String text) {
		return text.replace("/", "//").replace(":", "/");
	}
}
