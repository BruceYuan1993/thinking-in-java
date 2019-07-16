package com.bruce.demo.typeinfo;

public class BoundedClassReferences {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class<? extends Number> boundedClass = int.class;
		boundedClass = double.class;
		boundedClass = Number.class;
		//Integer oInteger = boundedClass.newInstance();
	}

}
