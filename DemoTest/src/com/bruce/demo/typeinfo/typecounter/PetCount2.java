package com.bruce.demo.typeinfo.typecounter;

public class PetCount2 {
	public static void main(String[] args) {
		PetCount.countPets(new LiteralPetCreator());
		PetCount.countPets(Pets.creator);
	}
}
