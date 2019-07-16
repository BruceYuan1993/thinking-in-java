package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.bruce.demo.typeinfo.typecounter.Cat;
import com.bruce.demo.typeinfo.typecounter.Dog;
import com.bruce.demo.typeinfo.typecounter.Pet;

public class CheckedList {
	static void oldStyleMethod(List dogs){
		dogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);
		
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
		
	}
}

//class AException<R> extends Throwable{
//	
//}


