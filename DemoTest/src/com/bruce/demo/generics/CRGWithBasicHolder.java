package com.bruce.demo.generics;


class Subtype extends BasicHolder<Subtype>{
	
}

class a1 {
	b1 b;
	void get(b1 b){
		System.out.println("a1");
	}
}
class b1 extends a1{
	void f(){
		get(this);
	}
}

public class CRGWithBasicHolder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subtype st1 = new Subtype(), st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
		
		new b1().f();
		
	}

}
