package com.bruce.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator{

	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();
	@Override
	public int next() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}

}
