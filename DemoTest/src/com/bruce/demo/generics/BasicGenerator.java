package com.bruce.demo.generics;

import java.util.Random;

public class BasicGenerator<T> implements Generator<T>{
	private Class<? extends T>[] types;
	private Random random = new Random(47);
	private BasicGenerator(Class<? extends T>... args){
		types = args;
	}
	@Override
	public T next() {
		// TODO Auto-generated method stub
		try {
			return types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static <T>  Generator<T> create(Class<? extends T>... args){
		return new BasicGenerator<T>(args);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Generator<Coffee> coffees = BasicGenerator.create(Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class);
		for (int i=0;i<5;i++) {
			System.out.println(coffees.next());
		}
	}
}
