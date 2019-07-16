package com.bruce.demo.exception;

public class NeverCaught {
	static void f(){
		throw new NullPointerException("From f");
	}
	static void g(){
		f();
	}
	
	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("caught!");
		}
		
	}
}
