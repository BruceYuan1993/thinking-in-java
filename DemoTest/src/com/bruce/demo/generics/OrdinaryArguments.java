package com.bruce.demo.generics;

class OrdinarySetter{
	void set(Base base){
		System.out.println("OrdinarySetter.set(Base)");
	}
}

class DerivedSetter extends OrdinarySetter{
	void set(Dervied base){
		System.out.println("DerivedSetter(Derived)");
	}
}
public class OrdinaryArguments {
	public static void main(String[] args) {
		Base base = new Base();
		Dervied dervied = new Dervied();
		DerivedSetter setter = new DerivedSetter();
		setter.set(base);
		setter.set(dervied);
	}
}
