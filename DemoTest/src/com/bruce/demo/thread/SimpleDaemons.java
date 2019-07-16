package com.bruce.demo.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all started");
		TimeUnit.MILLISECONDS.sleep(10);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+ " " + this);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sleep() interrupted");
		}
	}

}
