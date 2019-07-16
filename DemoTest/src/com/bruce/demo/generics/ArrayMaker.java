package com.bruce.demo.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
	private Class<T> kind;

	protected ArrayMaker(Class<T> kind) {
		this.kind = kind;
		
	}
	
	@SuppressWarnings("unchecked")
	T[] create(int size){
		//return (T[]) Array.newInstance(kind, size);
		Object[] arr =  new Object[size];
		Object a = null;
		try {
			a = kind.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i< arr.length; i++){
			arr[i] = a;
		}
		return (T[]) arr;
		
	}
	
	public static void main(String[] args) {
		ArrayMaker<Generators> maker = new ArrayMaker<Generators>(Generators.class);
		Generators[] array = maker.create(9);
		System.out.println(Arrays.toString(array));
	}
}
