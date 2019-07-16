package com.bruce.demo.basic;

public class DotThis {
	void f(){
		System.out.println("Dotthis.f()");
	}
	public class Inner{
		public DotThis outer(){
			return DotThis.this;
		}
	}
	public Inner inner(){
		return new Inner();
	}
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner inner = dt.new Inner();
	}
}
