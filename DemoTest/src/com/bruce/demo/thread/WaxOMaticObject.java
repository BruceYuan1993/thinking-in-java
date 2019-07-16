package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Car1{
	private AtomicInteger count = new AtomicInteger(0);
	public Object lock = new Object();
	private boolean isWaxed = false;
	private boolean isBuffed = false;
	private boolean isNew = true;
	public void wax() throws InterruptedException{
		synchronized (lock) {
			if (!isWaxed && (isBuffed || isNew)) {
				System.out.println("wax");
				TimeUnit.MILLISECONDS.sleep(500);
				isWaxed = true;
				isBuffed = false;
				isNew = false;
				lock.notifyAll();
				
			}else
			{
				lock.wait();
			}
		}
	}
	
	public void buff() throws InterruptedException{
		synchronized (lock) {
			if (isWaxed && !isBuffed) {
				System.out.println("buff");
				TimeUnit.MILLISECONDS.sleep(500);
				isWaxed = false;
				isBuffed = true;
				count.getAndAdd(1);
				lock.notifyAll();
				
			}else
			{
				lock.wait();
				
			}
			
		}
	}
	
	public boolean isContinue() throws InterruptedException{
		return count.get() < 5;
	}
}

class Wax implements Runnable{
	private Car1 car;
	
	public Wax(Car1 car) {
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (car.isContinue()) {
				car.wax();
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Exiting via interrupt");
		}
		System.out.println("ending wax on task");
	}
}

class Buff implements Runnable{
	private Car1 car;
	
	public Buff(Car1 car) {
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (car.isContinue()) {
				car.buff();
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Exiting via interrupt");
		}
		System.out.println("ending wax off task");
	}
}

public class WaxOMaticObject {
	public static void main(String[] args) {
		Car1 car = new Car1();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Buff(car));
		exec.execute(new Wax(car));
		
		exec.shutdown();
	}
}
