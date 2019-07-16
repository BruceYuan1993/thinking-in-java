package com.bruce.demo.collection;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Countries {
	public static final String[][] DATA = {
		{"1","1"},
		{"2","2"},
		{"3","3"},
		{"4","4"},
		{"5","5"},
		{"6","6"},
		{"7","7"},
		{"8","8"},
		{"9","9"},
		{"10","10"},
	};
	
	private static class FlyweightMap extends AbstractMap<String, String>{
		
		private static class Entry implements java.util.Map.Entry<String, String>{
			int index;
			public Entry(int index) {
				// TODO Auto-generated constructor stub
				this.index = index;
			}
			
			@Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				return DATA[index][0].equals(obj);
			}

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}

			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return DATA[index][0].hashCode();
			}
		}
		
		static class EntrySet extends AbstractSet<Map.Entry<String, String>>{
			private int size;
			public EntrySet(int size) {
				// TODO Auto-generated constructor stub
				if (size < 0)
					this.size = 0;
				else if(size > DATA.length){
					this.size = DATA.length;
				}
				else {
					this.size = size;
				}
			}
			@Override
			public int size(){
				return size;
			}
			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}
			
			private class Iter implements Iterator<Map.Entry<String, String>>{
				private Entry entry = new Entry(-1);
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					
					return entry.index < size - 1;
				}

				@Override
				public java.util.Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return null;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					
				}
				
			}
			
		}
		
		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
