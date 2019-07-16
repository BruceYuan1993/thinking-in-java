package com.bruce.demo.array;

import java.util.Arrays;

import com.bruce.demo.generics.New;

public class CopyingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[7];
		int[] j = new int[10];
		
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		
		System.out.println("i = " + Arrays.toString(i));
		System.out.println("j = " + Arrays.toString(j));
		
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j = " + Arrays.toString(j));
		
		
		
		Integer[] u = new Integer[10];
		Integer[] v = new Integer[5];
		
		Arrays.fill(u, new Integer(47));
		Arrays.fill(v, new Integer(230));
		
		System.out.println("u = " + Arrays.toString(u));
		System.out.println("v = " + Arrays.toString(v));
		
		System.arraycopy(v, 0, u, u.length/2, v.length);
		v[0] = new Integer(50);
		System.out.println("u = " + Arrays.toString(u));
		System.out.println("v = " + Arrays.toString(v));
		
		
	}

}
