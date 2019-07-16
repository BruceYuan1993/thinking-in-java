package com.bruce.demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StoringAndRecoveringData {
	public static void main(String[] args) {
		try {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
			out.writeDouble(3.1415926);
			out.writeUTF("That waas PI");
			out.writeDouble(1.41413);
			out.writeUTF("Square root of 2");
			out.close();
			
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
