package com.graction.lumi.model.skPlanet;

class Sky {
	/*
	code
	하늘상태코드명
	- SKY_O01: 맑음
	- SKY_O02: 구름조금
	- SKY_O03: 구름많음
	- SKY_O04: 구름많고 비
	- SKY_O05: 구름많고 눈
	- SKY_O06: 구름많고 비 또는 눈
	- SKY_O07: 흐림
	- SKY_O08: 흐리고 비
	- SKY_O09: 흐리고 눈
	- SKY_O10: 흐리고 비 또는 눈
	- SKY_O11: 흐리고 낙뢰
	- SKY_O12: 뇌우, 비
	- SKY_O13: 뇌우, 눈
	- SKY_O14: 뇌우, 비 또는 눈*/
	private String code, name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sky [code=" + code + ", name=" + name + "]";
	}

}
