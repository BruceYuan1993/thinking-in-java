package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex{
	private Lock lock = new ReentrantLock();
	public BlockedMutex(){
		lock.lock();
	}
	
	public void f(){
		try {
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Interrupted from lock acquisition in f()");
		}
	}
}
class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();
	public void run() {
		System.out.println("Waiting for f() in BlockedMutex");
		blocked.f();
		System.out.println("Broken out of Blocked call");
	}
}

public class Interrupting2 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Blocked2());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issing t.interrupt()");
		thread.interrupt();
	}
}
