package test;
import java.util.StringTokenizer;

import org.junit.Test;

public class TestToken {

	@Test
	public void test() {
//		fail("Not yet implemented");
		String s1 = "대한민국 서울특별시 중구 정동 5-5",
				s2 = "서울특별시 성동구,서울특별시 성북구,서울특별시 종로구,서울특별시 영등포구,서울특별시 강동구,서울특별시 마포구,서울특별시 광진구,서울특별시 구로구,서울특별시 양천구,서울특별시 중구,충청남도,충청북도",
				delim = ","
				;
		System.out.printf("contains // %s : %s\n",s1,s2);
		StringTokenizer tokenizer = new StringTokenizer(s2, delim);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken(); 
			System.out.printf("@ %s : %s / %s\n",s1,token,s1.contains(token));
		}
	}

}
