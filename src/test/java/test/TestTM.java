package test;

import org.junit.Test;

import com.graction.lumi.util.gps.GeoPoint;
import com.graction.lumi.util.gps.GeoTrans;

public class TestTM {

	@Test
	public void test() {
//		fail("Not yet implemented");
		test1();
	}

	private void test1() {
		/*
		 *
		 * 서울 중구
		 * double x = 126.97796919999996
		 *		, y = 37.566535;
		 */
		double x = 126.7878014802915
				, y = 37.50343;
		GeoPoint in_pt = new GeoPoint(x, y);
		System.out.println("geo in : xGeo="  + in_pt.getX() + ", yGeo=" + in_pt.getY());
		GeoPoint tm_pt = GeoTrans.convert(GeoTrans.GEO, GeoTrans.TM, in_pt);
		System.out.println("tm : xTM=" + tm_pt.getX() + ", yTM=" + tm_pt.getY());
		GeoPoint katec_pt = GeoTrans.convert(GeoTrans.TM, GeoTrans.KATEC, tm_pt);
		System.out.println("katec : xKATEC=" + katec_pt.getX() + ", yKATEC=" + katec_pt.getY());
		GeoPoint out_pt = GeoTrans.convert(GeoTrans.KATEC, GeoTrans.GEO, katec_pt);
		System.out.println("geo out : xGeo=" + out_pt.getX() + ", yGeo=" + out_pt.getY());
		GeoPoint in2_pt = new GeoPoint(x, y);
		System.out.println("geo distance between (127,38) and (128,38) =" + GeoTrans.getDistancebyGeo(in_pt, in2_pt) + "km");

	}

}

// 서울 중구
// &tmX=197987.0070527366&tmY=451590.7846590439

// 경기도 부천
// &tmX=181170.00317764978&tmY=444608.24554923957

