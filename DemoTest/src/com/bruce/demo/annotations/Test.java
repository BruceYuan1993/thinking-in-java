package com.bruce.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
@UseCase
public @interface Test {
}

class Sample{
	@Test
	public static void m1(){}
	public static void m2(){}
	@Test
	public static void m3(){
		throw new RuntimeException("Boom");
	}
	public static void m4(){}
	@Test
	public void m5(){}
	public static void m6(){}
	@Test
	public static void m7(){
		throw new RuntimeException("CRASH");
	}
	public static void m8(){}
	
}