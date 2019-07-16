package com.bruce.demo.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics<T> {

	/**
	 * @param args
	 */
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>[] ls;
		
		ls = (List<String>[])(new List[10]);
		ls[0] = new ArrayList<String>();
		//ls[0] = new ArrayList<Object>();
		
		//new 
		
		
	}
	@SuppressWarnings("unchecked")
	void f()
	{
		T[] a ;
		// a = new T[10];
		a = (T[]) new Object[10];
		
		//a[0] =  new Object();
	}
}
