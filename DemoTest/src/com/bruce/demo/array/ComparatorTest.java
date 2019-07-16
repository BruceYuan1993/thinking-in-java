package com.bruce.demo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import com.bruce.demo.generics.Generator;


class CompTypeComparator implements Comparator<CompType>{

	@Override
	public int compare(CompType o1, CompType o2) {
		// TODO Auto-generated method stub
		return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
	}
	
}

public class ComparatorTest {
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
		CompType a = new CompType(22, 22);
		System.out.println(Arrays.toString(c1));
		int loc1 = Arrays.binarySearch(c1, a);
		System.out.println("------>"+loc1);
		Arrays.sort(c1, new CompTypeComparator());
		
		int loc2 = Arrays.binarySearch(c1, a, new CompTypeComparator() );
		System.out.println("------>"+loc2);
		System.out.println(Arrays.toString(c1));
		
		
		
		//String.CASE_INSENSITIVE_ORDER
//		Arrays.binarySearch(a, key)
//		Arrays.s
	}
}
