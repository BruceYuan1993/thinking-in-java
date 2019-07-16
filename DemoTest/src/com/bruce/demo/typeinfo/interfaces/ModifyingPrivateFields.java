package com.bruce.demo.typeinfo.interfaces;

import java.lang.reflect.Field;

class WithPrivateFilalField{
	private int i = 1;
	private final String s1 = "I'm totally safe";
	private String s2 = "Am i safe";
	public String toString(){
		return "i= " +i+", "+s1 +", " +s2;
	}
}
public class ModifyingPrivateFields {
	public static void main(String[] args) throws Exception {
		WithPrivateFilalField pf = new WithPrivateFilalField();
		System.out.println(pf);
		Field f = pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("f.getInt(pf)"+f.getInt(pf));
		f.setInt(pf, 47);
		System.out.println(pf);
		
		f = pf.getClass().getDeclaredField("s1");
		f.setAccessible(true);
		System.out.println("f.getInt(pf)"+f.get(pf));
		f.set(pf, "No, you are not");
		System.out.println(pf);
		
		f = pf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("f.getInt(pf)"+f.get(pf));
		f.set(pf, "No, you are not");
		System.out.println(pf);
	}
}
