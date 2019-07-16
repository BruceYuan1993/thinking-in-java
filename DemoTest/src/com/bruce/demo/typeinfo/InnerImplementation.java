package com.bruce.demo.typeinfo;

import java.lang.reflect.Method;

import com.bruce.demo.typeinfo.interfaces.A;

class InnerA{
	private static class C implements A{

		@Override
		public void f() {
			// TODO Auto-generated method stub
			System.out.println("Public C.f()");
		}
		
		public void g(){
			System.out.println("Public C.g()");
		}
		void u(){
			System.out.println("package C.u()");
		}
		protected void v(){
			System.out.println("protected C.v()");
		}
		private void w(){
			System.out.println("private C.w()");
		}
	}
	public static A makeA(){
		return new C();
	}
}

public class InnerImplementation {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		A a = InnerA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		for (Method method : a.getClass().getDeclaredMethods()) {
			System.out.println("@@@@@@@@@@@@@@@@@@@");
			System.out.println(method.getName() + method.getParameterTypes());
		}
		//if (a instanceof C)
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	
	}

}
