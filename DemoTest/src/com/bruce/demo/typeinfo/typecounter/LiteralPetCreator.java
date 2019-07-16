package com.bruce.demo.typeinfo.typecounter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
	@SuppressWarnings("unchecked")
	public static List<Class<? extends Pet>> allTypes = Collections
			.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class,
					Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
					//Mouse.class, 
					Hamster.class));
	private static final List<Class<? extends Pet>> types = allTypes.subList(
			allTypes.indexOf(Mutt.class), allTypes.size());

	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}
	public static void main(String[] args) {
		System.out.println(types);
	}
}
