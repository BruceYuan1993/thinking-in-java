package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class TwoTuple<A,B> {
	public final A first;
	public final B second;
	public TwoTuple(A a, B b){
		this.first = a;
		this.second = b;
	}
	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("a");
		TwoTuple<Integer,List<String>> a = new TwoTuple<Integer, List<String>>(1, s) ;
		s.add("b");
		System.out.println(a);
		//a.second = new ArrayList<String>();
	}
}
