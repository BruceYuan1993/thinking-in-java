package com.bruce.demo.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable{
	private int i;
	private String s;
	
	public Blip3(){
		System.out.println("Blip3 Constructor");
	}
	public Blip3(int i, String s) {
		System.out.println("Blip3(int i, String s)");
		this.i = i;
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s + i;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("blip1.writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		s = (String)in.readObject();
		i = in.readInt();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Constructing Objects");
		Blip3 b3 = new Blip3(47, "A String");
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		System.out.println("Saving Objects");
		out.writeObject(b3);
		out.close();
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		System.out.println("Recovered b3");
		b3  = (Blip3)in.readObject();
		System.out.println(b3);
		
	}
}
