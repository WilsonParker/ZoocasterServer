package test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import com.graction.lumi.model.db.FineDustTable;
import com.graction.lumi.util.parser.DataParser;

public class TestRefParameter {
	@Test
	public void test() {
		// fail("Not yet implemented");
		DataParser parser = DataParser.getInstance();
		ArrayList<Method> methods = new ArrayList<Method>();
		for(Method method : FineDustTable.class.getDeclaredMethods()) {
			if(method.getName().toUpperCase().contains("SET"))
				methods.add(method);
		}
		for (Method method : methods) {
			System.out.println("method name : " + method.getName());
			for(int i=0; i<method.getParameterCount(); i++) {
				System.out.println(method.getParameters()[i].getType().getName());
				System.out.println(parser.convertData("1", method.getParameters()[i].getType().getName()));
				System.out.println("method param count : "+method.getTypeParameters().length);
			}
		}
	}

}
