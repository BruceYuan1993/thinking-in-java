package com.bruce.demo.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunExceptionsTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getMethods()) {
			ExceptionsTest anno = m.getAnnotation(ExceptionsTest.class);
			if(anno != null){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n",m);;
				}catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception>[] excTypeClass = 
						anno.value();
					boolean isHit = false;
					for (Class<? extends Exception> exception  : excTypeClass) {
						if(exception.isInstance(exc)){
							passed++;
							isHit =true;
							break;
						}
					}
					if(!isHit)
					{
						System.out.printf("Test %s Failed : %s %n",m,exc);
					}
				}
					
				}
			
		}
		System.out.printf("Passed : %d ,Total: %d%n",passed,tests);
	}

}
