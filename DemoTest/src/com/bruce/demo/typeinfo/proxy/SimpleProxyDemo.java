package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import sun.misc.*;

interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("somethingElse " + arg);
	}
	
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy somethingElse "+ arg );
		proxied.somethingElse(arg);
	}
	
}

class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("**** proxy: " + proxy.getClass() +", method: "+ method+", args: "+args);
		if (args != null) {
			for(Object arg:args){
				System.out.println(" "+arg);
			}
			
		}
		return method.invoke(proxied, args);
	}
	
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
		System.out.println(System.getProperty("user.dir"));
//		consumer(new RealObject());
//		consumer(new SimpleProxy(new RealObject()));
		RealObject real = new RealObject();
		consumer(real);
		Interface proxy = 
			(Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class<?>[]{Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
	public static void generateProxyClassFile(){
		ProxyGenerator.generateProxyClass(arg0, arg1);
	}
}

