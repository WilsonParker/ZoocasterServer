package com.graction.lumi.util.gps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.graction.lumi.model.location.GoogleLocationModel;
import com.graction.lumi.model.location.GoogleLocationModel.GoogleLocationItem;
import com.graction.lumi.model.location.GoogleLocationModel.GoogleLocationItem.Geometry.Location;
import com.graction.lumi.util.log.HLogger;

/**
 * Created by Hare on 2017-07-20. Updated by Hare on 2017-09-27.
 */
public class GoogleLocationManager {
	private static GoogleLocationManager instance = new GoogleLocationManager();
	private static final String ENCODING = "utf-8", LANGUAGE = "ko",
			API_URL = "https://maps.googleapis.com/maps/api/geocode/json",
			API_KEY = "AIzaSyD9_KwNkBPan46kNUNPGOfE87yKCyzBy0U",
			REG = "(^([가-힇])*( |)([가-힣]+(시|도))( |)[가-힣]+(시|군|구)(( |)([가-힇1-9_-]))*)";
	private HLogger logger;

	public static GoogleLocationManager getInstance() {
		return instance;
	}

	public GoogleLocationManager() {
		logger = new HLogger(getClass());
	}

	// Use lat and lon to get address
	public String getAddress(final String lat, final String lon) throws IOException {
		String apiURL = API_URL + "?" + "latlng=" + lat + "," + lon + "&key=" + API_KEY + "&language=" + LANGUAGE;
		for (GoogleLocationItem item : getResultModels(apiURL))
			if (item.getFormatted_address().matches(REG))
				return item.getFormatted_address();
		return null;
	}

	// Use address to get lat and lon
	public Location getAddress(final String address) throws IOException {
		String apiURL = API_URL + "?" + "address=" + address
		// + "&key=" + API_KEY
				+ "&language=" + LANGUAGE;
		for (GoogleLocationItem item : getResultModels(apiURL))
			if (item.getFormatted_address().matches(REG))
				return item.getGeometry().getLocation();
		return null;
	}

	private ArrayList<GoogleLocationItem> getResultModels(String apiUrl) throws IOException {
		String inputLine;

		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		// logger.log(LogType.INFO, "getAddress(final String lat, final String
		// lon)","lat : "+lat+" / lon : "+lon);
		// logger.log(LogType.INFO, "getAddress(final String lat, final String
		// lon)",apiURL);
		// logger.log(LogType.INFO, "getAddress(final String lat, final String
		// lon)",response.toString());
		Gson gson = new Gson();
		GoogleLocationModel model = gson.fromJson(response.toString(), GoogleLocationModel.class);
		// logger.log(LogType.INFO, "getAddress(final String lat, final String
		// lon)",model.toString());
		return model.getResults();
	}
}
