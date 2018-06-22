package com.graction.lumi.model.data.address;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.graction.lumi.util.StringUtil;

@XmlRootElement
public class GugunList {
	private Collection<Gugun> gugun;

	@XmlElement
	public Collection<Gugun> getGugun() {
		if(gugun == null)
			gugun = new ArrayList<Gugun>();
		return gugun;
	}

	public void setSigugun(Collection<Gugun> gugun) {
		this.gugun = gugun;
	}

	@Override
	public String toString() {
		return StringUtil.createString(GugunList.class.getSimpleName(), Gugun.class.getSimpleName(), gugun);
	}

	
}
