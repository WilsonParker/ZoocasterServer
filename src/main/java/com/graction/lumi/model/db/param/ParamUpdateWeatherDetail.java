package com.graction.lumi.model.db.param;

// used in procedure updateWeatherDetail
public class ParamUpdateWeatherDetail {
	private int code;
	private String idx, names;

	public ParamUpdateWeatherDetail(int code, String idx, String names) {
		super();
		this.code = code;
		this.idx = idx;
		this.names = names;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "ParamUpdateWeatherDetail [code=" + code + ", idx=" + idx + ", names=" + names + "]";
	}
	
}
