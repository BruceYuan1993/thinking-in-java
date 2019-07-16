package com.bruce.demo.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
	private T[] array;
	
	public GenericArrayWithTypeToken(Class<T> type, int size){
		array = (T[]) Array.newInstance(type, size);
		System.out.println(array.getClass().getComponentType());
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){
		return array;
	}
	
	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class,10);
		gai.put(0, new Integer(10));
		System.out.println(gai.get(0));
		
		Integer[] ia = gai.rep();
//		Object[] oa = gai.rep();
//		System.out.println(oa[0]);
//		Integer a = (Integer) oa[0];
//		System.out.println(a);
	}
	
}
