package test;
import org.junit.Test;

public class TestContains {

	@Test
	public void test() {
//		fail("Not yet implemented");
		String region = "경기도 안양시 만안구 안양5동"
				, match1 = "경기도"
				, match2 = "경기도 안양시"
				, match3 = "경기도 안양시 관양동"
				, match4 = "경기도 안양시 관양2동"
				, match5 = "경기도 안양시 안양5동"
				;
		
		System.out.println("1 : "+region.contains(match1));
		System.out.println("2 : "+region.contains(match2));
		System.out.println("3 : "+region.contains(match3));
		System.out.println("4 : "+region.contains(match4));
		System.out.println("5 : "+region.contains(match5));
		System.out.println("전라남도".contains("전남"));
		System.out.println("전남".contains("전라남도"));
	}

}
