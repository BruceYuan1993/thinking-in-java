package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;
	
	public void waxed(){
		lock.lock();
		try {
			waxOn = true;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void buffed(){
		lock.lock();
		try {
			waxOn = false;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitForWaxing() throws InterruptedException{
		lock.lock();
		try {
			while (waxOn) {
				condition.await();
			}
			
		} finally {
			lock.unlock();
		}
	}
	
	public void waitForBuffing() throws InterruptedException{
		lock.lock();
		try {
			while (!waxOn) {
				condition.await();
			}
			
		} finally {
			lock.unlock();
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

public class WaxOMatic2 {
public static void main(String[] args) throws InterruptedException {
	Car car = new Car();
	ExecutorService exec = Executors.newCachedThreadPool();
	exec.execute(new WaxOn(car));
	exec.execute(new WaxOff(car));
	TimeUnit.SECONDS.sleep(5);
	exec.shutdownNow();
}
}
