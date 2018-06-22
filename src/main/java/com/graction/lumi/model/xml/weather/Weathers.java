package com.graction.lumi.model.xml.weather;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weathers {
	private Collection<Weather> weather = new ArrayList<Weather>();

	@XmlElement
	public Collection<Weather> getWeather() {
		return weather;
	}

	public void setWeather(Collection<Weather> weather) {
		this.weather = weather;
	}

	
}

