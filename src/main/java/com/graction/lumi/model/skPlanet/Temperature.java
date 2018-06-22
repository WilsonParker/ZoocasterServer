package com.graction.lumi.model.skPlanet;

class Temperature {
	private double tc, tmax, tmin;

	public double getTc() {
		return tc;
	}

	public void setTc(double tc) {
		this.tc = tc;
	}

	public double getTmax() {
		return tmax;
	}

	public void setTmax(double tmax) {
		this.tmax = tmax;
	}

	public double getTmin() {
		return tmin;
	}

	public void setTmin(double tmin) {
		this.tmin = tmin;
	}

	@Override
	public String toString() {
		return "Temperature [tc=" + tc + ", tmax=" + tmax + ", tmin=" + tmin + "]";
	}

}
