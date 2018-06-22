package com.graction.lumi.model.skPlanet;

import java.util.Arrays;

// SK Planet 
public class FineDustModel {
	private Weather weather;
	private Common common;
	private Result result;
	
	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
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
		return "FineDustModel [weather=" + weather + ", common=" + common + ", result=" + result + "]";
	}

	public class Weather {
		private Dust[] dust;
		
		public Dust[] getDust() {
			return dust;
		}
		public void setDust(Dust[] dust) {
			this.dust = dust;
		}
		public Common getCommon() {
			return common;
		}
		
		@Override
		public String toString() {
			return "Weather [dust=" + Arrays.toString(dust) + "]";
		}

		public class Dust{
			private Station station;
			private String timeObservation;
			private Pm10 pm10;
			
			public Station getStation() {
				return station;
			}
			public void setStation(Station station) {
				this.station = station;
			}
			public String getTimeObservation() {
				return timeObservation;
			}
			public void setTimeObservation(String timeObservation) {
				this.timeObservation = timeObservation;
			}
			public Pm10 getPm10() {
				return pm10;
			}
			public void setPm10(Pm10 pm10) {
				this.pm10 = pm10;
			}
			
			@Override
			public String toString() {
				return "Dust [station=" + station + ", timeObservation=" + timeObservation + ", pm10=" + pm10 + "]";
			}

			public class Station{
				private String latitude, longitude, name;
				private int id;
				
				public String getLatitude() {
					return latitude;
				}
				public void setLatitude(String latitube) {
					this.latitude = latitube;
				}
				public String getlongitude() {
					return longitude;
				}
				public void setlongitude(String longitude) {
					this.longitude = longitude;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
				}
				@Override
				public String toString() {
					return "Station [latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + ", id="
							+ id + "]";
				}
			}
			public class Pm10{
				private String grade	// 등급 - 좋음, 보통, 약간나쁨, 나쁨, 매우나쁨
							, value		// 농도(㎍/㎥) - 0~30: 좋음, 31~80: 보통, 81~120: 약간나쁨, 121~200: 나쁨, 201~300: 매우나쁨	
							;
				public String getGrade() {
					return grade;
				}
				public void setGrade(String grade) {
					this.grade = grade;
				}
				public String getValue() {
					return value;
				}
				public void setValue(String value) {
					this.value = value;
				}
				@Override
				public String toString() {
					return "Pm10 [grade=" + grade + ", value=" + value + "]";
				}
			}
		}
	}
	public class Common{
		private String alertYn, stormYn;

		public String getAlertYn() {
			return alertYn;
		}

		public void setAlertYn(String alertYn) {
			this.alertYn = alertYn;
		}

		public String getStormYn() {
			return stormYn;
		}

		public void setStormYn(String stormYn) {
			this.stormYn = stormYn;
		}

		@Override
		public String toString() {
			return "Common [alertYn=" + alertYn + ", stormYn=" + stormYn + "]";
		}
	}
	public class Result{
		private int code;
		private String requestUrl, message;
		
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getRequestUrl() {
			return requestUrl;
		}
		public void setRequestUrl(String requestUrl) {
			this.requestUrl = requestUrl;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		@Override
		public String toString() {
			return "Result [code=" + code + ", requestUrl=" + requestUrl + ", message=" + message + "]";
		}
	}
}
