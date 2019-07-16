package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DynamicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object object = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{Interface1.class,Interface2.class}, new InvocationHandlerImpl(new NeedToProxy()));
		Object object2 = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{Interface2.class,Interface1.class}, new InvocationHandlerImpl(new NeedToProxy()));
		System.out.println("Package:"+ object.getClass().getPackage());
		System.out.println("Package:"+ object.getClass().getModifiers());
		System.out.println(Modifier.toString(object.getClass().getModifiers()));;
		System.out.println("Package:"+ object.getClass());
		System.out.println("Package:"+ object2.getClass());
	}
}
