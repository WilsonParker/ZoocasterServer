package com.graction.lumi.model.db.param;

import java.sql.Timestamp;

public class ParamRegionReversationEvent {
	private final String EVENT_NAME = "regionReversationEvent_", START = "start_", END = "end_";
	private String startName, endName;
	private Timestamp startTime, endTime;
	private int index;

	public ParamRegionReversationEvent(Timestamp startTime, Timestamp endTime, int index) {
		this.startName = EVENT_NAME + START + index;
		this.endName = EVENT_NAME + END + index;
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
	}

	public String getStartName() {
		return startName;
	}

	public void setStartName(String startName) {
		this.startName = startName;
	}

	public String getEndName() {
		return endName;
	}

	public void setEndName(String endName) {
		this.endName = endName;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
