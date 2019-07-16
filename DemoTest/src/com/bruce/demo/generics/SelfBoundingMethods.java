package com.bruce.demo.generics;



public class SelfBoundingMethods {
	static <T extends SelfBounded<T>> T f(T arg){
		return arg.set(arg).get();
	}  
	
	public static void main(String[] args) {
		C c = f(new C());
		
	}
}
