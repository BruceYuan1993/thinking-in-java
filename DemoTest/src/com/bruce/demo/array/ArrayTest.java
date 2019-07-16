package com.bruce.demo.array;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[4];
		//a.length;
		System.out.println(a.getClass());
		
		String[] s = new String[4];
		//a.length;
		System.out.println(s.getClass());
		
		String[][] s2 = new String[4][2];
		//a.length;
		System.out.println(s2.getClass());
		
		Object obj = a;
		int[] b = (int[]) obj;
		
		if (obj instanceof int[]){
			System.out.println("true");
		}
		
		Object[] objects = s;
		System.out.println(s.getClass().getSuperclass().getName());
		
		int[][] arr = new int[3][];
		System.out.println(arr.length);
		System.out.println(arr[1].length);
	}

}
