package com.bruce.demo.generics;

import java.util.Date;

interface TimeStamped{
	long getStamp();
}

class TimeStampedImpl implements TimeStamped{
	private final long timeStamp;
	
	public TimeStampedImpl(){
		timeStamp = new Date().getTime();
	}
	@Override
	public long getStamp() {
		// TODO Auto-generated method stub
		return timeStamp;
	}
	
}

interface SerialNumbered{
	long getSerialNumber();
}

class SerialNumberedImpl implements SerialNumbered{
	private static long counter = 1;
	private final long serialNumber = counter++;
	@Override
	public long getSerialNumber() {
		// TODO Auto-generated method stub
		return serialNumber;
	}
}

interface Basic {
	public void set(String val);
	public String get();
}

class BasicImpl implements Basic{
	private String value;
	@Override
	public String get() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void set(String val) {
		// TODO Auto-generated method stub
		value = val;
	}
	
}


class Mixin extends BasicImpl implements SerialNumbered,TimeStamped{
	private TimeStamped timeStamp = new TimeStampedImpl();
	private SerialNumbered serialNumber = new SerialNumberedImpl();
	@Override
	public long getSerialNumber() {
		// TODO Auto-generated method stub
		return serialNumber.getSerialNumber();
	}

	@Override
	public long getStamp() {
		// TODO Auto-generated method stub
		return timeStamp.getStamp();
	}
	
}

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test String1");
		mixin2.set("test String2");
		System.out.println(mixin1.get() +"  " + mixin1.getStamp()+"  "+mixin1.getSerialNumber());
		System.out.println(mixin2.get() +"  " + mixin2.getStamp()+"  "+mixin2.getSerialNumber());
	}
	
}
