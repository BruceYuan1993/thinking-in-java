package com.bruce.demo.thread;

public class EvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
