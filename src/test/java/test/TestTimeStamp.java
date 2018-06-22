package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class TestTimeStamp {

	@Test
	public void test() {
//		fail("Not yet implemented");
		String time = "2017.11.21 12:11";
		String[] times = "2017.11.21 00:00 - 2017.11.21 23:59".split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		try {
			System.out.println(sdf.parse(sdf.format(System.currentTimeMillis())).getTime());
			System.out.println(sdf.parse(time).getTime());
			System.out.println(sdf.parse(times[0].trim()).getTime());
			System.out.println(sdf.parse(times[1].trim()).getTime());
			System.out.println(sdf.format(System.currentTimeMillis()));
			System.out.println(sdf.format(sdf.parse(time).getTime()));
			System.out.println(sdf.format(sdf.parse(times[0].trim()).getTime()));
			System.out.println(sdf.format(sdf.parse(times[1].trim()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
