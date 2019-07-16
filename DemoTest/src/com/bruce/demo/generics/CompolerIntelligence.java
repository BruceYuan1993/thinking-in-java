package com.bruce.demo.generics;

import java.util.Arrays;
import java.util.List;

public class CompolerIntelligence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<? extends Fruit> fList = Arrays.asList(new Apple(), new Orange());
		Apple a = (Apple) fList.get(0);
		fList.contains(new Apple());
		fList.indexOf(new Apple());
		
		//fList.
	}

}
