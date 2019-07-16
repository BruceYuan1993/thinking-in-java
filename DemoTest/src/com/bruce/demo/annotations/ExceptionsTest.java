package com.bruce.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionsTest {
	Class<? extends Exception>[] value();
}

class Sample3{
	@ExceptionsTest({NullPointerException.class,IndexOutOfBoundsException.class})
	public static void doublyBad() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.addAll(5, null);
	}
}
