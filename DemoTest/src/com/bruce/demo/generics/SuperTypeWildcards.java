package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards<T extends Fruit> {
	static void writeTo(List<? extends Fruit> apples){
//		apples.add(new Apple());
//		apples.add(new Jonathan());
//		apples.add(new Fruit());
//		apples.add(new Object());
//		Fruit fruit = (Fruit) apples.get(1);
		List<Number> aList = new ArrayList<Number>();
		aList.add(Integer.valueOf(1));
	}
}
