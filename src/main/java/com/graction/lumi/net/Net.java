package com.graction.lumi.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net {
	private static final Net instance = new Net();
	private static final String OPEN_WEATHER_URL = "http://api.openweathermap.org"
								, SK_PLANET_URL = "http://apis.skplanetx.com/"
								, OPEN_DATA_URL = "http://openapi.airkorea.or.kr/"
								;
	private OpenWeatherFactoryIm openWeatherFactoryIm;
	private SKPlanetFactoryIm skPlanetFactoryIm;
	private OpenDataFactoryIm openDataFactoryIm;
	private Retrofit openWeatherRetrofit, skPlanetRetrofit, openDataRetrofit;
	
	{
		openWeatherRetrofit = new Retrofit.Builder()
				.baseUrl(OPEN_WEATHER_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		skPlanetRetrofit = new Retrofit.Builder()
				.baseUrl(SK_PLANET_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		openDataRetrofit = new Retrofit.Builder()
				.baseUrl(OPEN_DATA_URL)
//				.client(createClient())
//				.addConverterFactory(LenientGsonConverterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	private OkHttpClient createClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new CustomIntercepter());
        return okHttpClientBuilder.build();
}
	
	public static Net getInstance() {
		return instance;
	}

	public OpenWeatherFactoryIm getOpenWeatherFactoryIm() {
		if (openWeatherFactoryIm == null)
			openWeatherFactoryIm = openWeatherRetrofit.create(OpenWeatherFactoryIm.class);
		return openWeatherFactoryIm;
	}
	
	public SKPlanetFactoryIm getSKPlanetFactoryIm() {
		if (skPlanetFactoryIm == null)
			skPlanetFactoryIm = skPlanetRetrofit.create(SKPlanetFactoryIm.class);
		return skPlanetFactoryIm;
	}

	public OpenDataFactoryIm getOpenDataRetrofit() {
		if (openDataFactoryIm == null)
			openDataFactoryIm = openDataRetrofit.create(OpenDataFactoryIm.class);
		return openDataFactoryIm;
	}
	
}
