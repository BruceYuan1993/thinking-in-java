package com.bruce.demo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utilities {
	static List<String> list = Arrays.asList("one Two three Four five Six one".split(" "));
	public static void main(String[] args) {
		System.out.println(list);
		List<String> list1 = Collections.singletonList("Four");
		//list1.add("five");
		System.out.println("list disjoint four : " + Collections.disjoint(list, list1) );
		System.out.println("max : " + Collections.max(list));
		System.out.println("min : " + Collections.min(list));
		System.out.println("max (r): " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println("min (r): " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
		List<String> subList = Arrays.asList("Four five Six".split(" "));
		System.out.println("indexof : " + Collections.indexOfSubList(list, subList));
		System.out.println("lastIndexOfSubList : " + Collections.lastIndexOfSubList(list, subList));
		Collections.replaceAll(list, "one", "yo");
		System.out.println("Replace " + list);
		Collections.reverse(list);
		System.out.println("reverse " + list);
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		System.out.println("copy " + list);
		Collections.swap(list, 0, list.size() - 1);
		System.out.println("swap " + list);
		Collections.shuffle(list, new Random(47));
		System.out.println("shuffle " + list);
		Collections.fill(list, "pop");
		System.out.println("fill " + list);
		System.out.println("frequency " + Collections.frequency(list, "pop"));
		//Coll
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
