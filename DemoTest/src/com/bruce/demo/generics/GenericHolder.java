package com.bruce.demo.generics;

public class GenericHolder<T extends Number> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		GenericHolder<Integer> holder = new GenericHolder<Integer>();
		holder.setObj(1);
		Integer i = holder.getObj();
	}
}
