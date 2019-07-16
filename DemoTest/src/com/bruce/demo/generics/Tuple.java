package com.bruce.demo.generics;

public class Tuple {
	public static <A,B> TwoTuple<A, B> tuple(A a, B b){
		return new TwoTuple<A, B>(a, b);
	}
	
	public static <A,B,C> ThreeTuple<A, B, C> tuple(A a, B b, C c){
		return new ThreeTuple<A, B, C>(a, b, c);
	}
	
	static TwoTuple<String,Integer> f(){
		return tuple("1", 1);
	}
	
	static TwoTuple f2(){
		return tuple("2", 1);
	}
	
	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		ttsi = f2();
		System.out.println(ttsi);
	}
}
