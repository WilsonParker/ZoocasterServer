package com.graction.lumi.model.vo;

public class RegionVO {
	private int region_index;			// Region primary index
	private String region_SIDO			// si/do
					, region_SI			// si
					, region_GUGUN		// gu/gun
					;
	
	public int getRegion_index() {
		return region_index;
	}
	public void setRegion_index(int region_index) {
		this.region_index = region_index;
	}
	public String getRegion_SIDO() {
		return region_SIDO;
	}
	public void setRegion_SIDO(String region_SIDO) {
		this.region_SIDO = region_SIDO;
	}
	public String getRegion_SI() {
		return region_SI;
	}
	public void setRegion_SI(String region_SI) {
		this.region_SI = region_SI;
	}
	public String getRegion_GUGUN() {
		return region_GUGUN;
	}
	public void setRegion_GUGUN(String region_GUGUN) {
		this.region_GUGUN = region_GUGUN;
	}
	@Override
	public String toString() {
		return "RegionVO [region_index=" + region_index + ", region_SIDO=" + region_SIDO + ", region_SI=" + region_SI
				+ ", region_GUGUN=" + region_GUGUN + "]";
	}
	
}
