package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
	void doSomething();
}
interface MoreInterfaceTest{
	void doTest();
}

class RealObject1 implements Subject,MoreInterfaceTest{
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("RealObject call doSomething");
	}

	@Override
	public void doTest() {
		// TODO Auto-generated method stub
		System.out.println("***********************************");
	}
}

class ProxyHandler implements InvocationHandler{
	private Object proxied;
	
	ProxyHandler(Object proxied) {
		super();
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("proxy " + proxy.toString());
		System.out.println("proxy " + proxy.getClass().toString());
		return method.invoke(proxied, args);
	}
	
}

public class DynamicProxyDemo {
	public static void main(String[] args) {
		Subject subject = new RealObject1();
		//Proxy.
		Object object = Proxy.newProxyInstance(subject.getClass().getClassLoader(), new Class<?>[]{Subject.class,MoreInterfaceTest.class}, new ProxyHandler(subject));
		System.out.println("object instanceof Subject: "+ (object instanceof Subject));
		System.out.println("object instanceof MoreInterfaceTest: "+ (object instanceof MoreInterfaceTest));
		Subject s=(Subject)object;
		MoreInterfaceTest m = (MoreInterfaceTest) object;
		
		System.out.println("is isProxyClass "+Proxy.isProxyClass(s.getClass()));
		InvocationHandler h = Proxy.getInvocationHandler(s);
		System.out.println(h.getClass().toString());
		//Proxy.getProxyClass(loader, interfaces)
		s.doSomething();
		m.doTest();
		System.out.println("equals:"+object.equals(s));
		System.out.println("toString:"+object.toString());
		System.out.println("hashCode:"+object.hashCode());
		System.out.println("getClass:"+object.getClass());
		System.out.println("Package:"+ object.getClass().getPackage().getName());
		}
}
