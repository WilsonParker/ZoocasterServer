package com.graction.lumi.model.xml.address;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.graction.lumi.util.StringUtil;

@XmlRootElement
public class Addresses {
	private Collection<Address> address;

	@XmlElement
	public Collection<Address> getAddress() {
		if(address == null)
			address = new ArrayList<Address>();
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return StringUtil.createString(Addresses.class.getSimpleName(), Address.class.getSimpleName(), address);
	}
}
