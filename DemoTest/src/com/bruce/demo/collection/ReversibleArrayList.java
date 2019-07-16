package com.bruce.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<T> extends ArrayList<T> {
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
					int current = size() - 1; 
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return current > -1;
					}

					@Override
					public T next() {
						// TODO Auto-generated method stub
						return get(current--);
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub
						
					}
				};
			}
		};
		
	}
	
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList(
				"Tobe or not to be".split(" ")));
		
		for (String string : ral.reversed()) {
			System.out.println(string);
		}
	}
}
