package com.bruce.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.bruce.demo.io.PPrint;

class Count{
	private int count = 0;
	private Random random = new Random(47);
	public synchronized int increment(){
		int temp = count;
		if (random.nextBoolean()){
			Thread.yield();
		}
		return (count = ++temp);
	}
	
	public synchronized int value(){
		return count;
	}
}

class Entrance implements Runnable{
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	
	public static void cancel(){
		canceled = true;
	}
	
	public Entrance(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		entrances.add(this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Sleep interruputed");
			}
		}
		System.out.println("Stoppin " + this);
	}
	
	
	public synchronized int getValue(){
		return number;
	}

	@Override
	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}
	
	public static int getTotalCount(){
		return count.value();
	}
	
	public static int sumEntrances(){
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}
	
	
	
}

public class OrnamentalGarden {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++){
			exec.execute(new Entrance(i));
		}
		
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println("Some tasks wwere not terminated");
		}
		System.out.println("Total: " + Entrance.getTotalCount());
		System.out.println("sumEntrances: " + Entrance.sumEntrances());
	}
}
