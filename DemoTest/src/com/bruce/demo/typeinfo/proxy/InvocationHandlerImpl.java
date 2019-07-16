package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler{
	private Object proxy;
	public InvocationHandlerImpl(Object proxy) {
		super();
		this.proxy = proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Call proxy");
		// TODO Auto-generated method stub
		return method.invoke(proxy, args);
	}

}
