package com.bruce.demo.io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Charset.defaultCharset().name());
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		Iterator<String> it = charSets.keySet().iterator();
		while (it.hasNext()) {
			String csName = it.next();
			System.out.print(csName);
			System.out.print("\t");
			Iterator<String> aliases = charSets.get(csName).aliases().iterator();
			if (aliases.hasNext()){
				System.out.print(":");
			}
			while (aliases.hasNext()) {
				System.out.print(aliases.next());
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
