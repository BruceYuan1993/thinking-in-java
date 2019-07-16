package com.bruce.demo.generics;

public class GenericArray<T> {
	private T[] array;
	
	public GenericArray(int size){
		array = (T[]) new Object[size];
		System.out.println(array.getClass().getComponentType());
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){
		return array;
	}
	
	
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		gai.put(0, new Integer(10));
		System.out.println(gai.get(0));
		
		//Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
		System.out.println(oa[0]);
		Integer a = (Integer) oa[0];
		System.out.println(a);
	}
}
