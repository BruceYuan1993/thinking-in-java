package com.bruce.demo.typeinfo.interfaces;

class B implements A{

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("f");
	}
	
	public void g() {
		// TODO Auto-generated method stub
		System.out.println("g");
	}
	
}
public class InterfaceViolation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();
		a.f();
		System.out.println(a.getClass().getName());
		if ( a instanceof B)
			((B)a).g();
	}

}
