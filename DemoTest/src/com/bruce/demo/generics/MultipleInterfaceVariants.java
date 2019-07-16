package com.bruce.demo.generics;

interface Payable<T>{}

class Empolyee implements Payable{};

class Hourly extends Empolyee implements Payable{}

public class MultipleInterfaceVariants {
	public static void main(String[] args) {
		Hourly hourly = new Hourly();
		System.out.println("11111");
	}
}
