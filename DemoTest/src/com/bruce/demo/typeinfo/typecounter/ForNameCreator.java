package com.bruce.demo.typeinfo.typecounter;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	private static String[] typeNames = {
			"com.bruce.demo.typeinfo.typecounter.Mutt",
			"com.bruce.demo.typeinfo.typecounter.Pug",
			"com.bruce.demo.typeinfo.typecounter.EgyptianMau",
			"com.bruce.demo.typeinfo.typecounter.Manx",
			"com.bruce.demo.typeinfo.typecounter.Cymric",
			"com.bruce.demo.typeinfo.typecounter.Rat",
			"com.bruce.demo.typeinfo.typecounter.Mouse",
			"com.bruce.demo.typeinfo.typecounter.Hamster",
	};
	static{
		loader();
	}
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}
	
	@SuppressWarnings("unchecked")
	private static void loader() {
		// TODO Auto-generated method stub
		for (String name : typeNames) {
			try {
				types.add((Class<? extends Pet>) Class.forName(name));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
