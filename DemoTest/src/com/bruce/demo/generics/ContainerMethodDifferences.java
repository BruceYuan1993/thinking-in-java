package com.bruce.demo.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainerMethodDifferences {
	static void interfaces(Class<?> type){
		System.out.println("Interfaces in "+type.getSimpleName()+": ");
		List<String> result = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}
	static Set<String> methodSet(Class<?> type){
		Set<String> result = new TreeSet<String>();
		for (Method method : type.getMethods()) {
			result.add(method.getName());
		}
		return result;		
	}
	static Set<String> object = methodSet(Object.class);
	static
	{
		object.add("clone");
	}
	
	static void difference(Class<?> superSet, Class<?> subSet){
		System.out.println(superSet.getSimpleName() + " extends " + subSet.getSimpleName() + ", adds: ");
		Set<String> comp = Sets.differenct(methodSet(superSet), methodSet(subSet));
		comp.remove(object);
		System.out.println(comp);
		interfaces(superSet);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		difference(Set.class, Collection.class);
		difference(HashSet.class, Set.class);
		difference(LinkedHashSet.class, HashSet.class);
		difference(TreeSet.class, Set.class);
		difference(List.class, Collection.class);
		difference(ArrayList.class, List.class);
		difference(LinkedList.class, List.class);
		difference(Queue.class, List.class);
		difference(PriorityQueue.class, Queue.class);
		
		System.out.println("Map: " + methodSet(Map.class));
		difference(HashMap.class, Map.class);
		difference(LinkedHashMap.class, HashMap.class);
		difference(SortedMap.class, Map.class);
		difference(TreeMap.class, Map.class);
	}
}
