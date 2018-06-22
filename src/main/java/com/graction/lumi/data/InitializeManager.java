package com.graction.lumi.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.graction.lumi.dao.RegionDAO;
import com.graction.lumi.dao.WeatherDAO;
import com.graction.lumi.data.DataStorage.Attribute;
import com.graction.lumi.data.DataStorage.File;
import com.graction.lumi.data.DataStorage.Server;
import com.graction.lumi.model.data.station.StationModel;
import com.graction.lumi.model.xml.weather.WeatherData;
import com.graction.lumi.util.log.HLogger;
import com.graction.lumi.util.log.HLogger.LogType;
import com.graction.lumi.util.parser.XmlParserForJAXB;

public class InitializeManager {
	private static final HLogger logger = new HLogger(InitializeManager.class);
	private static final InitializeManager instance = new InitializeManager();
	private static boolean INIT = false;
	private SqlSession sqlSession;
	// private static DaoMapper daoMapper;

	public static InitializeManager getInstance() {
		return instance;
	}

	public void init(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			sqlSession = (SqlSession) request.getAttribute(Attribute.ATTR_SQLSESSION);
			DataTableManager.getInstance().setSqlSession(sqlSession);
			DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
			DataTableManager.getInstance().initDBWeatherTable(sqlSession);
			request.setCharacterEncoding(Server.ENCODING);
			response.setCharacterEncoding(Server.ENCODING);
			response.setContentType("text/html;charset="+Server.ENCODING);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			
			model.addAttribute(Attribute.ATTR_REQUEST, request);
			model.addAttribute(Attribute.ATTR_RESPONSE, response);
			model.addAttribute(Attribute.ATTR_SQLSESSION, sqlSession);
			// model.addAttribute(Attribute.ATTR_DAO_MAPPER,
			// sqlSession.getMapper(DaoMapper.class));
			// InitializeManager.initialize(model, request, response);
			initParseData(request);
//			initLog();

//			DataTableManager.getInstance().initDBWeatherTable(sqlSession);
		} catch (Exception e) {
			logger.log(LogType.ERROR, "init(Model model, HttpServletRequest request, HttpServletResponse response)", "init error", e);
		}
	}

	private void initParseData(HttpServletRequest request) {
		DataStorage.weatherData = XmlParserForJAXB.getInstance().parseXmlToObject(WeatherData.class, File.FILE_NAME_XML_WEATHERDATA);
		// logger.log(LogType.INFO, DataStorage.weatherData.toString());
		// DataStorage.addressData =
		// XmlParserForJAXB.getInstance().parseXmlToObject(AddressData.class,
		// File.FILE_NAME_XML_ADDRESSDATA);
		// logger.log(LogType.INFO,"initParseData()",weatherData.toString());
		//

		RegionDAO regionDAO = sqlSession.getMapper(RegionDAO.class);
//		for (RegionVO regionVO : regionDAO.select_all_region()) { logger.log(LogType.INFO, "initParseData()", regionVO.toString()); }
		WeatherDAO weatherDAO = sqlSession.getMapper(WeatherDAO.class);
		// for(WeatherTable table : weatherDAO.selectAllWeathers()) {
		// logger.log(LogType.INFO, table.toString()); }

		DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
		
	}
	
	public void initParseData() {
		// System.out.println(DataStorage.Path_Directory);
		// C:\Developer\Server\apache-tomcat-9.0.0.M26 STS\wtpwebapps\Lumi\resources\data\json
		StringBuffer sb = new StringBuffer();
		try {
			////////////////////////////////////////////////////////////////
			BufferedReader in = new BufferedReader(new FileReader(DataStorage.Path_Directory + DataStorage.Path.PATH_DIR_JSON + "station.json"));
			String s;
			while ((s = in.readLine()) != null) {
				// System.out.println(s);
				sb.append(s);
			}
			in.close();
		} catch (IOException e) {
			logger.log(LogType.ERROR, "initParseData()", e);
			// System.exit(1);
		}

//		System.out.println(sb.toString());
		DataStorage.stationModel = new Gson().fromJson(sb.toString(), StationModel.class);
//		System.out.println(DataStorage.stationModel);
		
	}

	private void initLog() {
		logger.log(LogType.INFO, "initParseData()", DataStorage.Path_Directory);
	}

}
