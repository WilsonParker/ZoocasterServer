package com.graction.lumi.model.openWeather;

public class Wind {
	private double speed	// Wind speed, Unit Default: meter/sec, Metricr: meer/sec, Imperial: miles/hour
					, deg;	// Wind direction, degrees (meteorological)	

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}

}
