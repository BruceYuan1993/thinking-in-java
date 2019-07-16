package com.bruce.demo.generics;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class StackForEJ<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
//	@SuppressWarnings("unchecked")
//	public StackForEJ(){
//		//elements = new E[DEFAULT_INITIAL_CAPACITY];
//		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
//	}
	
	public StackForEJ(){
	//elements = new E[DEFAULT_INITIAL_CAPACITY];
	elements = new Object[DEFAULT_INITIAL_CAPACITY];
}
	
	public void push(E e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop(){
		if (size == 0){
			throw new EmptyStackException();
		}
		E result = (E) elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if (elements.length == size){
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public void pushAll(Iterable<E> src){
		for (E e : src) {
			push(e);
		}
	}
	
	public static void swap(List<?> list, int i, int j){
		swapHelper(list, i ,j);
	}
	
	private static <E> void swapHelper(List<E> list, int i, int j){
		list.set(i, list.set(j, list.get(i)));
	}
}
