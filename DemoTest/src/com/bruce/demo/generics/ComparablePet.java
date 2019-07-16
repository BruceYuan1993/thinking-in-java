package com.bruce.demo.generics;

public class ComparablePet implements Comparable<ComparablePet> {

	@Override
	public int compareTo(ComparablePet o) {
		// TODO Auto-generated method stub
		System.out.println("ComparablePet");
		return 0;
	}
	
	public static void main(String[] args) {
		ComparablePet p1 = new ComparablePet();
		ComparablePet p2 = new Hamster();
		ComparablePet p3 = new Gecko();
		
		p2.compareTo(p1);
		p3.compareTo(p1);
	}

}

//class Cat extends ComparablePet implements Comparable<Cat>{
//	
//}

class Hamster extends ComparablePet implements Comparable<ComparablePet>{
	public int compareTo(ComparablePet o) {
		// TODO Auto-generated method stub
		System.out.println("Hamster");
		return 0;
	}
}

class Gecko extends ComparablePet{
	public int compareTo(ComparablePet o) {
		// TODO Auto-generated method stub
		System.out.println("Gecko");
		return 0;
	}
}