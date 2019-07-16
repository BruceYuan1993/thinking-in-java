package com.bruce.demo.typeinfo;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Patrrt14_2 {
	static void printExtendTree(Object o){
		Class<?> c = o.getClass();
		while (c != null){
			System.out.println(c.getName());
			for(Field f:c.getDeclaredFields()){
				System.out.println(f.getGenericType() +"----"+ f.getName());
			}
			System.out.println("********************");
			c = c.getSuperclass();
		}
	}
	static void isObject(Object o){
		System.out.println(o.getClass());
	}
	public static void main(String[] args) {
		printExtendTree(new ArrayList());
		Class<?> intClass = int.class;
		Class<?> integerClass = Integer.class;
		Class<?> integerType = Integer.TYPE;
		System.out.println(intClass);
		System.out.println(integerClass);
		System.out.println(intClass == integerType);
		System.out.println(intClass == integerClass);
		System.out.println(integerType == integerClass);
	}
}
