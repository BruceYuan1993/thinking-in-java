package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;

class NeedsCleanUp{
	private final int id;
	public NeedsCleanUp(int id){
		this.id = id;
		System.out.println("NeedsCleanUp " + id);
	}
	
	public void cleanup(){
		System.out.println("Cleaning up" + id);
	}
}
class Blocked3 implements  Runnable {
	private volatile double d = 0.0;
	public void run() {
		try{
			while (!Thread.interrupted()) {
				NeedsCleanUp n1 = new NeedsCleanUp(1);
				try{
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(1);
					NeedsCleanUp n2 = new NeedsCleanUp(2);
					
					try {
						System.out.println("calculating");
						for (int i = 1; i < 2500000; i++) {
							d = d + (Math.PI + Math.E) / d;
						}
						System.out.println("Fininshed time long");
					} finally {
						n2.cleanup();
					}
				}finally {
					n1.cleanup();
				}
			}
			System.out.println("exiting via while() test");
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("exiting via InterruptedException");
		}
	}
}
public class InterruptingIdiom {
public static void main(String[] args) throws InterruptedException {
	Thread t = new Thread(new Blocked3());
	t.start();
	TimeUnit.MILLISECONDS.sleep(1100);
	t.interrupt();
}
}
