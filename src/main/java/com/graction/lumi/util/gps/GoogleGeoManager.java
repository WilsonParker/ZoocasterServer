package com.graction.lumi.util.gps;

import java.io.IOException;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;
import com.graction.lumi.util.log.HLogger;

/**
 * Created by Hare on 2017-07-20. Updated by Hare on 2017-09-27.
 */
public class GoogleGeoManager {
	private static GoogleGeoManager instance = new GoogleGeoManager();
	private static final String LANGUAGE = "ko";
	private HLogger logger;
	private AddressManager addressManager;

	public static GoogleGeoManager getInstance() {
		return instance;
	}
	
	public GoogleGeoManager() {
		logger = new HLogger(getClass());
		addressManager = AddressManager.getInstance();
	}

	// Use lat and lon to get address
	public String getAddress(final String lat, final String lon) {
		Geocoder geocoder = new Geocoder();
		LatLng latlng = new LatLng(lat, lon);
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setLocation(latlng).setLanguage(LANGUAGE)
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse;
		GeocoderResult geocoderResult = null;
		String address = "";
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);
			geocoder.geocode(geocoderRequest);
			for(GeocoderResult res: geocoderResponse.getResults()) {
				if(addressManager.isAddress(res.getFormattedAddress())) {
					address = res.getFormattedAddress();
					break;
				}
			}
			String[] ea = addressManager.extractAddress(address);
			logger.log(HLogger.LogType.INFO, "getAddress(final String lat, final String lon)", ea[0]+" / "+ea[1]+" / "+ea[2]);
		} catch (IOException e) {
			e.printStackTrace();
			logger.log(HLogger.LogType.ERROR, "getAddress(final String lat, final String lon)", e);
		}
		return address;
	}
}
