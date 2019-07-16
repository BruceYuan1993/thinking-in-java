package com.bruce.demo.typeinfo;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;


public class Sample {
	private Sample instance;
	
	public void  setInstance(Object instance) {
		this.instance = (Sample) instance;
	}
	
	public static void main(String[] args) {
		 String classPath = "D:\\java\\workspace\\DemoTest\\bin";
		 FileSystemClassLoader classLoader1 = new FileSystemClassLoader(classPath); 
		 FileSystemClassLoader classLoader2 = new FileSystemClassLoader(classPath); 
		 String className = "com.bruce.demo.typeinfo.Sample";
		 try {
			 Class<?> class1 = classLoader1.loadClass(className);
			 Object obj1 = class1.newInstance();
			 Class<?> class2 = classLoader2.loadClass(className);
			 Object obj2 = class2.newInstance();
			 Method setMethod= class1.getMethod("setInstance", new Class<?>[]{Object.class});
			 System.out.println(class1.getClassLoader());
			 System.out.println(class2.getClassLoader().getParent());
			 setMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
