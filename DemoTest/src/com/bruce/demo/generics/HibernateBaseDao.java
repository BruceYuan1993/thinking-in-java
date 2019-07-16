package com.bruce.demo.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class HibernateBaseDao<T> {
	Class entityClass;
	public T get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HibernateBaseDao(){
		Type gen = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)gen).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	
	public Class getEntityClass(){
		return entityClass;
	}
	
	public static void main(String[] args) {
		System.out.println("11111111111111");
		HibernateBaseDao<Coffee> ac = new HibernateBaseDao<Coffee>(){};
		System.out.println(ac.getEntityClass().getCanonicalName());
	}

}

