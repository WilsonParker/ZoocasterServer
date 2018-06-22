package com.graction.lumi.util.gps;

public class AddressManager {
	private static final AddressManager instance = new AddressManager();
	private static final String REG = "(^([가-힇])*( |)((([가-힣]+(도))( |)[가-힣]+(시|군|구)( |)[가-힣]+(구))|(([가-힣]+(시))( |)[가-힣]+(시|군|구)))+(( |)([가-힣\\d\\(\\)_-]))*)"
//						"(^([가-힇])*( |)((([가-힣]+(도))( |)[가-힣]+(시|군|구)( |)[가-힣]+(구))|(([가-힣]+(시))( |)[가-힣]+(시|군|구)))+(( |)([가-힇1-9_-]))*)"
						, REG_DO = "([가-힇]+(도)$)"
						, REG_SI = "([가-힇]+(시)$)"
						, REG_SIGUGUN= "([가-힇]+(시|구|군)$)"
						// , REG_GU= "([가-힇]+(구)$)"
						;
	public static AddressManager getInstance() {
		return instance;
	}

	public boolean isAddress(String address) {
		return address.matches(REG);
	}
	
	public String[] extractAddress(String address) {
		String[] ea = new String[3];
		for(String s : address.split(" ")) {
			if(s.matches(REG_DO))
				ea[0] = s;
			else if(s.matches(REG_SI))
				ea[1] = s;
			else if(s.matches(REG_SIGUGUN))
				ea[2] = s;
		}
		return ea;
	}
}
