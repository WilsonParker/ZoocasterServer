package com.graction.lumi.model.skPlanet;

class Grid {
	private double latitude, longitude;
	private String cit, country, village;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCit() {
		return cit;
	}

	public void setCit(String cit) {
		this.cit = cit;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	@Override
	public String toString() {
		return "Grid [latitude=" + latitude + ", longitude=" + longitude + ", cit=" + cit + ", country=" + country
				+ ", village=" + village + "]";
	}

}
