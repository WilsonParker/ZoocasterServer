package test;
import org.junit.Test;

public class TestMatches {
	private static final String REG = "(^([가-힇])*( |)((([가-힣]+(도))( |)[가-힣]+(시|군|구)( |)[가-힣]+(구))|(([가-힣]+(시))( |)[가-힣]+(시|군|구)))+(( |)([가-힣\\d\\(\\)_-]))*)"
			, REG_DO = "([가-힇]+(도)$)"
			, REG_SI = "([가-힇]+(시)$)"
			, REG_SIGUGUN= "([가-힇]+(시|구|군)$)"
			, REG_GU= "([가-힇]+(구)$)"
			, REG2 = "(^([가-힇])*( |)([가-힣]+(시|군|구))( |)([가-힣]+(구))*(( |)[가-힣\\d\\(\\)])*)"
			;
	@Test
	public void test() {
//		fail("Not yet implemented");
		test2();
	}

	private void test1() {
		String region = "대한민국 경기도 안양시 만안구 안양5동"
				;
		System.out.println(region.matches(REG));
		System.out.println(region.matches(REG_DO));
		System.out.println(region.matches(REG_SI));
		System.out.println(region.matches(REG_SIGUGUN));
		System.out.println(region.matches(REG_GU));
	}
	
	// 경기 부천시 소사구 경인옛로 72 (소사어울림마당 소향관)소사어울림마당
	private void test2() {
		try {
			
//		String region = "경기 부천시 소사구";
		String region = "경기 부천시 소사구 경인옛로 72 (소사어울림마당 소향관)소사어울림마당";
		String region2 = "경기 부천시 소사구 경인옛로 72";
		System.out.println(region.matches(REG));
		System.out.println(region2.matches(REG));
		System.out.println(region.matches(REG2));
		System.out.println(region2.matches(REG2));
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
