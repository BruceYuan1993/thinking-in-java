package com.bruce.demo.thread;

class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name, int sleepTime){
		super(name);
		duration = sleepTime;
		start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(getName() + " was interrupted. isInterrupted "
			+ isInterrupted() + " isAlive " + isAlive());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(getName() + " Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class Joining {
	public static void main(String[] args) throws Exception {
		Sleeper
			sleepy = new Sleeper("sleepy", 1500),
			grumpy = new Sleeper("grumpy", 1500);
		
		Joiner 
			dopey = new Joiner("dopey", sleepy),
			doc = new Joiner("doc", grumpy);
		Thread.sleep(1000);
		grumpy.interrupt();
	}
}
