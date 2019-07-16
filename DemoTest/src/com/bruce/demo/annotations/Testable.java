package com.bruce.demo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@UseCase
public class Testable {
	@UseCase
	 private int id = 5;
	
	@UseCase
	private Testable(@UseCase int id) {
		this.id = id;
	}
	@UseCase
	private void execute(@UseCase @Test int i,int q){
		@UseCase
		int j = i * i;
		System.out.println("Executing....");
	}
	@UseCase
	void testExecute(){
		execute(0,1);
	}
	public static void test(Class<?> class1) throws Exception{
		System.out.println(class1.isAnnotationPresent(UseCase.class));
		Constructor<?>[] constructor = class1.getDeclaredConstructors();
		System.out.println(constructor[0].isAnnotationPresent(UseCase.class));
		Field field = class1.getDeclaredField("id");
		UseCase useCase = field.getAnnotation(UseCase.class);
		if (useCase != null) {
			System.out.println("got field");
		}
		
		Method method = class1.getDeclaredMethod("execute", new Class<?>[]{int.class,int.class});
		useCase = method.getAnnotation(UseCase.class);
		if (useCase != null) {
			System.out.println("got Method");
		}
		
		Annotation[][] annotations = method.getParameterAnnotations();
		System.out.println(annotations.length);
		for (Annotation[] ann : annotations) {
			System.out.println(ann.length);
			System.out.println(ann);
			for (Annotation an : ann) {
				System.out.println(an);
			}
		}
		
		
	}
	
	public static void testForType(Class<?> class1){
		System.out.println(class1.isAnnotationPresent(UseCase.class));
	}
	
	public static void testForInherited(Class<?> class1) throws Exception{
		System.out.println(class1.isAnnotationPresent(UseCase.class));
		Field field = class1.getDeclaredField("id");
		if (field == null) {
			System.out.println( " id is null");
		}
	    field = class1.getDeclaredField("name");
		if (field == null) {
			System.out.println( " name is null");
		}
		Method method = class1.getDeclaredMethod("printTest", new Class<?>[]{int.class});
		if (method == null) {
			System.out.println( " method is null");
		}
	}
	public static void main(String[] args) throws Exception {
//		test(Testable.class);
//		testForType(Ido.class);
//		testForType(Colo.class);
//		testForType(Test.class);
		testForInherited(SubObject.class);
	}
	@UseCase
	public enum Colo{
		RED,GREEN
	}
	@UseCase
	public interface Ido{
		
	}
	
}

