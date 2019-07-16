package com.bruce.demo.generics;

import java.util.Iterator;
import java.util.Random;


public class CoffeeeGenerator implements Generator<Coffee>, Iterable<Coffee>{
	private Class[] types = {Latte.class , Mocha.class, Cappuccino.class, Americano.class, Breve.class};
	private static Random random = new Random(47);
	private int size = 0;
	protected CoffeeeGenerator(int size) {
		this.size = size;
	}
	
	public CoffeeeGenerator(){}
	@Override
	public Coffee next() {
		// TODO Auto-generated method stub
		try {
			return (Coffee) types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}
	@Override
	public Iterator<Coffee> iterator() {
		// TODO Auto-generated method stub
		return new CoffeeIterator();
	}
	class CoffeeIterator implements Iterator<Coffee>{
	    int count = size;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count > 0;
		}

		@Override
		public Coffee next() {
			// TODO Auto-generated method stub
			count--;
			return CoffeeeGenerator.this.next();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
	
	public static void main(String[] args) {
		CoffeeeGenerator generator = new CoffeeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(generator.next());
		}
		
		for (Coffee c : new CoffeeeGenerator(5)) {
			System.out.println(c);
		}
	}
}
