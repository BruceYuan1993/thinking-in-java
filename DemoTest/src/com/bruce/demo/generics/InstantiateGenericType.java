package com.bruce.demo.generics;

class Emplyeee{}

class ClassAsFactory<T>{
	T x;
	public ClassAsFactory(Class<T> kind){
		try {
			x = kind.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Emplyeee> fe = new ClassAsFactory<Emplyeee>(Emplyeee.class);
		System.out.println("fe successed");
		
		try {
			ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fi failed!");
		}
	}
	
}
