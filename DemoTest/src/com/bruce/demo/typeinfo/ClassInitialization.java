package com.bruce.demo.typeinfo;

import java.util.Random;

class Initale{
	static final int StaticFinal = 47;
	static final int StaticFinal2 = ClassInitialization.random.nextInt(1000);
	static{
		System.out.println("Initializing Initable");
	}
}

class Initale2{
	static int StaticNonFinal = 147;
	static{
		System.out.println("Initializing Initale2");
	}
}

class Initale3{
	static int StaticNonFinal = 74;
	static{
		System.out.println("Initializing Initale3");
	}
}

public class ClassInitialization {
	public static Random random = new Random(47);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> initable = Initale.class;
		System.out.println("After creating Initable class ref");
		System.out.println(Initale.StaticFinal);
		System.out.println(Initale.StaticFinal2);
		
		System.out.println(Initale2.StaticNonFinal);
		
		try {
			Class.forName("com.bruce.demo.typeinfo.Initale3");
			System.out.println("After creating Initable3 class ref");
			System.out.println(Initale3.StaticNonFinal);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
