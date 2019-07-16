package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Apple>();
		
//		flist.add(new Apple());
//		flist.add(new Fruit());
//		flist.add(new Orange());
//		
//		flist.add(new Object());
		
		flist.add(null);
		
		Fruit fruit = flist.get(0);
//		Apple fruit = flist.get(0);
	}
}
