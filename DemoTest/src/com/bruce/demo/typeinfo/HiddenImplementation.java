package com.bruce.demo.typeinfo;

import java.lang.reflect.Method;

import com.bruce.demo.typeinfo.interfaces.A;
import com.bruce.demo.typeinfo.interfaces.HiddenC;

public class HiddenImplementation {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		for (Method method : a.getClass().getDeclaredMethods()) {
			System.out.println("@@@@@@@@@@@@@@@@@@@");
			System.out.println(method.getName() + method.getParameterTypes());
		}
		//if (a instanceof C)
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
	static void callHiddenMethod(Object a, String methodname) throws Exception{
		Method method = a.getClass().getDeclaredMethod(methodname);
		method.setAccessible(true);
		method.invoke(a);
	}
}
