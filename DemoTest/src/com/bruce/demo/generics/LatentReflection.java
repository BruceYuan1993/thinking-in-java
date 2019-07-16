package com.bruce.demo.generics;

import java.lang.reflect.Method;

public class LatentReflection {
	public static void main(String[] args) {
		CommunicateReflectively.perform(new SmartDog());
		CommunicateReflectively.perform(new Mime());
	}
}

class Mime{
	public void walkAgainstTheWind(){}
	public void sit(){
		System.out.println("mime sit");
	}
	public void pushInvisibleWalls(){}
	
	@Override
	public String toString(){
		return "Mine";
	}
}

class SmartDog{
	public void speak(){
		System.out.println("woof!");
	}
	public void sit(){
		System.out.println("SmartDog sit");
	}
	public void reproduce(){}
}

class CommunicateReflectively{
	public static void perform(Object speaker){
		Class<?> spkr = speaker.getClass();
		try {
			Method speak = spkr.getMethod("speak");
			speak.invoke(speaker);
			
			Method sit = spkr.getMethod("sit");
			sit.invoke(speaker);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}