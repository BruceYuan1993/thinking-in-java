package com.bruce.demo.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunExceptionTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getMethods()) {
//			if(m.isAnnotationPresent(ExceptionTest.class))
//			{
//				tests++;
//				try{
//					m.invoke(null);
//					System.out.printf("Test %s failed: no exception%n",m);;
//				}catch (InvocationTargetException wrappedExc) {
//					// TODO: handle exception
//					Throwable exc = wrappedExc.getCause();
//					Class<? extends Exception> excTypeClass = 
//						m.getAnnotation(ExceptionTest.class).value();
//					if(excTypeClass.isInstance(exc)){
//						passed++;
//					}else{
//						System.out.printf("Test %s field: expected %s ,got %s%n",m,excTypeClass.getName(),exc);
//					}
//				}catch(Exception exc){
//					System.out.println("INVALID @Test: "+m);
//				}
//			}
			ExceptionTest anno = m.getAnnotation(ExceptionTest.class);
			if(anno != null){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n",m);;
				}catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception> excTypeClass = 
						anno.value();
					if(excTypeClass.isInstance(exc)){
						passed++;
					}else{
						System.out.printf("Test %s field: expected %s ,got %s%n",m,excTypeClass.getName(),exc);
					}
				}
			}
		}
		System.out.printf("Passed : %d ,Total: %d%n",passed,tests);
	}

}
