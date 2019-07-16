package com.bruce.demo.typeinfo.typecounter;

import java.util.List;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	public static Pet randomPet() {
		return creator.randomPet();
	}
	public static Pet[] createArray(int size){
		return creator.createArray(size);
	}
	public static List<Pet> arrayList(int size){
		return creator.arrayList(size);
	}
}
