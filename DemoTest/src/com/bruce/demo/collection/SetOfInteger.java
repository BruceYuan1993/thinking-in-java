package com.bruce.demo.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetOfInteger {
	public static void main(String[] args) {
		Random random = new Random(47);
		Set<Integer> intset = new HashSet<Integer>();
//		Set<Integer> intset = new TreeSet<Integer>();
//		for (int i = 0; i < 10000; i++) {
//			intset.add(random.nextInt(30));
//		}
		
		Set<String> iSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		System.out.println(intset);
	}
}
