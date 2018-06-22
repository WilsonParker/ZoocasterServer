package test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.graction.lumi.util.StringUtil;

public class TestEncoding {

	@Test
	public void test() {
		// fail("Not yet implemented");
		test2();
	}

	private void test1() {
		String s = "ê´ì£¼ê´ì­ì";
		try {
			System.out.println(new String(s.getBytes("utf-8")));
			System.out.println(new String(s.getBytes(), "utf-8"));
			System.out.println(new String(s.getBytes("iso-8859-1"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test2() {
		System.out.println("test2");
		String s = "B0HQD8ZLlW2LNyCNkg3pjKg5IyY%2F2oJ%2Fm3b92Q%2FUuqW75TlkLEVOJxNzRHUEKtH%2F4i%2BSl9DFQRbCpQstzRdNjg%3D%3D";
		try {
			System.out.println(StringUtil.urlEncoding(s));
			System.out.println(StringUtil.urlEncoding(s, StringUtil.ENCODING_ASCCI));
			System.out.println(StringUtil.urlEncoding(s, StringUtil.ENCODING_UTF_8));
			System.out.println(StringUtil.urlEncoding(s, StringUtil.ENCODING_ISO_8859_1));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
