package com.bruce.demo.enumerated;

public class Herb {
	public enum Type{
		ANNUAL,
		PERENNIAL,
		BIENNIAL
	}
	
	private final String name;
	private final Type type;
	private Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
