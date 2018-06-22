package com.graction.lumi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;
import com.graction.lumi.dao.TestDAO;
import com.graction.lumi.data.DataStorage;
import com.graction.lumi.data.DataStorage.Mapping;
import com.graction.lumi.model.db.param.ParamTest;
import com.graction.lumi.model.openData.IntegratedAirQualityModel;
import com.graction.lumi.model.openWeather.DailyForecastModel;
import com.graction.lumi.model.openWeather.Forecast5DayModel;
import com.graction.lumi.model.request.LatLonRequestModel;
import com.graction.lumi.model.xml.address.Address;
import com.graction.lumi.model.xml.address.Gugun;
import com.graction.lumi.model.xml.address.GugunList;
import com.graction.lumi.model.xml.address.Si;
import com.graction.lumi.model.xml.weather.Weather;
import com.graction.lumi.net.Net;
import com.graction.lumi.util.db.DatabaseManager;
import com.graction.lumi.util.log.HLogger;
import com.graction.lumi.util.log.HLogger.LogType;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(Mapping.MAPPING_ROOT_TEST)
public class TestController {
	private static final HLogger logger = new HLogger(TestController.class);
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/dailyforecastTestTest", method = RequestMethod.GET)
	public String dailyforecastTest(HttpServletRequest request, HttpServletResponse response) {
		Geocoder geocoder = new Geocoder();
		System.out.println(request.getParameter("lat"));
		System.out.println(request.getParameter("lon"));
		LatLng latlng = new LatLng("37.566535", "126.97796919999996");
		// LatLng latlng = new LatLng("37.566535", "126.97796919999996");
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setLocation(latlng).setLanguage("ko")
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse;
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);
			geocoder.geocode(geocoderRequest);
			GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();

			System.out.println(geocoderResult.getFormattedAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "home";
	}

	@RequestMapping(value = "/weatherTest", method = RequestMethod.GET)
	public void weatherTest(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		for (Weather weather : DataStorage.weatherData.getWeathers().getWeather()) {
			sb.append(String.format("(\"%s\", %d, %d, %d),\n", weather.getMessage(), 0, 0, 0));
		}
		logger.log(LogType.INFO, sb.toString());
	}

	@RequestMapping(value = "/addressTest", method = RequestMethod.GET)
	public void addressTest(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		for (Address address : DataStorage.addressData.getAddresses().getAddress()) {
			for (Si si : address.getSiList().getSi()) {
				GugunList gugnList = si.getGugunList();
				if (gugnList == null) {
					sb.append(String.format("(\"%s\", \"%s\", \"%s\"),\n", address.getName(), si.getName(), ""));
				} else {
					for (Gugun gugun : si.getGugunList().getGugun()) {
						sb.append(String.format("(\"%s\", \"%s\", \"%s\"),\n", address.getName(), si.getName(),
								gugun.getName()));
					}
				}
			}
		}
		logger.log(LogType.INFO, sb.toString());
	}

	@RequestMapping(value = "/insertTest", method = RequestMethod.GET)
	public void insertTest(HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogType.INFO, "insertTest");
		TestDAO dao = sqlSession.getMapper(TestDAO.class);
		dao.insert_test(new ParamTest("testEvent","testEvent success"));
	}
	
	@RequestMapping(value = "/eventCreateTest", method = RequestMethod.GET)
	public void eventCreateTest(HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogType.INFO, "eventCreateTest");
		String name = "eventTestName2";
		new DatabaseManager(jdbcTemplate).insertQuery("DROP EVENT IF EXISTS "+name+"; CREATE EVENT "+name+" ON SCHEDULE AT current_timestamp() + INTERVAL 5 SECOND DO INSERT INTO testEvent	VALUES	(default, current_timestamp(), 'event');");
	}
	
	@RequestMapping(value = "/dailyForecastTest", method = RequestMethod.GET)
	public void dailyForecastTest(HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogType.INFO, "dailyForecastTest");
		Net.getInstance().getOpenWeatherFactoryIm().selectDailyForcast(new LatLonRequestModel("37.566535", "126.97796919999996", LatLonRequestModel.KEY_OPEN_WEATHER).getMap()).enqueue(new Callback<DailyForecastModel>() {
			
			@Override
			public void onResponse(Call<DailyForecastModel> call, Response<DailyForecastModel> response) {
				if(response.isSuccessful()) {
					logger.log(LogType.INFO, "dailyForecastTest(HttpServletRequest request, HttpServletResponse response)", "response body : "+response.body());
				}
			}
			
			@Override
			public void onFailure(Call<DailyForecastModel> call, Throwable t) {
				logger.log(LogType.ERROR, "void onFailure(Call<DailyForecastModel> call, Throwable t)", t);
			}
		});
	}
	
	@RequestMapping(value = "/forecast5DayTest", method = RequestMethod.GET)
	public void forecast5DayTest(HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogType.INFO, "forecast5DayTest");
		Net.getInstance().getOpenWeatherFactoryIm().select5DayForecast(new LatLonRequestModel("37.566535", "126.97796919999996", LatLonRequestModel.KEY_OPEN_WEATHER).getMap()).enqueue(new Callback<Forecast5DayModel>() {
			
			@Override
			public void onResponse(Call<Forecast5DayModel> call, Response<Forecast5DayModel> response) {
				if(response.isSuccessful()) {
					logger.log(LogType.INFO, "forecast5DayTest(HttpServletRequest request, HttpServletResponse response)", "response body : "+response.body());
				}
			}
			
			@Override
			public void onFailure(Call<Forecast5DayModel> call, Throwable t) {
				logger.log(LogType.ERROR, "void onFailure(Call<forecast5DayTest> call, Throwable t)", t);
			}
		});
	}
	
	@RequestMapping(value = "/integratedAirQualityTest", method = RequestMethod.GET)
	public void integratedAirQualityTest(HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogType.INFO, "integratedAirQualityTest");
		try {
			Net.getInstance().getOpenDataRetrofit().selectIntegratedAirQuality(new LatLonRequestModel("종로구").getMap()).enqueue(new Callback<IntegratedAirQualityModel>() {
				
				@Override
				public void onResponse(Call<IntegratedAirQualityModel> call, Response<IntegratedAirQualityModel> response) {
					if(response.isSuccessful()) {
						logger.log(LogType.INFO, "integratedAirQualityTest(HttpServletRequest request, HttpServletResponse response)", "success response body : "+response.body());
					}
					logger.log(LogType.INFO, "integratedAirQualityTest(HttpServletRequest request, HttpServletResponse response)", "response body : "+response.body());
				}
				
				@Override
				public void onFailure(Call<IntegratedAirQualityModel> call, Throwable t) {
					logger.log(LogType.ERROR, "integratedAirQualityTest(HttpServletRequest request, HttpServletResponse response)","onFailure", t);
				}
			});
		} catch (Exception e) {
			logger.log(LogType.ERROR, "integratedAirQualityTest(HttpServletRequest request, HttpServletResponse response)","onFailure", e);
		}
	}
}
