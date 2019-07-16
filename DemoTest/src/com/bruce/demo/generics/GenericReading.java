package com.bruce.demo.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
	static <T> T readExact(List<T> list){
		return list.get(0);
	}
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruits = Arrays.asList(new Fruit());
	
	static void f1(){
		Apple apple = readExact(apples);
		Fruit fruit = readExact(fruits);
		fruit = readExact(apples);
	}
	
	static class Reader<T>{
		T readExact(List<T> list){
			return list.get(0);
		}
	}
	
	static void f2(){
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		fruitReader.readExact(fruits);
		//fruitReader.readExact(apples);
	}
	
	static class CovariantReader<T>{
		T readCovariant(List<? extends T> list){
			return list.get(0);
		}
	}
	
	static void f3(){
//		Reader<Fruit> fruitReader = new Reader<Fruit>();
//		fruitReader.readCovariant(apples);
	}
	
	class Generic1<T> {
		void f(T item){
			
		}
	} 
	
	class Generic2<T> {
		T f(){
			return null;
		}
	}
//	static <? super T> void ff1(){
//		
//	}
}
