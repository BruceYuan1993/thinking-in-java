package com.bruce.demo.io;

import java.util.Arrays;
import java.util.Collection;


public class PPrint {
	public static String pFormat(Collection<?> c){
		if (c.size() == 0)
			return "[]";
		StringBuilder result = new StringBuilder("[");
		for (Object elem : c) {
			if (c.size() != 1)
				result.append("\n");
			result.append(elem);
		}
		if (c.size() != 1)
			result.append("\n");
		result.append("]");
		return result.toString();
	}
	
	public static void pprint(Collection<?> c){
		System.out.println(pFormat(c));
	}
	
	public static void pprint(Object[] c){
		System.out.println(Arrays.asList(c));
	}
}
