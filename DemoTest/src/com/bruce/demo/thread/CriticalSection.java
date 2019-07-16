package com.bruce.demo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair{
	private int x,y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Pair(){
		this(0, 0);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void incrementX(){
		x++;
	}
	
	public void incrementY(){
		y++;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
	public class PairValuesNotEqualException extends RuntimeException{

		public PairValuesNotEqualException() {
			super("Pair values not equal: " + Pair.this);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public void checkState(){
		if (x != y){
			throw new PairValuesNotEqualException();
		}
	}
	
}


abstract class PairManager{
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
	public synchronized Pair getPair(){
		return new Pair(p.getX(), p.getY());
	}
	
	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract void increment();
}

class PairManager1 extends PairManager{

	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

class PairManager2 extends PairManager{

	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		Pair temp;
		synchronized(this){
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

class PairManipulator implements Runnable{
	private PairManager pm;
	
	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			pm.increment();
		}
	}

	@Override
	public String toString() {
		return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
	}
	
}


class PairChecker implements Runnable{
	private PairManager pm;
	
	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
	
}

public class CriticalSection {
	static void testApproaches(PairManager pamn1, PairManager pamn2){
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pamn1);
		PairManipulator pm2 = new PairManipulator(pamn2);
		
		PairChecker pc1 = new PairChecker(pamn1);
		PairChecker pc2 = new PairChecker(pamn2);
		
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pc1);
		exec.execute(pc2);
		
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sleep interrupted");
		}
		System.out.println("PM1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		PairManager pamn1 = new PairManager1();
		PairManager pamn2 = new PairManager2();
		testApproaches(pamn1,pamn2);
	}
}
