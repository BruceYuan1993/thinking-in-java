package com.bruce.demo.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCause, Class<?> cl)
	{
		for(Method method : cl.getDeclaredMethods()){
			UseCase useCase = method.getAnnotation(UseCase.class);
			if (useCase != null) {
				System.out.println("Found use case:" + useCase.id() +" " + useCase.description());
				useCause.remove(new Integer(useCase.id()));
			}
		}
		for (int i : useCause) {
			System.out.println("Warning: Missing use case - "+ i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> useCauses = new ArrayList<Integer>();
		Collections.addAll(useCauses, 47,48,49,50);
		trackUseCases(useCauses, PasswordUtils.class);
	}

}
