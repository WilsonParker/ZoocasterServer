package com.graction.lumi.util.format;

/*
 * 숫자 포맷 관련 Class
 */
public class NumberFormatManager {
	private static final NumberFormatManager instatnce = new NumberFormatManager();

	public static NumberFormatManager getInstatnce() {
		return instatnce;
	}
	
	public double round(double d, int r) {
		double pow = Math.pow(10 ,r);
		return Math.round((d * pow)) / pow;
	}
	
	public double round(String s, int r) {
		return round(Double.parseDouble(s), r);
	}
	

}
