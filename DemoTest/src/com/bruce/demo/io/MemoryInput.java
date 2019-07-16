package com.bruce.demo.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	public static void main(String[] args) {
		try {
			StringReader in = new StringReader(BufferedInputFile.read(
					"src\\com\\bruce\\demo\\io\\MemoryInput.java"));
			int c;
			while ((c = in.read()) != -1) {
				System.out.println((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
