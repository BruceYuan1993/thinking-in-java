package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class SimulatorProxy implements Simulator {
	private InvocationHandler handler;
	
	public SimulatorProxy(InvocationHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public short simulate(int arg1, long arg2, String arg3) throws Throwable {
		// TODO Auto-generated method stub
		//
		String currentMethodName = "simulate";
		Method method = Simulator.class.getMethod(currentMethodName, new Class<?>[]{int.class,long.class,String.class});
		
		Object object = handler.invoke(this, method, new Object[]{arg1,arg2,arg3});
		
		return ((Short)object).shortValue();
	}

}
