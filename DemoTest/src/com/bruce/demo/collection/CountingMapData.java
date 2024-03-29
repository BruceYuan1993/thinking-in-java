package com.bruce.demo.collection;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String>{
	private int size;
	private static String[] chars = "A B C D E F G H I G K L M N O P Q R S T U V W X Y Z".split(" "); 
	public CountingMapData(int size){
		if (size < 0)
		{
			this.size = 0;
		}else {
			this.size = size;
		}
	}
	private static class Entry implements Map.Entry<Integer, String>{
		int index;
		Entry(int index){
			this.index = index;
		}
		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return chars[index % chars.length] + Integer.toString(index / chars.length);
		}

		@Override
		public String setValue(String value) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).equals(obj);
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).hashCode();
		}
		
	}
	@Override
	public Set<Map.Entry<Integer, String>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer,String>>();
		for (int i = 0; i < size; i++) {
			entries.add(new Entry(i));
		}
		return entries;
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}
}
