package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadDeadLock {
	public static void main(String[] args) throws Exception {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		
		Thread t1 = new Thread(new SyncThread(o1, o2), "t1");
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		
		Thread t2 = new Thread(new SyncThread(o2, o3), "t2");
		t2.start();
		TimeUnit.SECONDS.sleep(5);
		
		Thread t3 = new Thread(new SyncThread(o3, o1), "t3");
		t3.start();
	}
}

class SyncThread implements Runnable{
	public SyncThread(Object o1, Object o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}
	private Object o1;
	private Object o2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquring lock on " + o1);
		synchronized (o1) {
			try {
				System.out.println(name + " acqured lock on " + o1);
				work();
				System.out.println(name + " acquring lock on " + o2);
				synchronized (o2) {
					System.out.println(name + " acqured lock on " + o2);
					work();
				}
				System.out.println(name + " release lock on " + o2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + " release lock on " + o1);
	}
	
	private void work() throws InterruptedException{
		TimeUnit.SECONDS.sleep(30);
	}
}
