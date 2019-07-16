package com.bruce.demo.innerclass;

import java.io.IOException;
import java.sql.SQLException;

class Dog{
	protected void bark() throws SQLException{
		System.out.println("Dog");
	}
}
class Hound extends Dog{
	public void bark() throws SQLException{
		System.out.println("Hound");
	}
}
public class OverrideTest {
	public static void main(String[] args) {
		Dog dog = new Hound();
		try {
			dog.bark();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Dog dog2 = (Dog)new Hound();
//		dog2.bark();
	}
}
