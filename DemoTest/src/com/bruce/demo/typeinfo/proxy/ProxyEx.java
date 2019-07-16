package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyEx extends Proxy{
	private static Map<String, String> cacheMap = new HashMap<String, String>();
	protected ProxyEx(InvocationHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}
	public static Class<?> getProxyClass(ClassLoader loader, 
            Class<?>... interfaces){
		List<Method> methods = new ArrayList<Method>();
		
		for (Class<?> cls : interfaces) {
			for (Method method : cls.getMethods()) {
				int modifiers = method.getModifiers();
				if (Modifier.isPublic(modifiers)||Modifier.isProtected(modifiers)
						&& !Modifier.isStatic(modifiers)) {
					methods.add(method);
				}
			}
		}
		
		
	}
	
	private static String getConstructor() {
		String constructorTemplate = "public &Constructor(java.lang.reflect.InvocationHandler handler) "
			+"\n {" +
			"\n super(&Parameters);" +
			"\n this.handler = handler;"+
     		"\n}";
		
	}
	private static String getMethodFullInfo(Method method){
		String declareTemplate = "&Modifiers &ReturnType &MethodName(&Parameters) &Throwables";
		String bodyTemplate = "&Declaration &Body";
		
		String declare = declareTemplate.replace("&Modifiers", getMethodModifiers(method))
			.replace("&ReturnType", getMethodReturnType(method))
			.replace("&MethodName", method.getName())
			.replace("&Parameters", getMethodParameters(method))
			.replace("&Throwables", getMethodThrowables(method));
		
		String result = bodyTemplate.replace("&Declaration", declare)
			.replace("&Body", getMethodEntity(method));
		cacheMap.put(declare, result);
		return result;
	}
	
	private static String getMethodModifiers(Method method){
		return Modifier.toString(method.getModifiers());
	}
	
	private static String getMethodReturnType(Method method){
		return getTypeHelper(method.getReturnType());
	}
	
	private static String getMethodParameters(Method method){
		String result = "";
		int i = 0;
		Class<?>[] paras = method.getParameterTypes();
		for (Class<?> p: paras) {
			result += getTypeHelper(p);
			result += " ";
			result += "p";
			result += i;
			if (++i < paras.length) {
				result += ", ";
			}
		}
		return result;
	}
	
	private static String getMethodThrowables(Method method){
		String result = "";
		int i = 0;
		Class<?>[] exs = method.getExceptionTypes();
		for (Class<?> p: exs) {
			if (result.length() == 0) {
				result += "throws ";
			}
			result += getTypeHelper(p);
			if (++i < exs.length) {
				result += ", ";
			}
		}
		return result;
	}
	
	private static String getMethodEntity(Method method){
		String methodTemplate = "\n{"+
		"\n	java.lang.reflect.Method method = null;"+
		"\n	try{"+
		"\n	method = &Class.getMethod(\"&MethodName\",&ParameterTypes)"+
		"\n	} catch(Exception) {"+
		"\n	}" +
		"\n Object r = null" +
		"\n try{"+
		"\n r = handler.invoke(this, method, &ParameterValues)" +
		"\n } &Exceptions" +
		"\n &Return";
		
		String result = methodTemplate.replace("&Class", method.getDeclaringClass().getName()+".class")
						.replace("&MethodName", method.getName())
						.replace("&ParameterTypes", getMethodParameterTypesHelper(method))
						.replace("&ParameterValues", getMethodParameterValuesHelper(method))
						.replace("&Exceptions", getMethodParameterThrowablesHelper(method))
						.replace("&Return", getMethodReturnHelper(method));
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
	
	private static String getMethodParameterTypesHelper(Method method){
		String result = "new Class<?>[]{";
		int i = 0;
		Class<?>[] paras = method.getParameterTypes();
		for (Class<?> p: paras) {
			result += getTypeHelper(p);
			result += ".class";
			if (++i < paras.length) {
				result += ", ";
			}
		}
		result += "}";
		return result;
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
	
	private static Field[] getFields(Class<?> c){
		Field[] fields = null;
		if (c == java.lang.Object.class){
			fields = c.getDeclaredFields();
		}else {
			Field[] fields1 = getFields(c.getSuperclass());
			Field[] fields2 = c.getDeclaredFields();
			fields = new Field[fields1.length + fields2.length];
			System.arraycopy(fields1, 0, fields, 0, fields1.length);
			System.arraycopy(fields2, 0, fields, fields1.length, fields2.length);
		}
		//fieldsMap.put(c, fields);
	    return fields;
	}
	
	private synchronized void sync(java.lang.Class clazz, boolean toStub){
		if (handler instanceof InvocationHandlerEx){
			
		}
	}
}
