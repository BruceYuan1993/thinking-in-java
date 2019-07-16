package com.bruce.demo.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class TestEOF {
	public static void main(String[] args) {
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(
							"src\\com\\bruce\\demo\\io\\TestEOF.java")));
			while (in.available() != 0) {
				System.out.println((char)in.readByte());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
