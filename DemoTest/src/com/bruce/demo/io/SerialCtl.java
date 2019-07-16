package com.bruce.demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCtl implements Serializable{
	private String a;
	private transient String b;
	public SerialCtl(String a, String b) {
		super();
		this.a = "Not transient " + a;
		this.b = "transient " + b;
	}
	@Override
	public String toString() {
		return a +"\n" + b;
	}
	
	
	private void writeObject(ObjectOutputStream stream) throws IOException{
		stream.writeObject(b);
		stream.defaultWriteObject();
		
	}
	
	
	private void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException{
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}
	
	public static void main(String[] args) throws Exception {
		SerialCtl sc = new SerialCtl("test1", "test2");
		System.out.println("Before:\n"+sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		o.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After: \n" + sc2);
	}
	
}
