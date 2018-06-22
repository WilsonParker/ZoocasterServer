package com.graction.lumi.model.skPlanet;

class Precipitation {
	private double type				/* 강수형태코드
									- 0: 현상없음 
									- 1: 비
									- 2: 비/눈
									- 3: 눈*/
	
					, sinceOntime;	/* 1시간 누적 강수량
									- if type=0/1/2 → 강우량 (mm)
									- if type=3     → 적설량 (cm)*/	
	

	public double getSinceOntime() {
		return sinceOntime;
	}

	public void setSinceOntime(double sinceOntime) {
		this.sinceOntime = sinceOntime;
	}

	public double getType() {
		return type;
	}

	public void setType(double type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Precipitation [sinceOntime=" + sinceOntime + ", type=" + type + "]";
	}

}
