package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class CovariantArrays {
	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		try {
			fruit[2] = new Fruit();
			fruit[3] = new Orange();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
//		List<Fruit> flist = new ArrayList<Apple>();
//		ArrayList<Fruit> flist1 = new ArrayList<Apple>();
		
		Number[] na = new Integer[10];
		
		//List<Number> nl = new ArrayList<Integer>();
		
		List<? extends Number> nl = new ArrayList<Integer>();
		//nl.add(Integer.valueOf(1));
		
	}
}
