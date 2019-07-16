package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable{
	private Date date = new Date();
	private String username;
	private transient String password;
	
	public Logon(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "logon info: \n username: " + username + "\n date: " + date +
				"\n password: " + password;
	}
	
	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hulk", "MyLittlePony");
		System.out.println("logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("LogOn.out"));
		o.writeObject(a);
		o.close();
		
		TimeUnit.SECONDS.sleep(1);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("LogOn.out"));
		System.out.println("Recovering object at "+ new Date());
		a = (Logon) in.readObject();
		System.out.println("logon a = " + a);
	}
	
	
}
