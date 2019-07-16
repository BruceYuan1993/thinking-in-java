package com.bruce.demo.collection;

import java.util.LinkedList;

import com.bruce.demo.typeinfo.typecounter.Dog;
import com.bruce.demo.typeinfo.typecounter.Pet;
import com.bruce.demo.typeinfo.typecounter.Pets;
import com.bruce.demo.typeinfo.typecounter.Rat;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(10));
		System.out.println(pets);
		
		System.out.println("pets.getFirst()" + pets.getFirst());
		System.out.println("pets.element()" + pets.element());
		System.out.println("pets.peek()" + pets.peek());
		System.out.println("pets.peekFirst()" + pets.peekFirst());
		System.out.println("pets.peekLast()" + pets.peekLast());
		
		System.out.println("remove()" + pets.remove());
		System.out.println("removeFirst()" + pets.removeFirst());
		System.out.println("removeLast()" + pets.removeLast());
		
		System.out.println("poll()" + pets.poll());
		System.out.println("poll()" + pets.pollFirst());
		System.out.println("poll()" + pets.pollLast());
		System.out.println(pets);
		
		Pet r1 = new Rat();
		System.out.println(r1);
		pets.add(r1);
		pets.addFirst(r1);
		pets.addLast(r1);
		System.out.println(pets);
		
		r1 = new Dog();
		System.out.println(r1);
		pets.offer(r1);
		pets.offerFirst(r1);
		pets.offerLast(r1);
		System.out.println(pets);
		
		pets.removeLastOccurrence(r1);
		System.out.println(pets);
		pets.removeLastOccurrence(r1);
		System.out.println(pets);
		pets.removeFirstOccurrence(r1);
		System.out.println(pets);
		
		
	}
}
