package com.bruce.demo.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) {
		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(
					BufferedInputFile.read(
							"src\\com\\bruce\\demo\\io\\FormattedMemoryInput.java"
							).getBytes()));
			while (in.available() != 0) {
				System.out.println((char)in.readByte());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
