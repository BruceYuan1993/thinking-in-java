package com.bruce.demo.array;

import java.util.Arrays;
import java.util.Random;

import com.bruce.demo.generics.Generator;
import com.bruce.demo.generics.New;

public class CompType implements Comparable<CompType>{
	int i,j;
	
	private static int count = 1;
	
	
	
	public CompType(int i, int j) {
		this.i = i;
		this.j = j;
	}



	@Override
	public String toString() {
		String resultString = "[i=" + i + ", j=" + j + "]";
		if (count++ % 3 == 0){
			resultString += "\n";
		}
		return resultString;
	}



	@Override
	public int compareTo(CompType o) {
		// TODO Auto-generated method stub
		return (i<o.i ? -1 : (i == o.i ? 0 : 1));
	}
	private static Random random = new Random(47);
	public static Generator<CompType> generator = new Generator<CompType>() {

		@Override
		public CompType next() {
			// TODO Auto-generated method stub
			return new CompType(random.nextInt(100), random.nextInt(100));
		}
	};
	
	
	public static void main(String[] args) {
		CompType[] c1 = new CompType[12];
		for (int i = 0; i < c1.length; i++) {
			c1[i] = generator.next();
		}
		
		
		CompType a = new CompType(10, 0);
		int loc1 = Arrays.binarySearch(c1, a);
		System.out.println("------>"+loc1);
		
		
		
		System.out.println(Arrays.toString(c1));
		Arrays.sort(c1);
		
		int loc2 = Arrays.binarySearch(c1, a);
		System.out.println("------>"+loc2);

		System.out.println(Arrays.toString(c1));
	}
}
