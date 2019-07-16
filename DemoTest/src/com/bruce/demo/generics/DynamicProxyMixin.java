package com.bruce.demo.generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler{
	Map<String, Object> delegatesByMethod;
	
	public MixinProxy(TwoTuple<Object, Class<?>>...tuples) {
		delegatesByMethod = new HashMap<String, Object>();
		for (TwoTuple<Object, Class<?>> twoTuple : tuples) {
			for (Method method : twoTuple.second.getMethods()) {
				String methodName = method.getName();
				if (!delegatesByMethod.containsKey(methodName)){
					delegatesByMethod.put(methodName, twoTuple.first);
				}
			}
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object delegate = delegatesByMethod.get(method.getName());
		return method.invoke(delegate, args);
	}
	
	
	public static Object newInstance(TwoTuple...tuples ){
		Class[] interfaces = new Class[tuples.length];
		for (int i = 0; i < interfaces.length; i++) {
			interfaces[i] = (Class) tuples[i].second;
		}
		ClassLoader classLoader = tuples[0].getClass().getClassLoader();
		return Proxy.newProxyInstance(classLoader, interfaces, new MixinProxy(tuples));
	}
}

public class DynamicProxyMixin {
	public static void main(String[] args) {
		Object o = MixinProxy.newInstance(Tuple.tuple(new BasicImpl(), Basic.class), 
				Tuple.tuple(new TimeStampedImpl(), TimeStamped.class),
				Tuple.tuple(new SerialNumberedImpl(), SerialNumbered.class)
		);
		
		Basic b = (Basic)o;
		TimeStamped t = (TimeStamped) o;
		SerialNumbered s = (SerialNumbered) o;
		b.set("Gello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}
}
