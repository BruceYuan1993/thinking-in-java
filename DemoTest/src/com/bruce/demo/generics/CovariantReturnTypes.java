package com.bruce.demo.generics;

class Base{}
class Dervied extends Base{

}

interface OrdinaryGetter{
	Base get();
}

interface DerivedGetter extends OrdinaryGetter{
	Dervied get();
}

public class CovariantReturnTypes {
	void test(DerivedGetter d){
		Dervied d2 = d.get();
		
	}
}
