package com.bruce.demo.generics;

public class ArrarOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// gia = (Generic<Integer>[]) new Object[SIZE];
		gia = (Generic<Integer>[])new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		System.out.println(gia[0]);
//		gia[1] = new Object();
//		gia[2] = new Generic<Double>();
	}

}
