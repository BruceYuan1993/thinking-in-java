package com.bruce.demo.io;

public class DictionaryDemo {
	public static void main(String[] args) {
		PPrint.pprint(Directory.walk(".").dirs);
	}
}
