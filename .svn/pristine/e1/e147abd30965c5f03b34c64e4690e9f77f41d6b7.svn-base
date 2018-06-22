package com.graction.lumi.net;

import java.util.Map;

import com.graction.lumi.model.openWeather.DailyForecastModel;
import com.graction.lumi.model.openWeather.Forecast5DayModel;
import com.graction.lumi.model.openWeather.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface OpenWeatherFactoryIm {

	// 5 day / 3 hour weather forecast
	@GET("/data/2.5/forecast/")
	Call<Forecast5DayModel> select5DayForecast(@QueryMap Map<String, String> map);
	
	// 16 day weather forecast
	@GET("/data/2.5/forecast/daily")
	Call<DailyForecastModel> selectDailyForcast(@QueryMap Map<String, String> map);
	
	// Current weather
	@GET("/data/2.5/weather")
	Call<WeatherModel> selectWeather(@QueryMap Map<String, String> map);
}
