package com.graction.lumi.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Last update : 2017-11-21
 * By TH
 */
public class HLogger {
	private static final String NOTI = "########################################################################";
	private Class<?> cls;
	private Logger logger;
	private StringBuilder builder = new StringBuilder();

	public enum LogType {
		INFO, DEBUG, WARN, ERROR
	}
 
	public HLogger(Class<?> cls) {
		logger = LoggerFactory.getLogger(cls);
		this.cls = cls;
	}

	private void print(LogType logType, String message) {
		switch (logType) {
		case INFO:
			logger.info(message);
			break;
		case DEBUG:
			logger.debug(message);
			break;
		case WARN:
			logger.warn(message);
			break;
		case ERROR:
			logger.error(message);
			break;
		}
		builder = new StringBuilder();
	}

	// Error Method Message
	private void setBuliderData(String... str) {
		builder = new StringBuilder("\n"+NOTI + "\n");
		builder.append("# Class : " + cls.getCanonicalName() + "\n");
		switch (str.length) {
		case 3:
			builder.append("# Error : " + str[2] + "\n");
		case 2:
			builder.append("# Method : " + str[1] + "\n");
		case 1:
			builder.append("# Message : " + str[0] + "\n");
			break;
		}
		builder.append(NOTI + "\n");
	}

	/*
	 * builder.append(NOTI+"\n");
	 * builder.append("# Class : " + cls.getCanonicalName() + "\n");
	 * builder.append("# Method : " + method + "\n");
	 * builder.append("# Message : " + message + "\n");
	 * builder.append("# Error: " + t.getMessage() + "\n");
	 * builder.append(NOTI+"\n");
	 */
	public void log(LogType logType, String message) {
		log(logType, "", message);
	}

	public void log(LogType logType, String method, String message) {
        setBuliderData(message, method);
		print(logType, builder.toString());
	}

	public void log(LogType logType, String method, String form, Object... param) {
        setBuliderData(String.format(form, param), method);
		print(logType, builder.toString());
	}
	
	public void log(LogType logType, String method, Throwable t) {
		log(logType, method, "", t);
	}

	public void log(LogType logType, String method, Exception e) {
		log(logType, method, "", e);
	}

	public void log(LogType logType, String method, String message, Throwable t) {
        setBuliderData(message, method, t.getMessage());
		t.printStackTrace();
		print(logType, builder.toString());
	}

	public void log(LogType logType, String method, String message, Exception e) {
        setBuliderData(message, method, e.getMessage());
		e.printStackTrace();
		print(logType, builder.toString());
	}

}
