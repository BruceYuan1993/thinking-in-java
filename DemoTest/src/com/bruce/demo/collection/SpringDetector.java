package com.bruce.demo.collection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


class Groundhog{
	protected int number;

	public Groundhog(int number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "Groundhog #" + number;
	}
}

class Groundhog2 extends Groundhog{

	public Groundhog2(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Groundhog2 && (((Groundhog2)obj).number == number);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
	
	
}

class Prediction{
	private static Random random = new Random(47);
	private boolean shadow = random.nextDouble() > 0.5;
	@Override
	public String toString() {
		if (shadow)
			return "six more weeks of winter";
		else 
			return "Early Spring";
	}
}

public class SpringDetector {
	public static <T extends Groundhog> void 
		detectSpring(Class<T> type) throws Exception{
		Constructor<T> constructor = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		for (int i = 0; i < 10; i++) {
			map.put(constructor.newInstance(i), new Prediction());
		}
		System.out.println("Map = " + map);
		
		Groundhog gh = constructor.newInstance(3);
		System.out.println("Looking up prediction for "+ gh.toString());
		
		if (map.containsKey(gh)) {
			System.out.println(map.get(gh));
		}else {
			System.out.println("Key not found:" + gh);
		}
	}
	
	public static void main(String[] args) throws Exception {
		//SpringDetector.detectSpring(Groundhog.class);
		SpringDetector.detectSpring(Groundhog2.class);
	}
}
