package com.bruce.demo.enumerated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ImmutableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list);
		
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		System.out.println(unmodifiableList);
		
		List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a","b","c"));
		
		System.out.println(unmodifiableList1);
		
		String temp = unmodifiableList.get(0);
		System.out.println("unmodifiableList[0]---" + temp);
		
		
		list.add("baby");
		System.out.println("list added a item,then list---> :" + list);
		System.out.println("list added a item,then unmodifiableList---> :" + unmodifiableList);
		
		unmodifiableList.add("d");
		
		System.out.println("unmodifiableList added a item,then list---> :" + list);
		System.out.println("unmodifiableList added a item,then unmodifiableList---> :" + unmodifiableList);
	
		unmodifiableList.add("1");
	}

}
