package com.graction.lumi.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.function.ToIntFunction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graction.lumi.dao.FineDustDAO;
import com.graction.lumi.dao.RegionDAO;
import com.graction.lumi.dao.WeatherDAO;
import com.graction.lumi.data.DataStorage;
import com.graction.lumi.data.DataStorage.Attribute;
import com.graction.lumi.data.DataStorage.Code;
import com.graction.lumi.data.DataStorage.Key;
import com.graction.lumi.data.DataStorage.Mapping;
import com.graction.lumi.data.DataStorage.Param;
import com.graction.lumi.data.DataStorage.Path;
import com.graction.lumi.data.DataTableManager;
import com.graction.lumi.data.InitializeManager;
import com.graction.lumi.data.RequestToModelManager;
import com.graction.lumi.model.db.FineDustTable;
import com.graction.lumi.model.db.RegionReservationTable;
import com.graction.lumi.model.db.param.ParamUpdateWeatherDetail;
import com.graction.lumi.model.response.DataResponseModel;
import com.graction.lumi.model.xml.weather.Weather;
import com.graction.lumi.util.db.DatabaseManager;
import com.graction.lumi.util.file.FileManager;
import com.graction.lumi.util.format.DateManager;
import com.graction.lumi.util.log.HLogger;
import com.graction.lumi.util.log.HLogger.LogType;
import com.graction.lumi.util.parser.DataParser;

/** 
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final HLogger logger = new HLogger(HomeController.class);
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/*
	 * ######################################################################################################################## 
	 * Page
	 * ######################################################################################################################## 
	 */
	
	/*
	 * Home Page
	 */
	@RequestMapping(value = Mapping.MAPPING_INDEX, method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		/*Date date = new Date();
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );*/
		commonAttribute(request);
		InitializeManager.getInstance().init(model, request, response);
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * Home Page
	 */
	@RequestMapping(value = Mapping.MAPPING_HOME, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return Path.PATH_VIEW_HOME;
	}
	
	/*
	 * Style Page
	 */
	@RequestMapping(value = Mapping.MAPPING_STYLE)
	public String stylePage(Model model, HttpServletRequest request) {
		return Path.PATH_VIEW_STYLE;
	}
	
	/*
	 * Script Page
	 */
	@RequestMapping(value = Mapping.MAPPING_SCRIPT)
	public String scriptPage(Model model, HttpServletRequest request) {
		return Path.PATH_VIEW_SCRIPT;
	}
	
	/*
	 * Weather Manage Page
	 * Can see the list of cached weather
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_WEATHER_CACHE, method = RequestMethod.GET)
	public String manage_weather(Model model) {
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_WEATHER_CACHE);
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * Weather image manage Page
	 * show weather list
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_WEATHER_IMAGE)
	public String weatherManagePage(Model model, HttpServletRequest request) {
		if(!DataTableManager.getInstance().isWeatherTableCreated())
			DataTableManager.getInstance().initDBWeatherTable(sqlSession);
//		request.setAttribute(Attribute.ATTR_WEATHER_TABLES, sqlSession.getMapper(WeatherDAO.class).selectAllWeathers());
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_WEATHER_IMAGE);
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * Weather image Detail Page
	 * manage Weather Image
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_WEATHER_IMAGE_DETAIL)
	public String weatherManageDetailPage(Model model, HttpServletRequest request, @RequestParam(Param.PARAM_CODE) int code) {
//		request.setAttribute(Attribute.ATTR_WEATHER_TABLES, sqlSession.getMapper(WeatherDAO.class).selectAllWeathers());
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_WEATHER_IMAGE_DETAIL);
//		model.addAttribute(Attribute.ATTR_MAP, DataParser.getInstance().objToMap(DataTableManager.getInstance().getDBWeatherTable(code)));
//		model.addAttribute(Attribute.ATTR_WEATHER_TABLE, DataTableManager.getInstance().getDBWeatherTable(code));
		WeatherDAO dao = sqlSession.getMapper(WeatherDAO.class);
		model.addAttribute(Attribute.ATTR_WEATHER_TABLE, dao.selectWeatherTable(code));
		return Path.PATH_VIEW_FRAME;
	}

	/*
	 * Weather region manage Page
	 * Show region reservation  list
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_REGION_RESERVATION, method = RequestMethod.GET)
	public String regionReservationManagePage(Model model, HttpServletRequest request) {
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		model.addAttribute(Attribute.ATTR_WEATHER_REGION_RESERVATION_TABLE, dao.select_all_region_reservation());
		model.addAttribute(Attribute.ATTR_CONTENT, Path.PATH_VIEW_MANAGE_REGION_RESERVATION);
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * Weather region add Page
	 * You can add region reservation here
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_REGION_RESERVATION_ADD)
	public String regionReservationAddPage(Model model, HttpServletRequest request) {
		DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
		commonAttribute(request);
		model.addAttribute(Attribute.ATTR_CONTENT, Path.PATH_VIEW_MANAGE_REGION_RESERVATION__ADD);
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * RegionReservatioDetail Detail Page
	 * Detailed view and modification of RegionReservation
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_REGION_RESERVATION_DETAIL)
	public String regionReservationDetailPage(Model model, HttpServletRequest request, @RequestParam(Param.PARAM_INDEX) int idx) {
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_REGION_RESERVATION_DETAIL);
		model.addAttribute(Attribute.ATTR_REGION_RESERVATION_DATA_VO, sqlSession.getMapper(RegionDAO.class).select_region_reservation_detail(idx));
		return Path.PATH_VIEW_FRAME;
	}

	/*
	 * Fine Dust manage Page
	 * Show fine dust list
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_FINE_DUST)
	public String fineDustManagePage(Model model, HttpServletRequest request) {
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_FINE_DUST);
		model.addAttribute(Attribute.ATTR_FINE_DUST_TABLE_LIST, sqlSession.getMapper(FineDustDAO.class).select_all_fine_dust());
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * Fine Dust Detail Page
	 * Detailed view and modification of fine dust
	 */
	@RequestMapping(value = Mapping.MAPPING_MANAGE_FINE_DUST_DETAIL)
	public String fineDustDetailPage(Model model, HttpServletRequest request, @RequestParam(Param.PARAM_INDEX) int idx) {
		model.addAttribute(Attribute.ATTR_CONTENT,Path.PATH_VIEW_MANAGE_FINE_DUST_DETAIL);
		model.addAttribute(Attribute.ATTR_FINE_DUST_VO, sqlSession.getMapper(FineDustDAO.class).select_fine_dust_detail(idx));
		return Path.PATH_VIEW_FRAME;
	}
	
	/*
	 * ######################################################################################################################## 
	 * Function
	 * ######################################################################################################################## 
	 */
	
	/*
	 * Weather id change
	 * Action when weather changed
	 */
	@RequestMapping(value = Mapping.MAPPING_WEATHER_ID_CHANGE, method = RequestMethod.GET)
	public void weatherIdChange(HttpServletRequest request) {
		String key = request.getParameter(Key.KEY_WEATHER_KEY);
		int id = Integer.parseInt(request.getParameter(Key.KEY_WEATHER_ID));
		com.graction.lumi.model.openWeather.Weather weather = DataTableManager.getInstance().getWeatherModel(key).getFirstWeather();
		weather.setId(id);
		for(Iterator<Weather> iterator = DataStorage.weatherData.getWeathers().getWeather().iterator(); iterator.hasNext();) {
			Weather w= iterator.next();
			 if(w.getId() == id){
				 weather.setDescription(w.getMessage());
				 break;
			 }
		}
	}
	
	/*
	 * upload image file
	 * It runs when upload images
	 * Weather Modify
	 */
	@ResponseBody
	@RequestMapping(value = Mapping.MAPPING_WEATHER_DETAIL_UPLOAD, method = RequestMethod.POST)
	public String weatherDetailupload(HttpServletRequest request, HttpServletResponse response) {
		int code = Integer.parseInt(request.getParameter(Param.PARAM_CODE));
		DataResponseModel<ParamUpdateWeatherDetail> resModel = FileManager.getInstance().weatherDetailUpload(request, response);
		ParamUpdateWeatherDetail param = resModel.getResult();
		param.setCode(code);
		sqlSession.getMapper(WeatherDAO.class).updateWeatehrDetail(param);
		/*try {
			WriteManager.getInstance().write(response, resModel.getCode()+"");
		} catch (Exception e) {
			logger.log(LogType.ERROR,"void weatherDetailupload(HttpServletRequest request, HttpServletResponse response)",e);
		}*/
		return resModel.getCode()+"";
	}
	
	/*
	 * upload image file
	 * It runs when region reservation add
	 */
	@ResponseBody
	@RequestMapping(value = Mapping.MAPPING_REGION_RESERVATION_ADD, method = RequestMethod.POST)
	public String regionReservationAdd(HttpServletRequest request, HttpServletResponse response) {
		DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
		DateManager dateManager = DateManager.getInstance();
		commonAttribute(request);
		
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		int result_code = Code.CODE_SUCCESS;
		try {
			RegionReservationTable param = RequestToModelManager.getInstance().requestRegionReservationTable(request, response);
			dao.insert_region_reversation(param);
			new DatabaseManager(jdbcTemplate).createRegionReservationEvent(param.getRegionReservation_index(), dateManager.timestampToString(param.getRegionReservation_active_time()), dateManager.timestampToString(param.getRegionReservation_end_time()));
		} catch (Exception e) {
			logger.log(LogType.ERROR,"void regionReservationAdd(HttpServletRequest request, HttpServletResponse response)",e);
			result_code = Code.CODE_FAIL;
		}
		return result_code+"";
	}
	
	/*
	 * Modify region reservation data
	 */
	@ResponseBody
	@RequestMapping(value = Mapping.MAPPING_REGION_RESERVATION_MODIFY, method = RequestMethod.POST)
	public String regionReservationModify(HttpServletRequest request, HttpServletResponse response) {
		DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
		DateManager dateManager = DateManager.getInstance();
		commonAttribute(request);
		
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		int result_code = Code.CODE_SUCCESS;
		try {
			RegionReservationTable param = RequestToModelManager.getInstance().requestRegionReservationTable(request, response);
			dao.update_region_reservation(param);
			new DatabaseManager(jdbcTemplate).createRegionReservationEvent(param.getRegionReservation_index(), dateManager.timestampToString(param.getRegionReservation_active_time()), dateManager.timestampToString(param.getRegionReservation_end_time()));
		} catch (Exception e) {
			logger.log(LogType.ERROR,"void regionReservationModify(HttpServletRequest request, HttpServletResponse response, @RequestParam(Param.PARAM_INDEX) int idx)",e);
			result_code = Code.CODE_FAIL;
		}
		return result_code+"";
	}
	
	/*
	 * Delete region reservation data
	 */
	@ResponseBody
	@RequestMapping(value = Mapping.MAPPING_REGION_RESERVATION_DELETE, method = RequestMethod.POST)
	public String regionReservationDelete(HttpServletRequest request, HttpServletResponse response, @RequestParam(Param.PARAM_INDEX) int index) {
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		logger.log(LogType.INFO, "regionReservationDelete(HttpServletRequest request, HttpServletResponse response, @RequestParam(Param.PARAM_INDEX) int index)", "index : %d",index);
		int result_code = Code.CODE_FAIL;
		if(dao.delete_region_reservation(index)) {
			new DatabaseManager(jdbcTemplate).deleteRegionReservationEvent(index);
			result_code = Code.CODE_SUCCESS;
		}
		return result_code+"";
	}
	
	/*
	 * Fine Dust Modify
	 * with upload image file
	 */
	@ResponseBody
	@RequestMapping(value = Mapping.MAPPING_FINE_DUST_MODIFY, method = RequestMethod.POST)
	public String fineDustModify(HttpServletRequest request, HttpServletResponse response) {
		commonAttribute(request);
		int result_code = Code.CODE_SUCCESS;
		int[] file_idx = Arrays.stream(FileManager.getInstance().insertfileInformation(request, response).split(",")).mapToInt(new ToIntFunction<String>() {
			public int applyAsInt(String value) {
				return Integer.parseInt(value);
			};
		}).toArray(); 
		try {
			if(file_idx.length > 2) {
				FineDustTable table = new FineDustTable(file_idx[0],file_idx[1],file_idx[2]);
				table = DataParser.getInstance().dataBinding(request, table);
				sqlSession.getMapper(FineDustDAO.class).update_fine_dust(table);
				logger.log(LogType.INFO, "void fineDustModify(HttpServletRequest request, HttpServletResponse response, @RequestParam(Param.PARAM_INDEX) int index)", table.toString());
			}else {
				result_code = Code.CODE_FAIL;
			}
		} catch (Exception e) {
			logger.log(LogType.ERROR, "void fineDustModify(HttpServletRequest request, HttpServletResponse response, @RequestParam(Param.PARAM_INDEX) int index)", e);
			result_code = Code.CODE_FAIL;
		}
		return result_code+"";
	}
	
	private void commonAttribute(HttpServletRequest request) {
		request.setAttribute(Attribute.ATTR_SQLSESSION, sqlSession);
	}
}

//file:///C:/Developer/Server/apache-tomcat-9.0.0.M26 STS/wtpwebapps/Lumi/assets/images/background/sunny.jpg