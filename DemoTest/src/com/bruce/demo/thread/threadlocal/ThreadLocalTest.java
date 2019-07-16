package com.bruce.demo.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadLocalTest {
	//ThreadLocal<>
	public static void main(String[] args) {
		DemoTask demo = new DemoTask();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		Thread t3 = new Thread(demo);
		t1.start();
		t2.start();
		t3.start();
	}
}
class ThreadLocalValueObj{
	static int count = 0;
	
	public final int id;
	public String name;
	ThreadLocalValueObj(String name) {
		id = count++;
		this.name = name;
	}
}
class DemoTask implements Runnable{
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return nextId.getAndIncrement();
		}
	};
	
	public int getThreadId(){
		return nextId.get();
	}
	static ThreadLocalValueObj obj = new ThreadLocalValueObj("Bruce");
	static final ThreadLocal<ThreadLocalValueObj> threadObj = new ThreadLocal<ThreadLocalValueObj>(){

		@Override
		protected ThreadLocalValueObj initialValue() {
			// TODO Auto-generated method stub
			return obj;
		}
		
	};
	
	   private static final ThreadLocal<Date> startDate =
		       new ThreadLocal<Date>() {
		           protected Date initialValue() {
		               return new Date();
		           }
		       };
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Starting Thread: %s : %sn",
                getThreadId(), startDate.get());
		System.out.println();
		System.out.println(threadObj.get().name);
		try {
			Thread.sleep(5000);
			threadObj.get().name = "ABCD";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %sn",
                getThreadId(), startDate.get());
		
		System.out.println(threadObj.get().name);
	}
	
}
