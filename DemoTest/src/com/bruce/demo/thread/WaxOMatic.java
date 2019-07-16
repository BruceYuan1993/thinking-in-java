package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean waxOn = false;
	
	public synchronized void waxed(){
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffed(){
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException{
		while(!waxOn){
			wait();
		}
	}
	
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn){
			wait();
		}
	}
}

class WaxOn implements Runnable{
	private Car car;
	
	public WaxOn(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				System.out.println("Wax on!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Exiting via interrupt");
		}
		System.out.println("ending wax on task");
	}
}

class WaxOff implements Runnable{
	private Car car;
	
	public WaxOff(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax 0ff!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Exiting via interrupt");
		}
		System.out.println("ending wax off task");
	}
}


public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
