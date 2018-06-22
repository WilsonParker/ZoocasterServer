package com.graction.lumi.util.func;

import java.util.ArrayList;
import java.util.List;

public class DiscriminateManager <T extends Object>{
//	private static final DiscriminateManager instance = new DiscriminateManager();
	private List<DiscrimInterface> discrimList = new ArrayList<DiscrimInterface>();
	
	public void addDiscrimin(DiscrimInterface discrimInterface) {
		discrimList.add(discrimInterface);
	}
	
	public T getResult() {
		T t = null;
		for(DiscrimInterface discrim : discrimList) {
			t = discrim.discriminate();
			if(t != null)
				break;
		}
		return t;
	}
	
	public interface DiscrimInterface{
		public <T extends Object> T discriminate();
	}
	
}
