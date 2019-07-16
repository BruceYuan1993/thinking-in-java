package com.bruce.demo.typeinfo;

public class GenericToyTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class<FancyToy> ftClass = FancyToy.class;
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> upClass = ftClass.getSuperclass();
		Object object = upClass.newInstance();
		Toy object1 = (Toy) upClass.newInstance();
		System.out.println(object1);
		
		Class<Toy> cc = (Class<Toy>) ftClass.getSuperclass();
		System.out.println(cc);
	}

}
