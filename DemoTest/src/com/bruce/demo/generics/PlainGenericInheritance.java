package com.bruce.demo.generics;

class GenericSetter<T>{
	void set(T arg){
		System.out.println("GenericSetter.set(T)");
	}
}
class DerivedGS extends GenericSetter<Base>{
	void set(Dervied derived){
		System.out.println("DerivedGS.set(Dervied)");
	}
}
public class PlainGenericInheritance {
	public static void main(String[] args) {
		Base base = new Base();
		Dervied dervied = new Dervied();
		DerivedGS setter = new DerivedGS();
		setter.set(base);
		setter.set(dervied);
	}
}
