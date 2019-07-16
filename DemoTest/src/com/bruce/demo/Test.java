package com.bruce.demo;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import com.bruce.demo.typeinfo.proxy.InvocationHandlerImpl;
import com.bruce.demo.typeinfo.proxy.SimulatorProxy;

class A{
	void w(){
		System.out.println("A");
	}
}

class B extends A{
	void w(){
		System.out.println("B");
	}
}

class C extends B{
	
}
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A c = new C();
		c.w();
		SimulatorProxy proxy = new SimulatorProxy(new InvocationHandlerImpl(null));
		for (Method m : SimulatorProxy.class.getMethods()) {
//			System.out.println("-------------");
//			String result = null;
//			int i = 0;
//			Class<?>[] paras = m.getParameterTypes();
//			for (Class<?> p: paras) {
//				result += p.getCanonicalName();
//				result += " ";
//				result += "p";
//				result += i;
//				if (++i < paras.length) {
//					result += ", ";
//				}
//			}
//			System.out.println(result);
			
//			String result = "";
//			int i = 0;
//			Class<?>[] exs = m.getExceptionTypes();
//			for (Class<?> p: exs) {
//				if (result.length() == 0) {
//					result += "throws ";
//				}
//				result += p.getCanonicalName();
//				if (++i < exs.length) {
//					result += ", ";
//				}
//			}
//			System.out.println(result);
//			System.out.println(SimulatorProxy.class.getName());
			//System.out.println(m.getParameterTypes().);
			System.out.println(getMethodParameterThrowablesHelper(m));
		}
//		String[] array = new String[]{"11","22","33"};
//		System.out.println(array.getClass());
		
		
	}
	
	private static String getMethodParameterTypesHelper(Method method){
		String result = "new Class<?>[]{";
		int i = 0;
		Class<?>[] paras = method.getParameterTypes();
		for (Class<?> p: paras) {
			System.out.println(getTypeHelper(p));
			result += getTypeHelper(p);
			result += ".class";
			if (++i < paras.length) {
				result += ", ";
			}
		}
		result += "}";
		return result;
	}
	
	private static String getTypeHelper(Class<?> cls){
		if (cls.isArray())
		{
			Class<?> arrayClass = cls.getComponentType();
			return getTypeHelper(arrayClass) + "[]";
		}else {
			return cls.getName();
		}
	}
	
	private static String getMethodParameterValuesHelper(Method method){
		String result = "new Object[]{";
		int i = 0;
		Class<?>[] paras = method.getParameterTypes();
		for (Class<?> p: paras) {
			result += "p";
			result += i;
			if (++i < paras.length) {
				result += ", ";
			}
		}
		result += "}";
		return result;
	}
	
	
	private static String getMethodParameterThrowablesHelper(Method method) {
		// TODO Auto-generated method stub
		String result = "";
		int i = 0;
		Class<?>[] exs = method.getExceptionTypes();
		boolean isHasThrowable = false;
		for (Class<?> p: exs) {
			String exp = " e"+i;
			result += "catch(";
			result += getTypeHelper(p);
			result += exp;
			result += ") \n { \n \t throw ";
			result += exp;
			result += "\n}";
			if (Throwable.class == p) {
				isHasThrowable = true;
			}
		}
		if (!isHasThrowable) {
			result += "catch(Throwable e) { ";
			result += "\n \t throw new UndeclaredThrowableException(e); ";
			result += "\n }";
		}
		return result;
	}
	
	private static String getMethodReturnHelper(Method method) {
		// TODO Auto-generated method stub	
		String result = "";
		String returnType = getTypeHelper(method.getReturnType());
		if (!"void".equalsIgnoreCase(returnType)) {
			result = "return (";
			result += returnType;
			result += ")r;";
		}		
		return result;
	}
}
