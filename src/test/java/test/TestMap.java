package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMap {

	@Test
	public void test() {
		// fail("Not yet implemented");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceKey", "B0HQD8ZLlW2LNyCNkg3pjKg5IyY%2F2oJ%2Fm3b92Q%2FUuqW75TlkLEVOJxNzRHUEKtH%2F4i%2BSl9DFQRbCpQstzRdNjg%3D%3D");
		map.put("stationName", "종로구");
		map.put("numOfRows", "10");
		map.put("dataTerm", "DAILY");
		map.put("_returnType", "json");
		map.put("pageNo", "1");
		map.put("startPage", "1");
		map.put("ver", "1.3");
		mapToString(map);
	}

	private void mapToString(Map<String, String> map) {
		String url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?";
		for (String key : map.keySet()) {
			url += key + "=" + map.get(key) + "&";
		}
		System.out.println(url);
	}
}
