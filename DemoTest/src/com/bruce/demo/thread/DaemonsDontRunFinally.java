package com.bruce.demo.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exiting via Exception");
		} finally {
			System.out.println("This shoud always run?");
		}
	}
}

public class DaemonsDontRunFinally {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
		TimeUnit.SECONDS.sleep(1);
	}

}
