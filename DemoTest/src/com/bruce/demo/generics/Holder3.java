package com.bruce.demo.generics;

import com.bruce.demo.typeinfo.typecounter.Cat;
import com.bruce.demo.typeinfo.typecounter.Cymric;
import com.bruce.demo.typeinfo.typecounter.EgyptianMau;
import com.bruce.demo.typeinfo.typecounter.Pet;

public class Holder3<T> {
	private T a;
	public Holder3(){
		
	}
	public Holder3(T a){
		this.a = a;
	}
	public void set(T a){
		this.a = a;
	}
	public T get(){
		return a;
	}
	
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get();
		
		//h3.set(1);
		
		Holder3<Cat> hCat = new Holder3<Cat>();
		hCat.set(new Cat());
		
		//superclass
		//hCat.set(new Pet());
		
		hCat.set(new EgyptianMau());
		
		hCat.set(new Cymric());
		
		
	}
}
