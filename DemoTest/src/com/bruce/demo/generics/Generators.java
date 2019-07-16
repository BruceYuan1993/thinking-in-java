package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Generators {
	public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int count)
	{
		for (int i = 0; i < count; i++) {
			collection.add(generator.next());
		}
		return collection;
	}
	
	public static <T> List<T> fill(List<T> collection, Generator<T> generator, int count)
	{
		for (int i = 0; i < count; i++) {
			collection.add(generator.next());
		}
		return collection;
	}
	
	
	public static <T> LinkedList<T> fill(LinkedList<T> collection, Generator<T> generator, int count)
	{
		for (int i = 0; i < count; i++) {
			collection.add(generator.next());
		}
		System.out.println("---------------------LinkedList");
		return collection;
	}
	
	public static void main(String[] args) {
		Collection<Coffee> o = fill(new ArrayList<Coffee>(), new CoffeeeGenerator(), 4);
		System.out.println(o);
		
		Collection<Integer> i = fill(new LinkedList<Integer>(), new Fibonacci(), 12);
		System.out.println(i);
		
	}
}
