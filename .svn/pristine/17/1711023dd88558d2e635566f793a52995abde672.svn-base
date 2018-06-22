package com.graction.lumi.util.db;

import java.text.ParseException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.graction.lumi.data.DataStorage.Database;
import com.graction.lumi.util.format.DateManager;

public class DatabaseManager {
	private JdbcTemplate jdbcTemplate;
	private static final String REGION_RESERVATION_EVENT_NAME = "regionReversationEvent_"
			, REGION_RESERVATION_START = REGION_RESERVATION_EVENT_NAME+"start_"
			, REGION_RESERVATION_END = REGION_RESERVATION_EVENT_NAME+"end_"
			;

	public DatabaseManager(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertQuery(String query) {
		jdbcTemplate.execute(query);
	}
	
	public void createRegionReservationEvent(int index, String startTime, String endTime) throws ParseException {
		DateManager dateManager = DateManager.getInstance();
		String reStartTime;
		String reEndTime = dateManager.stringDateReformat(DateManager.DATABASE_TIMESTAMP_FORMAT, endTime);
		if(dateManager.stringToTime(startTime) < System.currentTimeMillis())
			reStartTime = "CURRENT_TIMESTAMP + INTERVAL 10 SECOND";
		else
			reStartTime = "'"+dateManager.stringDateReformat(DateManager.DATABASE_TIMESTAMP_FORMAT, startTime)+"'";
		String query = "DROP EVENT IF EXISTS "+REGION_RESERVATION_START+index+"; CREATE EVENT "+REGION_RESERVATION_START+index+" ON SCHEDULE AT "+reStartTime+" DO call "+Database.Procedure.UPDATE_REGION_REVERSATION_EVENT+"("+index+", 'ACTIVATION');"
				+ "DROP EVENT IF EXISTS "+REGION_RESERVATION_END+index+"; CREATE EVENT "+REGION_RESERVATION_END+index+" ON SCHEDULE AT '"+reEndTime+"' DO call "+Database.Procedure.UPDATE_REGION_REVERSATION_EVENT+"("+index+", 'TERMINATED');";
		jdbcTemplate.execute(query);

	}
	
	public void deleteRegionReservationEvent(int index){
		String query = "DROP EVENT IF EXISTS "+REGION_RESERVATION_START+index+";"
				+ "DROP EVENT IF EXISTS "+REGION_RESERVATION_END+index+";";
		jdbcTemplate.execute(query);
	}
}
