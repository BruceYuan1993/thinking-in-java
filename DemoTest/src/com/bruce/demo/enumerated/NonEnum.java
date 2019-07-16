package com.bruce.demo.enumerated;

public class NonEnum {
	public static void main(String[] args) {
		Class<Integer> intClass = Integer.class;
		
		Object[] x = intClass.getEnumConstants();
		if (x != null)
		{
			for(Object o : x){
				System.out.println(o);
			}
		}else
		{
			System.out.println("x is null");
		}
	}
}
