package com.bruce.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random random = new Random(47);
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println(l1);
		Collections.shuffle(l1, random);
		System.out.println(l1);
		System.out.println(Arrays.toString(ia));
		System.out.println("-----------------------------");
		List<Integer> l2 = Arrays.asList(ia);
		System.out.println(l2);
		Collections.shuffle(l2, random);
		System.out.println(l2);
		System.out.println(Arrays.toString(ia));
		
		
	}
	
	
}
