package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();
	public void untimed(){
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally {
			// TODO: handle finally clause
			if (captured){
				lock.unlock();
			}
		}
	}
	
	public void timed(){
		boolean captured = false;
		try {
			captured = lock.tryLock(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("tryLock(2,TimeUnit.SECONDS): " + captured);
		} finally {
			// TODO: handle finally clause
			if (captured){
				lock.unlock();
			}
		}
	}
	
	
	public static void main(String[] args) {
		final AttemptLocking al = new AttemptLocking();
		al.untimed();
		al.timed();
		new Thread(){
			{setDaemon(true);}
			public void run(){
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield();
		al.untimed();
		al.timed();
	}
}
