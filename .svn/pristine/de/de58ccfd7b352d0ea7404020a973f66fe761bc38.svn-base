package init;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import org.junit.Test;

import com.google.gson.Gson;
import com.graction.lumi.data.DataStorage;
import com.graction.lumi.model.data.station.StationModel;
import com.graction.lumi.model.data.station.StationModel.StationItem;
import com.graction.lumi.util.StringUtil;

import init.GetMsrstnList.MsrList.MsrItem;

public class GetMsrstnList {

	@Test
	public void test() {
//		fail("Not yet implemented");

		test3();
	}
	
	private void test1() {
		try {
			String inputLine;
			URL url = new URL("http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?serviceKey=B0HQD8ZLlW2LNyCNkg3pjKg5IyY%2F2oJ%2Fm3b92Q%2FUuqW75TlkLEVOJxNzRHUEKtH%2F4i%2BSl9DFQRbCpQstzRdNjg%3D%3D&numOfRows=385&pageNo=1&startPage=1&_returnType=json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			Gson gson = new Gson();
			MsrList model = gson.fromJson(response.toString(), MsrList.class);
			System.out.println(model);
			
			ArrayList<String> addrs = new ArrayList<String>();
			ArrayList<String> stations = new ArrayList<String>();
			Map<String, ArrayList<String>> stationMap = new HashMap<String, ArrayList<String>>();
			model.list.parallelStream().forEach(new Consumer<MsrItem>() {

				@Override
				public void accept(MsrItem t) {
					String s = t.addr.split(" ")[0];
					addrs.add(s);					
					stations.add(t.stationName);
					ArrayList<String> list = stationMap.get(s);
					if(list == null) {
						list = new ArrayList<String>();
					}
					list.add(t.stationName);
					stationMap.put(s, list);
				}
			});
			Object[] addrs2 = addrs.stream().distinct().toArray();
			System.out.println(addrs);
			System.out.println(Arrays.toString(addrs2));
//			대구, 경북, 충북, 경기, 충남, 전북, 대전, 서울, 전남, 제주, 울산, 경남, 광주, 부산, 인천, 세종, 강원
//			대구, 경북, 충북, 경기, 충남, 전북, 대전, 인천, 강원, 세종, 울산, 경남, 부산, 제주, 서울, 전남, 광주
			
			Object[] stations2 = stations.stream().distinct().toArray();
			System.out.println(Arrays.toString(stations2));
			
			System.out.println();
			for(String key : stationMap.keySet()) {
				System.out.println(key+" : "+stationMap.get(key));
			}
			
/*
			울산 : [여천동(울산), 야음동, 삼산동, 신정2동, 신정동, 덕신리, 무거동, 효문동, 대송동, 성남동, 부곡동(울산), 약사동, 화산리, 상남리, 농소동, 삼남면]
			충북 : [진천읍, 옥천읍, 호암동, 칠금동, 장락동, 오창읍, 매포읍, 청천면, 금왕, 송정동(봉명동), 사천동, 문화동, 용암동, 복대동]
			서울 : [노원구, 화랑로, 관악구, 강남구, 서초구, 은평구, 도산대로, 서대문구, 마포구, 강남대로, 신촌로, 송파구, 강서구, 강동구, 공항대로, 천호대로, 구로구, 금천구, 영등포구, 영등포로, 강북구, 동작구, 양천구, 동작대로 중앙차로, 종로, 중구, 용산구, 한강대로, 광진구, 종로구, 성동구, 강변북로, 청계천로, 중랑구, 동대문구, 홍릉로, 성북구, 정릉로, 도봉구]
			전북 : [부안군, 요촌동, 새만금, 삼천동, 팔복동, 금암동, 신풍동(군산), 소룡동, 개정동, 남중동, 팔봉동, 모현동, 연지동, 죽항동, 고창읍, 운암면, 중앙동(전주)]
			경기 : [신원동, 호계동, 안양2동, 철산동, 소하동, 고잔동, 원시동, 본오동, 원곡동, 부곡동1, 대부동, 호수동, 중앙대로(고잔동), 별양동, 과천동, 교문동, 동구동, 소사본동, 내동, 중2동, 부곡3동, 고천동, 일동면사무소, 정왕동, 시화산단, 대야동, 금곡동, 단대동, 수내동, 성남대로(모란역), 복정동, 운중동, 상대원동, 의정부동, 의정부1동, 안양6동, 부림동, 파주, 신풍동, 인계동, 광교동, 영통동, 천천동, 경수대로(동수원), 고색동, 대왕판교로(백현동), 오정동, 산본동, 송내대로(중동), 오산동, 신장동, 수지, 남양읍, 기흥, 향남, 중부대로(구갈동), 운정, 설성면, 창전동, 백석읍, 관인면, 보산동, 선단동, 봉산동, 사우동, 고촌읍, 여주, 통진읍, 연천, 당동, 오남읍, 가평, 양평, 비전동, 안중, 평택항, 금촌동, 행신동, 식사동, 백마로(마두역), 경안동, 김량장동]
			충남 : [청양읍, 배방읍, 금산읍, 대천2동, 홍성읍, 태안읍, 공주, 부여읍, 논산, 이원면, 예산군, 독곶리, 동문동, 난지도리, 송산면, 모종동, 파도리, 성황동, 백석동, 성성동, 사곡면]
			부산 : [기장읍, 용수리, 수정동, 부곡동, 광안동, 대신동, 명장동, 대연동, 학장동, 덕천동, 청룡동, 좌동, 장림동, 대저동, 녹산동, 연산동, 광복동, 초량동, 태종대, 전포동, 온천동]
			강원 : [북평면, 간성읍, 치악산, 중앙로, 석사동, 방산면, 중앙동(원주), 명륜동, 옥천동, 천곡동, 남양동1]
			경북 : [장흥동, 장량동, 대도동, 대송면, 3공단, 안계면, 태하리, 성건동, 문당동, 남문동, 공단동, 원평동, 형곡동, 4공단, 휴천동, 중방동, 지품면, 화북면, 상주시]
			대전 : [읍내동, 문평동, 문창동, 구성동, 노은동, 대흥동1, 성남동1, 정림동, 둔산동, 월평동]
			세종 : [신흥동, 아름동]
			제주 : [성산읍, 이도동, 연동, 동홍동, 고산리]
			대구 : [노원동, 신암동, 태전동, 만촌동, 호림동, 현풍면, 수창동, 지산동, 서호동, 이현동, 평리동, 대명동, 이곡동]
			인천 : [석남, 송해, 동춘, 운서, 송현, 논현, 원당, 신흥, 송림, 구월동, 숭의, 석바위, 부평역, 연희, 검단, 계산, 고잔, 석모리, 덕적도, 백령도]
			전남 : [용당동, 부흥동, 광무동, 월내동, 문수동, 여천동(여수), 덕충동, 장천동, 연향동, 순천만, 호두리, 중동, 태인동, 진상면, 광양읍, 나불리, 송단리]
			경남 : [상봉동, 대안동, 상대동, 명서동, 웅남동, 가음정동, 용지동, 회원동, 봉암동, 내일동, 무전동, 대산면, 북부동, 웅상읍, 남상면, 반송로, 사파동, 경화동, 하동읍, 동상동, 삼방동, 장유동, 저구리, 아주동, 사천읍]
			광주 : [두암동, 운암동, 건국동, 송정1동, 오선동, 주월동, 서석동, 농성동, 치평동]
*/
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private void test2() {
		String[] stations = "대구, 경북, 충북, 경기, 충남, 전북, 대전, 인천, 강원, 세종, 울산, 경남, 부산, 제주, 서울, 전남, 광주".split(", ");
		for(String s : stations) {
			System.out.printf("{\n\"key\":\"\",\n\"value\":\"%s\"\n},\n",s);
		}
		
		try {
			File file = new File("json");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getPath());
			System.out.println(file.getCanonicalPath());
			// C:\Developer\WorkSpace\Spring\Lumi\src\main\webapp\resources\data\json\station.json
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void test3() {
		/*
		  	, 울산 : [여천동(울산), 야음동, 삼산동, 신정2동, 신정동, 덕신리, 무거동, 효문동, 대송동, 성남동, 부곡동(울산), 약사동, 화산리, 상남리, 농소동, 삼남면]
			, 충북 : [진천읍, 옥천읍, 호암동, 칠금동, 장락동, 오창읍, 매포읍, 청천면, 금왕, 송정동(봉명동), 사천동, 문화동, 용암동, 복대동]
			, 서울 : [노원구, 화랑로, 관악구, 강남구, 서초구, 은평구, 도산대로, 서대문구, 마포구, 강남대로, 신촌로, 송파구, 강서구, 강동구, 공항대로, 천호대로, 구로구, 금천구, 영등포구, 영등포로, 강북구, 동작구, 양천구, 동작대로 중앙차로, 종로, 중구, 용산구, 한강대로, 광진구, 종로구, 성동구, 강변북로, 청계천로, 중랑구, 동대문구, 홍릉로, 성북구, 정릉로, 도봉구]
			, 전북 : [부안군, 요촌동, 새만금, 삼천동, 팔복동, 금암동, 신풍동(군산), 소룡동, 개정동, 남중동, 팔봉동, 모현동, 연지동, 죽항동, 고창읍, 운암면, 중앙동(전주)]
			, 경기 : [신원동, 호계동, 안양2동, 철산동, 소하동, 고잔동, 원시동, 본오동, 원곡동, 부곡동1, 대부동, 호수동, 중앙대로(고잔동), 별양동, 과천동, 교문동, 동구동, 소사본동, 내동, 중2동, 부곡3동, 고천동, 일동면사무소, 정왕동, 시화산단, 대야동, 금곡동, 단대동, 수내동, 성남대로(모란역), 복정동, 운중동, 상대원동, 의정부동, 의정부1동, 안양6동, 부림동, 파주, 신풍동, 인계동, 광교동, 영통동, 천천동, 경수대로(동수원), 고색동, 대왕판교로(백현동), 오정동, 산본동, 송내대로(중동), 오산동, 신장동, 수지, 남양읍, 기흥, 향남, 중부대로(구갈동), 운정, 설성면, 창전동, 백석읍, 관인면, 보산동, 선단동, 봉산동, 사우동, 고촌읍, 여주, 통진읍, 연천, 당동, 오남읍, 가평, 양평, 비전동, 안중, 평택항, 금촌동, 행신동, 식사동, 백마로(마두역), 경안동, 김량장동]
			, 충남 : [청양읍, 배방읍, 금산읍, 대천2동, 홍성읍, 태안읍, 공주, 부여읍, 논산, 이원면, 예산군, 독곶리, 동문동, 난지도리, 송산면, 모종동, 파도리, 성황동, 백석동, 성성동, 사곡면]
			, 부산 : [기장읍, 용수리, 수정동, 부곡동, 광안동, 대신동, 명장동, 대연동, 학장동, 덕천동, 청룡동, 좌동, 장림동, 대저동, 녹산동, 연산동, 광복동, 초량동, 태종대, 전포동, 온천동]
			, 강원 : [북평면, 간성읍, 치악산, 중앙로, 석사동, 방산면, 중앙동(원주), 명륜동, 옥천동, 천곡동, 남양동1]
			, 경북 : [장흥동, 장량동, 대도동, 대송면, 3공단, 안계면, 태하리, 성건동, 문당동, 남문동, 공단동, 원평동, 형곡동, 4공단, 휴천동, 중방동, 지품면, 화북면, 상주시]
			, 대전 : [읍내동, 문평동, 문창동, 구성동, 노은동, 대흥동1, 성남동1, 정림동, 둔산동, 월평동]
			, 세종 : [신흥동, 아름동]
			, 제주 : [성산읍, 이도동, 연동, 동홍동, 고산리]
			, 대구 : [노원동, 신암동, 태전동, 만촌동, 호림동, 현풍면, 수창동, 지산동, 서호동, 이현동, 평리동, 대명동, 이곡동]
			, 인천 : [석남, 송해, 동춘, 운서, 송현, 논현, 원당, 신흥, 송림, 구월동, 숭의, 석바위, 부평역, 연희, 검단, 계산, 고잔, 석모리, 덕적도, 백령도]
			, 전남 : [용당동, 부흥동, 광무동, 월내동, 문수동, 여천동(여수), 덕충동, 장천동, 연향동, 순천만, 호두리, 중동, 태인동, 진상면, 광양읍, 나불리, 송단리]
			, 경남 : [상봉동, 대안동, 상대동, 명서동, 웅남동, 가음정동, 용지동, 회원동, 봉암동, 내일동, 무전동, 대산면, 북부동, 웅상읍, 남상면, 반송로, 사파동, 경화동, 하동읍, 동상동, 삼방동, 장유동, 저구리, 아주동, 사천읍]
			, 광주 : [두암동, 운암동, 건국동, 송정1동, 오선동, 주월동, 서석동, 농성동, 치평동]
		*/
		
		StringBuffer sb = new StringBuffer();
		Gson gson = new Gson();
		final String jsonPath = "C:/Developer/Server/apache-tomcat-9.0.0.M26 STS/wtpwebapps/Lumi/resources/data/json/station.json"
				, jsonRealPath = "C:/Developer/WorkSpace/Spring/Lumi/src/main/webapp/resources/data/json/station.json";
		try {
			////////////////////////////////////////////////////////////////
			BufferedReader in = new BufferedReader(new FileReader(jsonPath));
			String s;
			while ((s = in.readLine()) != null) {
				// System.out.println(s);
				sb.append(s);
			}
			in.close();

			System.out.println(sb.toString());
			DataStorage.stationModel = gson.fromJson(sb.toString(), StationModel.class);
			System.out.println(DataStorage.stationModel);

			String listData = "@ 울산 : [여천동(울산), 야음동, 삼산동, 신정2동, 신정동, 덕신리, 무거동, 효문동, 대송동, 성남동, 부곡동(울산), 약사동, 화산리, 상남리, 농소동, 삼남면]\r\n"
					+ "			@ 충북 : [진천읍, 옥천읍, 호암동, 칠금동, 장락동, 오창읍, 매포읍, 청천면, 금왕, 송정동(봉명동), 사천동, 문화동, 용암동, 복대동]\r\n"
					+ "			@ 서울 : [노원구, 화랑로, 관악구, 강남구, 서초구, 은평구, 도산대로, 서대문구, 마포구, 강남대로, 신촌로, 송파구, 강서구, 강동구, 공항대로, 천호대로, 구로구, 금천구, 영등포구, 영등포로, 강북구, 동작구, 양천구, 동작대로 중앙차로, 종로, 중구, 용산구, 한강대로, 광진구, 종로구, 성동구, 강변북로, 청계천로, 중랑구, 동대문구, 홍릉로, 성북구, 정릉로, 도봉구]\r\n"
					+ "			@ 전북 : [부안군, 요촌동, 새만금, 삼천동, 팔복동, 금암동, 신풍동(군산), 소룡동, 개정동, 남중동, 팔봉동, 모현동, 연지동, 죽항동, 고창읍, 운암면, 중앙동(전주)]\r\n"
					+ "			@ 경기 : [신원동, 호계동, 안양2동, 철산동, 소하동, 고잔동, 원시동, 본오동, 원곡동, 부곡동1, 대부동, 호수동, 중앙대로(고잔동), 별양동, 과천동, 교문동, 동구동, 소사본동, 내동, 중2동, 부곡3동, 고천동, 일동면사무소, 정왕동, 시화산단, 대야동, 금곡동, 단대동, 수내동, 성남대로(모란역), 복정동, 운중동, 상대원동, 의정부동, 의정부1동, 안양6동, 부림동, 파주, 신풍동, 인계동, 광교동, 영통동, 천천동, 경수대로(동수원), 고색동, 대왕판교로(백현동), 오정동, 산본동, 송내대로(중동), 오산동, 신장동, 수지, 남양읍, 기흥, 향남, 중부대로(구갈동), 운정, 설성면, 창전동, 백석읍, 관인면, 보산동, 선단동, 봉산동, 사우동, 고촌읍, 여주, 통진읍, 연천, 당동, 오남읍, 가평, 양평, 비전동, 안중, 평택항, 금촌동, 행신동, 식사동, 백마로(마두역), 경안동, 김량장동]\r\n"
					+ "			@ 충남 : [청양읍, 배방읍, 금산읍, 대천2동, 홍성읍, 태안읍, 공주, 부여읍, 논산, 이원면, 예산군, 독곶리, 동문동, 난지도리, 송산면, 모종동, 파도리, 성황동, 백석동, 성성동, 사곡면]\r\n"
					+ "			@ 부산 : [기장읍, 용수리, 수정동, 부곡동, 광안동, 대신동, 명장동, 대연동, 학장동, 덕천동, 청룡동, 좌동, 장림동, 대저동, 녹산동, 연산동, 광복동, 초량동, 태종대, 전포동, 온천동]\r\n"
					+ "			@ 강원 : [북평면, 간성읍, 치악산, 중앙로, 석사동, 방산면, 중앙동(원주), 명륜동, 옥천동, 천곡동, 남양동1]\r\n"
					+ "			@ 경북 : [장흥동, 장량동, 대도동, 대송면, 3공단, 안계면, 태하리, 성건동, 문당동, 남문동, 공단동, 원평동, 형곡동, 4공단, 휴천동, 중방동, 지품면, 화북면, 상주시]\r\n"
					+ "			@ 대전 : [읍내동, 문평동, 문창동, 구성동, 노은동, 대흥동1, 성남동1, 정림동, 둔산동, 월평동]\r\n"
					+ "			@ 세종 : [신흥동, 아름동]\r\n" + "			@ 제주 : [성산읍, 이도동, 연동, 동홍동, 고산리]\r\n"
					+ "			@ 대구 : [노원동, 신암동, 태전동, 만촌동, 호림동, 현풍면, 수창동, 지산동, 서호동, 이현동, 평리동, 대명동, 이곡동]\r\n"
					+ "			@ 인천 : [석남, 송해, 동춘, 운서, 송현, 논현, 원당, 신흥, 송림, 구월동, 숭의, 석바위, 부평역, 연희, 검단, 계산, 고잔, 석모리, 덕적도, 백령도]\r\n"
					+ "			@ 전남 : [용당동, 부흥동, 광무동, 월내동, 문수동, 여천동(여수), 덕충동, 장천동, 연향동, 순천만, 호두리, 중동, 태인동, 진상면, 광양읍, 나불리, 송단리]\r\n"
					+ "			@ 경남 : [상봉동, 대안동, 상대동, 명서동, 웅남동, 가음정동, 용지동, 회원동, 봉암동, 내일동, 무전동, 대산면, 북부동, 웅상읍, 남상면, 반송로, 사파동, 경화동, 하동읍, 동상동, 삼방동, 장유동, 저구리, 아주동, 사천읍]\r\n" + 
				"			@ 광주 : [두암동, 운암동, 건국동, 송정1동, 오선동, 주월동, 서석동, 농성동, 치평동]";
		System.out.println(listData.trim());
		StringTokenizer token = new StringTokenizer(listData, "@", false);
		HashMap<String, List<String>> dataMap = new HashMap<String,List<String>>();
		while(token.hasMoreTokens()) {
			String r = token.nextToken().trim();
			String[] r2 = r.split(":");
			String r3 = r2[1].replaceAll("[\\[\\]\\s]", "");
			// System.out.println(r3);
			// List<String> list = Arrays.asList(r3.split(","));
			// System.out.println(list);
//			dataMap.put(r2[0].trim(), list);
			
			for(StationItem stationItem : DataStorage.stationModel.getList())
				if(stationItem.getValue().equals(r2[0].trim()))
					stationItem.setStationList(Arrays.asList(r3.split(",")));
		}
		 System.out.println(DataStorage.stationModel);
		 BufferedWriter bufferdWriter = new BufferedWriter(new FileWriter(jsonRealPath));
		 bufferdWriter.write(gson.toJson(DataStorage.stationModel));
		 bufferdWriter.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// System.exit(1);
		}
	}

	public class MsrList{
		List<MsrItem> list;
		
		@Override
		public String toString() {
			return "MsrList [list=" + StringUtil.createString("list", list)+ "]";
		}

		public class MsrItem{
			public String addr, stationName;

			@Override
			public String toString() {
				return "MsrItem [addr=" + addr + ", stationName=" + stationName + "]";
			}
			
		}
	}
}
