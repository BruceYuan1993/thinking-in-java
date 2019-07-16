package com.bruce.demo.generics;

import java.util.Date;

class Basic1{
	private String value;
	public String get() {
		// TODO Auto-generated method stub
		return value;
	}
	public void set(String val) {
		// TODO Auto-generated method stub
		value = val;
	}
}

class Decorator extends Basic1{
	protected Basic1 basic;
	public Decorator(Basic1 basic2){
		this.basic = basic2;
	}
	
	public void set(String val){
		basic.set(val);
	}
	
	public String get() {
		// TODO Auto-generated method stub
		return basic.get();
	}
}

class TimeStamped1 extends Decorator{
	private final long timeStamp;
	public TimeStamped1(Basic1 basic) {
		super(basic);
		// TODO Auto-generated constructor stub
		timeStamp = new Date().getTime();
	}
	public long getStamp() {
		// TODO Auto-generated method stub
		return timeStamp;
	}
}

class SerinalNumbered extends Decorator{

	public SerinalNumbered(Basic1 basic) {
		super(basic);
		// TODO Auto-generated constructor stub
	}
	private static long counter = 1;
	private final long serialNumber = counter++;
	public long getSerialNumber() {
		// TODO Auto-generated method stub
		return serialNumber;
	}
}

public class Decoration{
	public static void main(String[] args) {
		TimeStamped1 t = new TimeStamped1(new Basic1());
		TimeStamped1 t2 = new TimeStamped1(new SerinalNumbered(new Basic1()) );
		//((SerinalNumbered)t2).getSerialNumber();
	}
}
