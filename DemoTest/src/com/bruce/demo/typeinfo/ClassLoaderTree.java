package com.bruce.demo.typeinfo;

import java.util.ArrayList;
import java.util.List;

import com.bruce.demo.enumerated.Demo;

public class ClassLoaderTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
		Object a = new Integer(0);
		ClassLoader obj = a.getClass().getClassLoader();
		System.out.println(obj);
		
		List<String> l = new ArrayList<String>();
		System.out.println(l.getClass().getClassLoader());
		
		System.out.println(Demo.class.getClassLoader());
	}

}
