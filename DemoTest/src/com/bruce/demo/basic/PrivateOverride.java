package com.bruce.demo.basic;


public class PrivateOverride {
	Derived derived = new Derived();
	
	public PrivateOverride(){
		System.out.println("PrivateOverride");
	}
	private void f(){
		System.out.println("private f()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrivateOverride po = new PrivateOverride();
		//po.f();
	}

}

class Derived {
	public void f(){
		System.out.println("private f()");
	}
	public Derived(){
		System.out.println("Derived");
	}
	
}
