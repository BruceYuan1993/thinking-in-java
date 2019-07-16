package com.bruce.demo.array;

import java.util.Arrays;

public class FillingArrays {
	public static void main(String[] args) {
		int size = 6;
		int[] a5 = new int[size];
		
		Arrays.fill(a5, 19);
		System.out.println(Arrays.toString(a5));
		Arrays.fill(a5, 3, 5, 8);
		System.out.println(Arrays.toString(a5));
	}
}
