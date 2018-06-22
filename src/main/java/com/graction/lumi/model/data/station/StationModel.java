package com.graction.lumi.model.data.station;

import java.util.List;

public class StationModel {
	private List<StationItem> list;

	public List<StationItem> getList() {
		return list;
	}

	public void setList(List<StationItem> list) {
		this.list = list;
	}

	public String convertStation(String station) {
		for(StationItem stationItem : list)
			if(stationItem.key.equals(station))
				return stationItem.value;
		return station;
	}
	
	@Override
	public String toString() {
		return "StationModel [list=" + list + "]";
	}

	public class StationItem {
		private String key, value;
		private List<String> stationList;
		
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public List<String> getStationList() {
			return stationList;
		}

		public void setStationList(List<String> stationList) {
			this.stationList = stationList;
		}

		@Override
		public String toString() {
			return "StationItem [key=" + key + ", value=" + value + ", stationList=" + stationList + "]";
		}

	}
}
