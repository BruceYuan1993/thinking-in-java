package com.bruce.demo.generics;

import java.util.Map;

public class LimitsOfInference {
	
	public static void f(Map<String, Integer> m){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f(New.map());
		f(New.<String,Integer>map());
		Map<String, Integer> m = New.map();
		f(m);
	}

}
