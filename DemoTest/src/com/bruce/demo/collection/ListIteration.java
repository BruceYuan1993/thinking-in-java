package com.bruce.demo.collection;

import java.util.List;
import java.util.ListIterator;

import com.bruce.demo.typeinfo.typecounter.Pet;
import com.bruce.demo.typeinfo.typecounter.Pets;

public class ListIteration {
	public static void main(String[] args) {
		List<Pet> list = Pets.arrayList(8);
		ListIterator<Pet> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next() + ", " + it.nextIndex() + ", "
					+ it.previousIndex() + "; ");
		}
		
		System.out.println();
		
		while (it.hasPrevious()) {
			System.out.println(it.previous() + " ");
		}
		
		System.out.println();
		System.out.println(list);
		
		it = list.listIterator(3);
		while (it.hasNext()) {
			it.next();
			it.set(Pets.randomPet());
		}
		
		System.out.println(list);
	}
}
