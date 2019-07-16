package com.bruce.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

class LiftOffRunner implements Runnable{
	private BlockingQueue<LiftOff> rockets;
	
	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		super();
		this.rockets = rockets;
	}
	
	public void add(LiftOff lo){
		try {
			rockets.put(lo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted during put");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Waking from take()");
		}
		System.out.println("exiting liftoffrunner");
	}
	
}

public class TestBlockingQueues {
	static void test(String msg, BlockingQueue<LiftOff> queue){
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread thread = new Thread(runner);
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			runner.add(new LiftOff(5));
		}
		
		thread.interrupt();
		System.out.println("Finished " + msg + " test");
		
	}
	
	public static void main(String[] args) {
		test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
		test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
		test("SynchronousQueue", new SynchronousQueue<>());
	}
}
