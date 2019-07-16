package com.bruce.demo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.bruce.demo.generics.Generator;

public class Reverse {
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
		
		System.out.println(Arrays.toString(c1));
		Arrays.sort(c1, Collections.reverseOrder());

		System.out.println(Arrays.toString(c1));
	}
}
