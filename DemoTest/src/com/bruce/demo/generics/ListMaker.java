package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
	List<T> create(){
		return new ArrayList<T>();
	}
	
	public static void main(String[] args) {
		ListMaker<String> s = new ListMaker<String>();
		List<String> ll = s.create();
	}
}
