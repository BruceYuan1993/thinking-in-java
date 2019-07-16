package com.bruce.demo.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getMethods()) {
			if(m.isAnnotationPresent(Test.class))
			{
				tests++;
				try{
					m.invoke(null);
					passed++;
				}catch (InvocationTargetException wrappedExc) {
					// TODO: handle exception
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				}catch(Exception exc){
					System.out.println("INVALID @Test: "+m);
				}
			}
		}
		System.out.printf("Passed : %d ,Total: %d%n",passed,tests);
	}

}
