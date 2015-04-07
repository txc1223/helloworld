package com.beyondbit.xsd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.Sequence;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class XSDType {
	private XSDKey name;
	private XSDKey baseName;

	private boolean isComplex = false;
	private boolean isAbstract = false;
	private ElementSetMode elementSetMode = ElementSetMode.UnKnown;
	private Map<XSDKey, XSDElement> elements = new LinkedHashMap<XSDKey, XSDElement>();
	private Set<String> enumStrings = new LinkedHashSet<String>();

	public XSDKey getName() {
		return name;
	}

	public void setName(XSDKey name) {
		this.name = name;
	}

	public XSDKey getBaseName() {
		return baseName;
	}

	public void setBaseName(XSDKey baseName) {
		this.baseName = baseName;
	}

	public boolean isComplex() {
		return isComplex;
	}

	public void setComplex(boolean isComplex) {
		this.isComplex = isComplex;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public ElementSetMode getElementSetMode() {
		return elementSetMode;
	}

	public void setElementSetMode(ElementSetMode elementSetMode) {
		this.elementSetMode = elementSetMode;
	}

	public Map<XSDKey, XSDElement> getElements() {
		return elements;
	}

	public Set<String> getEnumStrings() {
		return enumStrings;
	}

	public enum ElementSetMode {
		UnKnown, All, Sequence, Enum
	}
}
