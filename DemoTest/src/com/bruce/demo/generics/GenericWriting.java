package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
	static <T> void writeExact(List<T> list, T item){
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruits = new ArrayList<Fruit>();
	static{
		fruits.add(new Apple());
	}
	static void f1(){
		writeExact(apples, new Apple());
		writeExact(fruits, new Apple());
	}
	
	static <T> void writeWithWildcard(List<? super T> list, T item){
		list.add(item);
	}
	
	static void f2(){
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(apples, new Jonathan());
		//writeWithWildcard(apples, new Fruit());
		writeWithWildcard(fruits, new Apple());
		writeWithWildcard(fruits, new Orange());
		writeWithWildcard(fruits, new Fruit());
	}
	
	public static void main(String[] args) {
		f1();
	}
}
