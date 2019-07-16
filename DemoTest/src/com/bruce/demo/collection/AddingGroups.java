package com.bruce.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		collection.addAll(Arrays.asList(moreInts));
		Collections.addAll(collection, 11,12,13,14,15);
		Collections.addAll(collection, moreInts);
		
//		List<Integer> list= Arrays.asList(1,2,3,4,5);
//		list.set(1, 99);
//		list.add(10);
		
		Foo foo = new Bar();
		System.out.println(foo.getI());
		
		
		LinkedList<Integer> list = new LinkedList<Integer>();
	}
}


class Foo {
	int i = 100;
	int getI(){
		return i;
	}
}

class Bar extends Foo {
	int i = 1;
	
	int getI(){
		return i;
	}
}