package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;

class Synchronized1{
	public Synchronized1(Object o){
		f2(this);
	}
	
	public  void f2(Object o){
		synchronized (o) {
			while(true){
				System.out.println("f2 " + Thread.currentThread());
			}
			
		}
	}
}

class Synchronized2 implements Runnable {
	
	
	public void run() {
		Synchronized1 sync1 =  new Synchronized1(new Object());
		sync1.f2(new Object());
	}
}

class Synchronized3 implements Runnable {
	Synchronized1 sync1 =  new Synchronized1(new Object());
	
	public void run() {
		sync1.f2(new Object());
	}
}

public class Interrupting3 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Synchronized2());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("-------------------------------------");
		thread.interrupt();
	}
}
