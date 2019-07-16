package com.bruce.demo.generics;

public class GenericMethods {
	
	public <T,M> void f(T x,int i){
		System.out.println(x.getClass().getName());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericMethods gm = new GenericMethods();
		gm.f("",0);
		gm.f(1,0);
		gm.f(1.0,0);
		gm.f(1.0f,0);
		gm.f('c',0);
		gm.f(gm,0);
	}

}
