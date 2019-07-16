package com.bruce.demo.collection;

import java.util.WeakHashMap;


class Element{
	private String ident;

	public Element(String ident) {
		this.ident = ident;
	}

	@Override
	public String toString() {
		return "Element [ident=" + ident + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Element && ident.equals(((Element)obj).ident);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Finalizing mapping " + ident );
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return ident.hashCode();
	}
	
}

class Key extends Element{

	public Key(String ident) {
		super(ident);
		// TODO Auto-generated constructor stub
	}
	
}
class Value extends Element{

	public Value(String ident) {
		super(ident);
		// TODO Auto-generated constructor stub
	}
	
}

public class CaninicalMapping {
	public static void main(String[] args) throws Exception {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
		for (int i = 0; i < size; i++) {
			Key key = new Key(Integer.toString(i));
			Value value = new Value(Integer.toString(i));
			if (i % 3 == 0){
				keys[i] = key;
			}
			map.put(key, value);
		}
		System.gc();
		//map.get(" ");
		Thread.currentThread().sleep(3000);
		System.out.println(map.size());
	}
}
