package com.graction.lumi.net;

import java.util.Map;

import com.graction.lumi.model.skPlanet.FineDustModel;
import com.graction.lumi.model.skPlanet.WeatherHourlyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SKPlanetFactoryIm {

	
	// Current Weather hourly
	// not complete
	@GET("/weather/current/hourly")
	Call<WeatherHourlyModel> selectCurrentWeather(@QueryMap Map<String, String> map);
	
	// 3days every 3hours
	// not complete
	@GET("weather/forecast/3days")
	Call<FineDustModel> select3DaysWeather(@QueryMap Map<String, String> map);
		
	// Fine dust
	@GET("/weather/dust")
	Call<FineDustModel> selectFineDust(@QueryMap Map<String, String> map);
	
}
