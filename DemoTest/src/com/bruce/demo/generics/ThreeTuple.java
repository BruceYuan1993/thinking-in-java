package com.bruce.demo.generics;

public class ThreeTuple<A,B,C> extends TwoTuple<A, B>{
	public final C third;
	public ThreeTuple(A a, B b, C c) {
		
		super(a, b);
		// TODO Auto-generated constructor stub
		this.third = c;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + first + ", " + second +", " + third + ")";
	}

}
