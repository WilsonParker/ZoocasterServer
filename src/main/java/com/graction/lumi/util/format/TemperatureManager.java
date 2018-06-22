package com.graction.lumi.util.format;

/*
 * Temperature 관련 Class
 */
public class TemperatureManager {
	private static final TemperatureManager instance = new TemperatureManager();
	private static final double K = 273.15;

	public static TemperatureManager getInstance() {
		return instance;
	}

	public double kelvinToCelsius(double kelvin) {
		return NumberFormatManager.getInstatnce().round(kelvin - K, 3);
	}
}
