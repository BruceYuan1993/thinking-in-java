package com.bruce.demo.generics;

import java.util.HashMap;
import java.util.Map;

class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
	private Class<T> kind;
	private Map<String, Class<?>> mapping;
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
		mapping = new HashMap<String, Class<?>>();
	}
	
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
	
	public void addType(String typename, Class<?> kind){
		if (typename != null && kind != null){
			if (mapping.containsKey(typename)){
				System.out.println(typename +" has been existed!");
				return;
			}
			mapping.put(typename, kind);
		}
	}
	
	public Object create(String typename){
		Object result = null;
		if (typename != null){
			Class<?> cls = mapping.get(typename);
			if (cls != null) {
				try {
					result = cls.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Can't find " + typename);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		
		ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
	}
}
