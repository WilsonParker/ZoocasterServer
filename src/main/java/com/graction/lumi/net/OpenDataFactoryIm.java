package com.graction.lumi.net;

import java.util.Map;

import com.graction.lumi.model.openData.IntegratedAirQualityModel;
import com.graction.lumi.model.openData.NearbyMsrtnModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface OpenDataFactoryIm {

	// Integrated Air Quality Index
	@Headers({"Accept: application/json;","charset: UTF-8"})
	@GET("/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty")
	Call<IntegratedAirQualityModel> selectIntegratedAirQuality(@QueryMap Map<String, String> map);
	
	@Headers({"Accept: application/json;","charset: UTF-8"})
	@GET("openapi/services/rest/MsrstnInfoInqireSvc/getNearbyMsrstnList")
	Call<NearbyMsrtnModel> selectNearByMsrtnList(@QueryMap Map<String, String> map);
}