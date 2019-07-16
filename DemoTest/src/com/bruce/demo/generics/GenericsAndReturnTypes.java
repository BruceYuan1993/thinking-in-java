package com.bruce.demo.generics;

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter> 
{

}

public class GenericsAndReturnTypes {
	void test(Getter t){
		Getter f = t.get();
		GenericGetter gg = f;
	}
}
