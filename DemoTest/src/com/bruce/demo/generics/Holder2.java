package com.bruce.demo.generics;


public class Holder2 {
	private Object a ;
	public Holder2(Object a){
		this.a = a ;
	}
	public void set(Object a){
		this.a = a;
	}
	public Object get(){
		return a;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = (Automobile) h2.get();
		h2.set("Not an autoMobile");
		String s = (String) h2.get();
		h2.set(1);
		Integer x = (Integer) h2.get();
	}

}
