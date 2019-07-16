package com.bruce.demo.generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> resultSet = new HashSet<T>(a);
		resultSet.addAll(b);
		return resultSet;
	}
	
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> resultSet = new HashSet<T>(a);
		resultSet.retainAll(b);
		return resultSet;
	}
	

	
	public static <T> Set<T> differenct(Set<T> a, Set<T> b){
		Set<T> resultSet = new HashSet<T>(a);
		resultSet.removeAll(b);
		return resultSet;
	}
	
	
	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return differenct(union(a, b), intersection(a, b));
	}
	
}
