package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
	public static <T> List<T> makeList(T...args){
		List<T> result = new ArrayList<T>();
		for (T t : args) {
			result.add(t);
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> ls = makeList("a");
		System.out.println(ls);
		ls = makeList("a","b","c");
		System.out.println(ls);
		ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
}
