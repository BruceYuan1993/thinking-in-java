package com.bruce.demo.generics;

import java.util.ArrayList;

public class TupleList<A,B,C> extends ArrayList<ThreeTuple<A, B, C>> {
	public static void main(String[] args) {
		TupleList<Amphibian, String, Integer> tl = new TupleList<Amphibian, String, Integer>();
		tl.add(TupleTest.h());
		tl.add(TupleTest.h());
		for(ThreeTuple<Amphibian, String, Integer> a:tl){
			System.out.println(a);
		}
	}
}
