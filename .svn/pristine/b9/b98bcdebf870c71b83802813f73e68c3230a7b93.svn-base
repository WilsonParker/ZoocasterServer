package com.graction.lumi.model.skPlanet;

import java.util.List;

// SK Planet
public class WeatherHourlyModel {
	private WeatherHourlyItem weather;

	public WeatherHourlyItem getWeather() {
		return weather;
	}

	public void setWeather(WeatherHourlyItem weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "WeatherHourlyModel [weather=" + weather + "]";
	}

	public class WeatherHourlyItem {
		private List<HourlyItem> hourly;
		private Common common;
		private Result result;

		public List<HourlyItem> getHourly() {
			return hourly;
		}

		public void setHourly(List<HourlyItem> hourly) {
			this.hourly = hourly;
		}

		public Common getCommon() {
			return common;
		}

		public void setCommon(Common common) {
			this.common = common;
		}

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return "WeatherHourlyItem [hourly=" + hourly + ", common=" + common + ", result=" + result + "]";
		}

		public class HourlyItem {
			private Grid grid;
			private Wind wind;
			private Precipitation precipitation;
			private Sky sky;
			private Temperature temperature;
			private double humidity, lightning;
			private String timeRelease;

			public Grid getGrid() {
				return grid;
			}

			public void setGrid(Grid grid) {
				this.grid = grid;
			}

			public Wind getWind() {
				return wind;
			}

			public void setWind(Wind wind) {
				this.wind = wind;
			}

			public Precipitation getPrecipitation() {
				return precipitation;
			}

			public void setPrecipitation(Precipitation precipitation) {
				this.precipitation = precipitation;
			}

			public Sky getSky() {
				return sky;
			}

			public void setSky(Sky sky) {
				this.sky = sky;
			}

			public Temperature getTemperature() {
				return temperature;
			}

			public void setTemperature(Temperature temperature) {
				this.temperature = temperature;
			}

			public double getHumidity() {
				return humidity;
			}

			public void setHumidity(double humidity) {
				this.humidity = humidity;
			}

			public double getLightning() {
				return lightning;
			}

			public void setLightning(double lightning) {
				this.lightning = lightning;
			}

			public String getTimeRelease() {
				return timeRelease;
			}

			public void setTimeRelease(String timeRelease) {
				this.timeRelease = timeRelease;
			}

			@Override
			public String toString() {
				return "HourlyItem [grid=" + grid + ", wind=" + wind + ", precipitation=" + precipitation + ", sky="
						+ sky + ", temperature=" + temperature + ", humidity=" + humidity + ", lightning=" + lightning
						+ ", timeRelease=" + timeRelease + "]";
			}

		}
	}
}
