package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TypeInfer {
	public static <T>  void onlyParameter(T t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
	public static <T>  T onlyReturn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static <T> T samePara(T a, T b){
		return a;
	}
	
	public static <T> void nosamePara(T[] a, T b){
		for (int i=0; i<a.length; i++){
			a[i] = b;
		}
	}
	
	public static <T> T nosameParaWithReturn(T a, T b){
		return b;
	}
	
	public static <T> void copy(Collection<T> b, T[] a){
		
	}
	
	public static <T> T copy(T[] a, Collection<T> b){
		return a[0];
	}
	
//	public static <T> T copy(T a, T b){
//		return a;
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nosamePara(new Integer[3], new Float(1.0));
		List<String> list = new ArrayList<String>();
		Integer[] array = new Integer[]{1,2,3};
//		copy(list,array);
//		System.out.println(copy(array,list).toString());
	}

}
