package com.graction.lumi.model;

import com.graction.lumi.util.gps.AddressManager;

public class AddressModel {

	private String address	// Address obtained with lat & lng
	, address_do
	, address_si
	, address_gu
	;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		String[] ea = AddressManager.getInstance().extractAddress(address);
		address_do = ea[0];
		address_si = ea[1];
		address_gu = ea[2];
	}

	public String getAddress_do() {
		return address_do;
	}

	public void setAddress_do(String address_do) {
		this.address_do = address_do;
	}

	public String getAddress_si() {
		return address_si;
	}

	public void setAddress_si(String address_si) {
		this.address_si = address_si;
	}

	public String getAddress_gu() {
		return address_gu;
	}

	public void setAddress_gu(String address_gu) {
		this.address_gu = address_gu;
	}

	@Override
	public String toString() {
		return "AddressModel [address=" + address + ", address_do=" + address_do + ", address_si=" + address_si
				+ ", address_gu=" + address_gu + "]";
	}
	
}
