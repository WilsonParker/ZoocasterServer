package com.graction.lumi.model.data.address;

import javax.xml.bind.annotation.XmlAttribute;

public class Address {
	private String name;
	private SiList siList;

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SiList getSiList() {
		return siList;
	}

	public void setSiList(SiList siList) {
		this.siList = siList;
	}

	@Override
	public String toString() {
		return "{ Address : { name:" + name + ", siList:" + siList + " } }";
	}
	
}
