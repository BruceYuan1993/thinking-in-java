package com.bruce.demo.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable{
	public Blip1(){
		System.out.println("blip1 Constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("blip1.writeExternal");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("blip1.readExternal");
	}
	
}

class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("blip2 Constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("blip2.writeExternal");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("blip2.readExternal");
	}
	
}
public class Blips {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Constructing Objects");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blips.out"));
		System.out.println("Saving Objects");
		out.writeObject(b1);
		out.writeObject(b2);
		out.close();
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
		System.out.println("Recovering Objects");
		b1  = (Blip1)in.readObject();
		System.out.println(b1 == null);
		System.out.println("Recovered b1");
		
		//b2  = (Blip2)in.readObject();
	}
}
