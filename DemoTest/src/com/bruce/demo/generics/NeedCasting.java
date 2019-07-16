package com.bruce.demo.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		//List<Widget> list = List<Widget>) in.readObject();
		List<Widget> list = List.class.cast(in.readObject());
	}
}
