package com.bruce.demo.collection;

import java.util.Iterator;

import com.bruce.demo.generics.Generator;

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer>{
	private int size = 9;
	private int number = 1;
	private char letter = 'A';		
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer, String>(number++, String.valueOf(letter++));
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
		};
	}
	
}

public class MapDataTest {
	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
	}
}
