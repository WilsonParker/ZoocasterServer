package test;

import java.io.File;

import org.junit.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.graction.lumi.model.xml.weather.WeatherData;
import com.graction.lumi.util.parser.XmlParserForSAX;

public class TestParsing {

	@Test
	public void test() {
//		fail("Not yet implemented");
		test2();
	}
	
	private void test1() {
		String path = "C:/Developer/WorkSpace/Spring/Lumi/src/main/webapp/resources/data/xml/"
				, name = "WeatherData3.xml";
		XmlParserForSAX.getInstance().parseXmlToObject(WeatherData.class, path, name);
	}
	
	private void test2() {
		String path = "C:/Developer/WorkSpace/Spring/Lumi/src/main/webapp/resources/data/xml/"
				, name = "TestData.xml";
		XmlMapper xmlMapper = new XmlMapper();
		File file = new File(path+name);
		try {
//			TestData data = xmlMapper.readValue(file, TestData.class);
//			System.out.println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
