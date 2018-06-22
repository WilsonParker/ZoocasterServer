package com.graction.lumi.model.xml.address;

import javax.xml.bind.annotation.XmlAttribute;

public class Gugun {
	private String name;

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{ Sigugun : { name : " + name + " } }";
	}
}
