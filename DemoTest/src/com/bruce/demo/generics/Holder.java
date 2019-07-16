package com.bruce.demo.generics;

public class Holder<T> {
	private T value;
	public Holder(){
		
	}
	public Holder(T value) {
		super();
		this.value = value;
	}
	public void set(T val){
		this.value = val;
	}
	
	public T get(){
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return value.equals(obj);
	}
	
	public static void main(String[] args) {
		Holder<Apple> apple = new Holder<Apple>(new Apple());
		Apple d = apple.get();
		apple.set(d);
		
		//Holder<Fruit> fruit = apple;
		
		Holder<? extends Fruit> fruit = apple;
		Fruit p = fruit.get();
		d = (Apple) fruit.get();
		try {
			Orange o = (Orange) fruit.get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println(fruit.equals(d));
	}
}
