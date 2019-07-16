package com.bruce.demo.basic;

interface Inter{
	String str = "123";
	default void df(){
		System.out.println("Inter.default()");
	}
	
	static void sf(){
		System.out.println("Inter.static()");
	}
}

class MyInter implements Inter{
	
}
public class Java8Interface {
	public static void main(String[] args) {
		Inter myInter = new MyInter();
		System.out.println(Inter.str);
		myInter.df();
		Inter.sf();
	}
}
