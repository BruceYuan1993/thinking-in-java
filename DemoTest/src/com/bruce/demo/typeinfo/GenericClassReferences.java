package com.bruce.demo.typeinfo;

public class GenericClassReferences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class;
		intClass = double.class;
//		genericIntClass = double.class;
	}

}
