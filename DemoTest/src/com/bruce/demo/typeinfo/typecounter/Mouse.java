package com.bruce.demo.typeinfo.typecounter;

public class Mouse extends Rodent{
	static{
		LiteralPetCreator.allTypes.add(Mouse.class);
	}
	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
