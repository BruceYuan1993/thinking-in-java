package com.bruce.demo.array;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {
	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3},
				{7, 8, 9, 6}
		};
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		
		System.out.println(Arrays.deepToString(a));
	}
}
