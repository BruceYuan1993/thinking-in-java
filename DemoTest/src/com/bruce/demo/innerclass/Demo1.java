package com.bruce.demo.innerclass;



public class Demo1 {
	public static void main(String... args) {
		int a = 300;
		Integer b = Integer.valueOf(300);
		
		Integer c = new Integer(300);
		System.out.println("int == valueOf:" + (a == b));
		System.out.println("int equals valueOf:" + (b.equals(a)));
		System.out.println("int == new Intefer:" + (a == c));
		System.out.println("int equals new Intefer:" + (c.equals(a)));
		System.out.println("new Intefer == valueOf:" + (c == b));
		System.out.println("new Intefer equals valueOf:" + (c.equals(b)));
		 
		System.out.println(testClosure().get());
		
	}
	public static Supplier<Integer> testClosure(){
		final int i = 7;
		return new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return i;
			}
		};
		
	}
}
