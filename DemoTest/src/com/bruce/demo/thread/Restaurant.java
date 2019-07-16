package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
	private final int orderNum;

	public Meal(int orderNum) {
		super();
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meal " + orderNum;
	}
}
class WaitPerson implements Runnable{
	private Restaurant restaurant;
	
	public WaitPerson(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null){
						wait();
					}
					System.out.println("Waitperson got " + restaurant.meal);
					synchronized (restaurant.chef) {
						restaurant.meal = null;
						restaurant.chef.notify();
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("WaitPerson interrupt");
		}
	}
}

class Chef implements Runnable{
	private Restaurant restaurant;
	private int count;
	public Chef(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null){
						wait();
					}
					if (++count == 10){
						System.out.println("Out of food, closing");
						restaurant.exec.shutdownNow();
					}
					System.out.println("order up");
					synchronized (restaurant.waitPerson) {
						restaurant.meal = new Meal(count);
						restaurant.waitPerson.notify();
					}
					TimeUnit.MILLISECONDS.sleep(100);
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Chef interrupt");
		}
	}

}
public class Restaurant {
	Meal meal;
	Chef chef = new Chef(this);
	WaitPerson waitPerson = new WaitPerson(this);
	ExecutorService exec = Executors.newCachedThreadPool();
	public Restaurant() {
		super();
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}
	
}
