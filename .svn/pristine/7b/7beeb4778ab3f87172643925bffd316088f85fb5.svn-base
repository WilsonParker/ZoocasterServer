package com.graction.lumi.util.format;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Date 관련 Class
 */
public class DateManager {
	public static final String DEFAULT_DATE_FORMAT = "yyyy.MM.dd HH:mm"
			, DATABASE_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm";
	private static final DateManager instance = new DateManager();
	private final int DateLength = 13;
	private SimpleDateFormat simpleDateFormat;

	public static DateManager getInstance() {
		return instance;
	}

	public DateManager() {
		simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	}

	public String longToDate(String dateTime) {
		while (dateTime.length() < DateLength) dateTime += "0";
		return longToDate(DEFAULT_DATE_FORMAT, Long.parseLong(dateTime));
	}

	public String longToDate(String format, String dateTime) {
		simpleDateFormat.applyLocalizedPattern(format);
		while (dateTime.length() < DateLength) dateTime += "0";
		return longToDate(format, Long.parseLong(dateTime));
	}
	
	public String longToDate(long dateTime) {
		Date date = new Date(dateTime);
		return longToDate(DEFAULT_DATE_FORMAT, date.getTime());
	}
	
	public String longToDate(String format, long dateTime) {
		simpleDateFormat.applyPattern(format);
		Date date = new Date(dateTime);
		return simpleDateFormat.format(date.getTime());
	}
	
	public long stringToTime(String date) throws ParseException {
		return stringToTime(DEFAULT_DATE_FORMAT, date);
	}

	public long stringToTime(String format, String date) throws ParseException {
		simpleDateFormat.applyPattern(format);
		return simpleDateFormat.parse(date.trim()).getTime();
	}
	
	public Timestamp stringToTimestamp(String date) throws ParseException {
		return new Timestamp(stringToTime(date.trim()));
	}
	
	public String timestampToString(String format, Timestamp timestamp) throws ParseException {
		return longToDate(format, timestamp.getTime());
	}
	
	public String timestampToString(Timestamp timestamp) throws ParseException {
		return longToDate(timestamp.getTime());
	}
	
	public String stringDateReformat(String afterFormat, String date) throws ParseException {
		return longToDate(afterFormat, stringToTime(date));
	}
	
	public String stringDateReformat(String beforeFormat, String afterFormat, String date) throws ParseException {
		return longToDate(afterFormat, stringToTime(beforeFormat, date));
	}
}
