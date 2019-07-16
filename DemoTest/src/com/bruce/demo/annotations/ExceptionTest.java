package com.bruce.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception> value();
}
class Sample2{
	 @ExceptionTest(value = ArithmeticException.class)
	 public static void m1(){
		 int i = 0;
		 i = i/i;
	 }
	 
	 @ExceptionTest(ArithmeticException.class)
	 public static void m2(){
		 int[] a = new int[0];
		 int i = a[0];
	 }
	 
	 @ExceptionTest(ArithmeticException.class)
	 public static void m3(){
		 
	 }
}
