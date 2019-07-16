package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class T1 implements Runnable {
	public void run() {
		try {
			synchronized (this) {
				wait();
				System.out.println("Test");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class T2 implements Runnable{
	private T1 t;
	
	public T2(T1 t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			synchronized (t) {
				TimeUnit.SECONDS.sleep(2);
				t.notifyAll();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class WaitTest1 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2(t1);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(t1);
		exec.execute(t2);
		exec.shutdown();
	}
}
