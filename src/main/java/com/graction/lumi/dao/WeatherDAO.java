package com.graction.lumi.dao;

import java.util.ArrayList;

import com.graction.lumi.model.db.param.ParamUpdateWeatherDetail;
import com.graction.lumi.model.vo.WeatherVO;

public interface WeatherDAO {
	
	/*
	 * UPDATE
	 */
	void updateWeatehrDetail(ParamUpdateWeatherDetail param);
	
	
	/*
	 * SELECT
	 */
	ArrayList<WeatherVO> selectAllWeathers();
	
	WeatherVO selectWeatherTable(int code);
}
