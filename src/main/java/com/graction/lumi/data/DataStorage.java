package com.graction.lumi.data;

import com.graction.lumi.model.data.station.StationModel;
import com.graction.lumi.model.xml.address.AddressData;
import com.graction.lumi.model.xml.weather.WeatherData;

public class DataStorage {
	public static String Path_Directory;
	public static WeatherData weatherData;
	public static AddressData addressData;
	public static StationModel stationModel;
	
	public static class Server{
		public static final String SERVER_URL = "http://localhost:8101/lumi"
									, PACKAGE_NAME = "/lumi"
									, PACKAGE_NAME_ONLY = "Lumi"
									, ENCODING = "UTF-8"
									, UPLOAD_DIR_REAL_PATH = "D:/Developer/Project/Lumi"		// drive's real upload real path
									, PATH_UPLOAD_DIR = "/lumiAssets"							// request server's upload path
											
									, KEY_LATLNG_SPLIT = ":"
				
									, PARAM_LAT = "lat"
									, PARAM_LON = "lon"
									
									;
	}
	
	public class Mapping{
		public static final String MAPPING_INDEX = "/"
									, MAPPING_HOME = "/home"
//									, MAPPING_ATTRIBUTE = "/attribute"
									, MAPPING_STYLE = "/style"
									, MAPPING_SCRIPT = "/script"
									, MAPPING_CURRENT_WEATHER = "/current_weather"
									, MAPPING_FORECAST_5DAY = "/forecast_5day"
									, MAPPING_FORECAST_DAILY= "/forecast_daily"
									, MAPPING_INTEGRATED_AIR_QUALITY = "/integratedAirQuality"
									, MAPPING_FINE_DUST = "/fine_dust"
									
									, MAPPING_MANAGE_WEATHER_CACHE = "/manage_weather_cache"
									, MAPPING_MANAGE_WEATHER_IMAGE = "/manage_weather_image"
									, MAPPING_MANAGE_WEATHER_IMAGE_DETAIL = "/manage_weather_image_detail"
									, MAPPING_MANAGE_REGION_RESERVATION = "/manage_region_reservation"
									, MAPPING_MANAGE_REGION_RESERVATION_ADD = "/manage_region_reservation_add"
									, MAPPING_MANAGE_REGION_RESERVATION_DETAIL = "/manage_region_reservation_detail"
									, MAPPING_MANAGE_FINE_DUST = "/manage_fine_dust"
									, MAPPING_MANAGE_FINE_DUST_DETAIL = "/manage_fine_dust_detail"
									
									, MAPPING_WEATHER_ID_CHANGE = "/weatherIdChange"
									, MAPPING_WEATHER_REGION_SELECT = "/weatherRegionSelect"
									, MAPPING_WEATHER_DETAIL_UPLOAD = "/weatherDetailupload"
									, MAPPING_UPLOAD_FILEIN_REQUEST_INFO = "/uploadFileInRequestInfo"
									, MAPPING_REGION_RESERVATION_ADD = "/regionReservationAdd"
									, MAPPING_REGION_RESERVATION_MODIFY = "/regionReservationModify"
									, MAPPING_REGION_RESERVATION_DELETE = "/regionReservationDelete"
									, MAPPING_FINE_DUST_MODIFY = "/fineDustModify"
											
									, MAPPING_ROOT_APP = "/app"
									, MAPPING_ROOT_TEST = "/test"
									;
	}
	
	public class Attribute{
		public static final String A = "/"
									, ATTR_CONTENT = "content"
									, ATTR_REQUEST = "request"
									, ATTR_RESPONSE = "response"
									, ATTR_DAO_MAPPER = "daoMapper"
									, ATTR_SQLSESSION = "sqlSession"
									
									, ATTR_MAP = "map"
									, ATTR_WEATHER_TABLES = "weather_tables"
									, ATTR_WEATHER_TABLE = "weather_table"
									, ATTR_WEATHER_CODE = "weather_code"
									
									, ATTR_WEATHER_REGION_RESERVATION_TABLE = "weather_region_reservation_table"
									, ATTR_WEATHER_REGION_TABLE = "weather_region_table"
									, ATTR_REGION_RESERVATION_DATA_VO = "region_reservation_data_vo"
									
									, ATTR_FINE_DUST_TABLE_LIST = "fine_dust_table_list"
									, ATTR_FINE_DUST_TABLE = "fine_dust_table"
									, ATTR_FINE_DUST_VO = "fine_dust_vo"
									;
	}
	
	public class Param{
		public static final String A = "/"
									, PARAM_DELIMITER = "_"
									, PARAM_CODE = Key.KEY_CODE
									, PARAM_INDEX = Key.KEY_INDEX
									
									, PARAM_BACKGROUND = Key.KEY_BACKGROUND
									, PARAM_BACKGROUND_FILE = Key.KEY_BACKGROUND+PARAM_DELIMITER+Key.KEY_FILE
									, PARAM_BACKGROUND_INDEX = Key.KEY_BACKGROUND+PARAM_DELIMITER+Key.KEY_INDEX
									, PARAM_background_img_path = Key.KEY_BACKGROUND+PARAM_DELIMITER+Key.KEY_PATH
									, PARAM_CHARACTER = Key.KEY_CHARACTER
									, PARAM_CHARACTER_FILE = Key.KEY_CHARACTER+PARAM_DELIMITER+Key.KEY_FILE
									, PARAM_CHARACTER_INDEX = Key.KEY_CHARACTER+PARAM_DELIMITER+Key.KEY_INDEX
									, PARAM_CHARACTER_PATH = Key.KEY_CHARACTER+PARAM_DELIMITER+Key.KEY_PATH
									, PARAM_EFFECT = Key.KEY_EFFECT
									, PARAM_EFFECT_FILE = Key.KEY_EFFECT+PARAM_DELIMITER+Key.KEY_FILE
									, PARAM_EFFECT_INDEX = Key.KEY_EFFECT+PARAM_DELIMITER+Key.KEY_INDEX
									, PARAM_EFFECT_PATH = Key.KEY_EFFECT+PARAM_DELIMITER+Key.KEY_PATH
									
									, PARAM_FINE_DUST_INDEX = Database.Column.COLUMN_FINE_DUST_INDEX
									, PARAM_FINE_DUST_GRADE = Database.Column.COLUMN_FINE_DUST_GRADE
									, PARAM_FINE_DUST_MIN = Database.Column.COLUMN_FINE_DUST_MIN
									, PARAM_FINE_DUST_MAX = Database.Column.COLUMN_FINE_DUST_MAX
									, PARAM_FINE_DUST_ACTIVATION = Database.Column.COLUMN_FINE_DUST_ACTIVATION
									
									, PARAM_REGION = Key.KEY_REGION
									, PARAM_TIME = Key.KEY_TIME
									, PARAM_PRIORITIZATION = Key.KEY_PRIORITIZATION
									;
				
	}
	
	public class Key{
		public static final String KEY_RESOURCES = "resources"
									, KEY_DATA = "data"
									, KEY_XML = "xml"
									, KEY_JSON = "json"
									, KEY_BOOTSTRAP = "bootstrap"
									, KEY_CSS = "css"
									, KEY_JS = "js"
									, KEY_IMG = "img"
									, KEY_OPEN_SOURCE = "openSource"
									
									, KEY_PRELOADER = "preloader"
									
									, KEY_CODE = "code"
									, KEY_FILE = "file"
									, KEY_PATH = "path"
									, KEY_INDEX = "index"
									
									, KEY_ASSETS = "assets"
									, KEY_IMAGES = "images"
									, KEY_BACKGROUND = "background"
									, KEY_CHARACTER = "character"
									, KEY_EFFECT = "effect"
									
									, KEY_WEATHER_ID = "weather_id"
									, KEY_WEATHER_KEY = "weather_key"
									
									, KEY_REGION = "region"
									, KEY_TIME = "time"
									
									, KEY_PRIORITIZATION = "prioritization"
									, KEY_FINE_DUST = "fineDust"
									, KEY_ACTIVATION = "activation"
									, KEY_RESERVATION = "reservation"
									, KEY_TERMINATED = "terminated"
									
									;
	}
	
	public class Path{
									// path of folder or files
		public static final String  PATH_RESOURCES = "/" + Key.KEY_RESOURCES + "/" 
//									PATH_RESOURCES = Server.PAKAGE_NAME + "/" + Key.KEY_RESOURCES + "/"
									, PATH_DIR_DATA = PATH_RESOURCES + Key.KEY_DATA + "/"
									, PATH_DIR_XML = PATH_DIR_DATA+ "/" + Key.KEY_XML + "/"
									, PATH_DIR_JSON = PATH_DIR_DATA+ "/" + Key.KEY_JSON + "/"
									
									, PATH_DIR_BOOTSTRAP = Server.PACKAGE_NAME + PATH_RESOURCES + Key.KEY_BOOTSTRAP + "/"
									, PATH_DIR_BOOTSTRAP_CSS = PATH_DIR_BOOTSTRAP + Key.KEY_CSS + "/"  
									, PATH_DIR_BOOTSTRAP_JS = PATH_DIR_BOOTSTRAP + Key.KEY_JS + "/"
									, PATH_DIR_CSS = Server.PACKAGE_NAME + PATH_RESOURCES + Key.KEY_CSS + "/"
									, PATH_DIR_JS = Server.PACKAGE_NAME + PATH_RESOURCES + Key.KEY_JS + "/"
									
									, PATH_DIR_OPEN_SOURCE = Server.PACKAGE_NAME + PATH_RESOURCES + Key.KEY_OPEN_SOURCE + "/"
									, PATH_DIR_PRELOADER = PATH_DIR_OPEN_SOURCE + Key.KEY_PRELOADER+ "/"
									, PATH_DIR_PRELOADER_JS = PATH_DIR_PRELOADER + Key.KEY_JS + "/"
									, PATH_DIR_PRELOADER_CSS = PATH_DIR_PRELOADER + Key.KEY_CSS + "/"
									, PATH_DIR_PRELOADER_IMG = PATH_DIR_PRELOADER + Key.KEY_IMG + "/"
									
									
									, PATH_DIR_ASSETS = "/" + Key.KEY_ASSETS + "/"
									, PATH_DIR_IMAGES = PATH_DIR_ASSETS + Key.KEY_IMAGES + "/"
									, PATH_DIR_IMAGES_BACKGROUND = PATH_DIR_IMAGES + Key.KEY_BACKGROUND + "/"
									, PATH_DIR_IMAGES_CHARACTER = PATH_DIR_IMAGES + Key.KEY_CHARACTER + "/"
									, PATH_DIR_IMAGES_EFFECT = PATH_DIR_IMAGES + Key.KEY_EFFECT + "/"
											
									// jsp folder
									, PATH_VIEW_DIR_HOME = "/home/"
									, PATH_VIEW_DIR_MANAGE = "/manage/"
									
									// path of jsp
									, PATH_VIEW_FRAME = PATH_VIEW_DIR_HOME + File.VIEW_FRAME
									, PATH_VIEW_HOME = PATH_VIEW_DIR_HOME + File.VIEW_HOME
									
									, PATH_VIEW_MANAGE_WEATHER_CACHE = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_WEATHER_CACHE
									, PATH_VIEW_MANAGE_WEATHER_IMAGE = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_WEATHER_IMAGE
									, PATH_VIEW_MANAGE_WEATHER_IMAGE_DETAIL = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_WEATHER_IMAGE_DETAIL
									, PATH_VIEW_MANAGE_REGION_RESERVATION = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_REGION_RESERVATION
									, PATH_VIEW_MANAGE_REGION_RESERVATION__ADD = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_REGION_RESERVATION_ADD
									, PATH_VIEW_MANAGE_REGION_RESERVATION_DETAIL = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_REGION_RESERVATION_DETAIL
									, PATH_VIEW_MANAGE_FINE_DUST = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_FINE_DUST
									, PATH_VIEW_MANAGE_FINE_DUST_DETAIL = PATH_VIEW_DIR_MANAGE + File.VIEW_MANAGE_FINE_DUST_DETAIL
									
//									, PATH_VIEW_ATTRIBUTE = PATH_VIEW_DIR_HOME+ "/" + File.VIEW_ATTRIBUTE
									, PATH_VIEW_STYLE = PATH_VIEW_DIR_HOME + File.VIEW_STYLE
									, PATH_VIEW_SCRIPT = PATH_VIEW_DIR_HOME + File.VIEW_SCRIPT
									
									;
	}
	
	public class File{
									// file
		public static final String FILE_NAME_XML_WEATHERDATA = "WeatherData.xml"
									, FILE_NAME_XML_ADDRESSDATA = "AddressData.xml"
									, FILE_NAME_XML_FINEDUSTDATA = "FineDustData.xml"
									, FILE_NAME_JS_COMMONSCRIPT = "commonScript.js"
				
									// jsp
									, VIEW_FRAME = "frame"
									, VIEW_HOME = "home"
//									, VIEW_ATTRIBUTE = "attribute"
									, VIEW_STYLE = "style"
									, VIEW_SCRIPT = "script"
									
									, VIEW_MANAGE_WEATHER_CACHE = "manage_weather_cache"
									, VIEW_MANAGE_WEATHER_IMAGE = "manage_weather_image"
									, VIEW_MANAGE_WEATHER_IMAGE_DETAIL = "manage_weather_image_detail"
									, VIEW_MANAGE_REGION_RESERVATION = "manage_region_reservation"
									, VIEW_MANAGE_REGION_RESERVATION_ADD = "manage_region_reservation_add"
									, VIEW_MANAGE_REGION_RESERVATION_DETAIL = "manage_region_reservation_detail"
									, VIEW_MANAGE_FINE_DUST = "manage_fine_dust"
									, VIEW_MANAGE_FINE_DUST_DETAIL = "manage_fine_dust_detail"
									;
		
	}
	
	public class Type{
		public static final String TYPE_STRING_WEATHER_IS_FILE = "root"
									
									, TYPE_TERMINATED = "TERMINATED"
									, TYPE_ACTIVATION = "ACTIVATION"
									, TYPE_RESERVATION = "RESERVATION"
									;
	}

	public class Database{
		public class Column{
			public static final String COLUMN_WEATHER_CODE = "weather_code"
					, COLUMN_WEATHER_NAME = "weather_code"
					, COLUMN_BACKGROUND_ROOT = "background_root"
					, COLUMN_BACKGROUND_PATH = "background_img_path"
					, COLUMN_BACKGROUND_NAME = "background_img_name"
					, COLUMN_BACKGROUND_INDEX = "background_index"
					, COLUMN_CHARACTER_ROOT = "character_root"
					, COLUMN_CHARACTER_PATH = "character_img_path"
					, COLUMN_CHARACTER_NAME = "character_img_name"
					, COLUMN_CHARACTER_INDEX = "character_index"
					, COLUMN_EFFECT_ROOT = "effect_root"
					, COLUMN_EFFECT_PATH = "effect_img_path"
					, COLUMN_EFFECT_NAME = "effect_img_name"
					, COLUMN_EFFECT_INDEX = "effect_index"
					
					, COLUMN_FINE_DUST_INDEX = "fineDust_index"
					, COLUMN_FINE_DUST_GRADE = "fineDust_grade"
					, COLUMN_FINE_DUST_MIN = "fineDust_min"
					, COLUMN_FINE_DUST_MAX = "fineDust_max"
					, COLUMN_FINE_DUST_ACTIVATION = "fineDust_activation"
					
					;
		}
		
		public class Procedure{
			public static final String UPDATE_REGION_REVERSATION_EVENT = "updateRegionReservationEvent"
										;
		}
	}
	
	public class Code{
		public static final int CODE_SUCCESS = 0x00A0
				
								, CODE_FAIL = 0x00B0
								;
	}
	
	public class Message{
		public static final String SUCCESS = ""
				
									, WEATHER_DETAIL_SUCCESS_MESSAGE = "수정 성공 하였습니다"
									, WEATHER_DETAIL_FAIL_MESSAGE = "수정 실패 하였습니다"
									
									, REGION_RESERVATION_ADD_SUCCESS_MESSAGE = "성공적으로 예약을 추가 하였습니다"
									, REGION_RESERVATION_ADD_FAIL_MESSAGE = "예약 추가 하지 못하였습니다"
									, REGION_RESERVATION_MODIFY_SUCCESS_MESSAGE = "성공적으로 예약을 수정 하였습니다"
									, REGION_RESERVATION_MODIFY_FAIL_MESSAGE = "예약 수정 하지 못하였습니다"
									, REGION_RESERVATION_DELETE_SUCCESS_MESSAGE = "성공적으로 예약을 삭제 하였습니다"
									, REGION_RESERVATION_DELETE_FAIL_MESSAGE = "예약 삭제 하지 못하였습니다"
									
									, FINE_DUST_DETAIL_SUCCESS_MESSAGE = "수정 성공 하였습니다"
									, FINE_DUST_DETAIL_FAIL_MESSAGE = "수정 실패 하였습니다"
				;
	}
}