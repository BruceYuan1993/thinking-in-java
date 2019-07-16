package com.bruce.demo.generics;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

interface Addable<T>{
	void add(T t);
}



public class Fill2 {
	public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size){
		for (int i = 0; i < size; i++) {
			try {
				addable.add(classToken.newInstance());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static <T> void fill(Addable<T> addable, Generator<T> generator, int size){
		for (int i = 0; i < size; i++) {
			try {
				addable.add(generator.next());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

class AddableCollectionAdapter<T> implements Addable<T>{
	private Collection<T> c;
	public AddableCollectionAdapter(Collection<T> c){
		this.c = c;
	}
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		c.add(t);
	}
	
	
	public T[] toArray(T[] a){
		if (a.length < 10){
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(null, 0, a.getClass());
			return result;
		}
		System.arraycopy(null, 0, a, 0, 10);
		if (a.length > 0)
			a[10] = null;
		return a;
	}
}

class Adapter{
	public static <T> Addable<T> collectionAdapter(Collection<T> c){
		if (c instanceof Collection<?>)
		{
			Collection<?> x = (Collection<?>)c;
		}
		return new AddableCollectionAdapter<T>(c);
	}
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		super.add(t);
	}
	
}

class Fill2Test{
	public static void main(String[] args) {
		List<Coffee> carrier = new ArrayList<Coffee>();
		Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
		
		Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
		
		for(Coffee c : carrier)
			System.out.println(c);
		
		System.out.println("---------------------------------------");
		
		AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
		Fill2.fill(coffeeQueue, Mocha.class, 4);
		Fill2.fill(coffeeQueue, Latte.class, 1);
		
		
		for(Coffee c : coffeeQueue)
			System.out.println(c);
		
		Object object = List.class;
		//object = List<String>.class;
		if (object instanceof List){
			
		}
		
		//Arrays.asList(42)
		
//		if (object instanceof List<String>){
//			
//		}
		
		//List<String>[] sLists = new List<String>[1];
		List<?>[] lists = new List<?>[1];
		FileInputStream fileInputStreame
		FilterInputStream
	}
}
