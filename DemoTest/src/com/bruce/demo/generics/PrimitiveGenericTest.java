package com.bruce.demo.generics;

class FArray{
	public static <T> T[] fill(T[] a, T item){
		for (int i = 0; i < a.length; i++) {
			a[i] = item;
		}
		return a;
	}
}
public class PrimitiveGenericTest {
	public static void main(String[] args) {
		String[] strings = FArray.fill(new String[7], "abc");
		for(String s: strings){
			System.out.println(s);
		}
		
		Integer[] integers = FArray.fill(new Integer[7], 0);
		for(int a: integers){
			System.out.println(a);
		}
		
//		int[] b = FArray.fill(new Integer[7], 0);
//		int[] b = new Integer[7];
	}
}
