package com.bruce.demo.util;

import java.util.Random;

public class Enums {
	private static Random ran = new Random(47);
	
	public static <T extends Enum<T>> T random(Class<T> cls){
		return random(cls.getEnumConstants());
	}
	
	public static <T> T random(T[] values){
		return values[ran.nextInt(values.length)];
	}
}
