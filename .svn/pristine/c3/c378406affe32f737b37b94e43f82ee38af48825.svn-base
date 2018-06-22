package com.graction.lumi.model.request;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.graction.lumi.util.StringUtil;
import com.graction.lumi.util.gps.GeoPoint;
import com.graction.lumi.util.gps.GeoTrans;

public class LatLonRequestModel {
	private static final String KEY_LAT = "lat"
								, KEY_LON = "lon"
								, KEY_TMX = "tmX"
								, KEY_TMY = "tmY"
								, OPEN_WEATHER_APIID = "5a165ea40110d89c6a33e762fb7501c6"
								, SK_PLANET_APPKEY = "a8c10122-bba0-35b7-a61c-d29002a2fee3"
								, OPEN_DATA_APPKEY = "B0HQD8ZLlW2LNyCNkg3pjKg5IyY%2F2oJ%2Fm3b92Q%2FUuqW75TlkLEVOJxNzRHUEKtH%2F4i%2BSl9DFQRbCpQstzRdNjg%3D%3D"
								;	
	public static final String	KEY_OPEN_WEATHER = "appid"
								, KEY_SK_PLANET = "appKey"
								, KEY_OPEN_DATA = "serviceKey"
								;
	private Map<String ,String> map;
	private String lat, lon;

	public LatLonRequestModel(String lat, String lon) {
		this(lat, lon, KEY_OPEN_WEATHER);
	}
	
	public LatLonRequestModel(String lat, String lon, String key) {
		map = new HashMap<String, String>();
		this.lat = lat;
		this.lon = lon;
		inputKey(key);
	}
	
	// Open Data API
	public LatLonRequestModel(String station){
		map = new HashMap<String, String>();
		map.put("stationName", station);
		map.put("numOfRows", "10");
		map.put("dataTerm", "DAILY");
		map.put("pageNo", "1");
		map.put("startPage", "1");
		map.put("ver", "1.3");
		inputKey(KEY_OPEN_DATA);
	}
	private void inputKey(String key) {
		switch (key) {
		case KEY_SK_PLANET:
			map.put(KEY_LAT, lat);
			map.put(KEY_LON, lon);
			map.put(KEY_SK_PLANET, SK_PLANET_APPKEY);
			map.put("version", "1");
			break;
		case KEY_OPEN_DATA:
			map.put("_returnType", "json");
			if(lat != null) {
				GeoPoint tmPoint = GeoTrans.convert(GeoTrans.GEO, GeoTrans.TM, new GeoPoint(Double.parseDouble(lon), Double.parseDouble(lat)));
				map.put(KEY_TMX, tmPoint.getX()+"");
				map.put(KEY_TMY, tmPoint.getY()+"");
			}
			try {
				map.put("serviceKey", StringUtil.urlEncoding(OPEN_DATA_APPKEY));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			break;
		case KEY_OPEN_WEATHER:
		default : 
			map.put(KEY_LAT, lat);
			map.put(KEY_LON, lon);
			map.put(KEY_OPEN_WEATHER, OPEN_WEATHER_APIID);
			break;
		}
	}
	
	public void setLat(String lat) {
		map.put(KEY_LAT, lat);
	}
	
	public void setLon(String lon) {
		map.put(KEY_LON, lon);
	}
	
	public Map<String, String> getMap() {
		return map;
	}

}