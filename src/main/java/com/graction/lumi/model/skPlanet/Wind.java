package com.graction.lumi.model.skPlanet;

class Wind {

	private double wdir, wspd;

	public double getWdir() {
		return wdir;
	}

	public void setWdir(double wdir) {
		this.wdir = wdir;
	}

	public double getWspd() {
		return wspd;
	}

	public void setWspd(double wspd) {
		this.wspd = wspd;
	}

	@Override
	public String toString() {
		return "Wind [wdir=" + wdir + ", wspd=" + wspd + "]";
	}

}
