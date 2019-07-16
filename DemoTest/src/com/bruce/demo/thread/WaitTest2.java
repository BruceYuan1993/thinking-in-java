package com.bruce.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class T3 implements Runnable {
	public volatile boolean flag = false;
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
			flag = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class T4 implements Runnable{
	private T3 t;
	
	public T4(T3 t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		while(true){
			if (t.flag)
			{
				System.out.println("enter-------------");
				return;
			}
		}
	}
}
public class WaitTest2 {
	public static void main(String[] args) {
	T3 t3 = new T3();
	T4 t4 = new T4(t3);
	ExecutorService exec = Executors.newCachedThreadPool();
	exec.execute(t3);
	exec.execute(t4);
	exec.shutdown();
	}
}
