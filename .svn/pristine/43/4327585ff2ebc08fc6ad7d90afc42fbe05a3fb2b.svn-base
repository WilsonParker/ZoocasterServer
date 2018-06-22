package com.graction.lumi.model.xml.address;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.graction.lumi.util.StringUtil;

@XmlRootElement
public class SiList {
	private Collection<Si> si = new ArrayList<Si>();

	@XmlElement
	public Collection<Si> getSi() {
		if(si == null)
			si = new ArrayList<Si>();
		return si;
	}

	public void setSi(Collection<Si> si) {
		this.si = si;
	}

	@Override
	public String toString() {
		return StringUtil.createString(SiList.class.getSimpleName(), Si.class.getSimpleName(), si);
	}
}
