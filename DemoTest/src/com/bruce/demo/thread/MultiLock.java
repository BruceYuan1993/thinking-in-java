package com.bruce.demo.thread;

public class MultiLock {
	public synchronized void f1(int count){
		if (count-- > 0){
			System.out.println("f1() calling f2() wint count " + count);
			f2(count);
		}
	}
	
	public synchronized void f2(int count){
		if (count-- > 0){
			System.out.println("f2() calling f1() wint count " + count);
			f1(count);
		}
	}
	
	public static void main(String[] args) {
		final MultiLock lock = new MultiLock();
		new Thread(){
			public void run(){
				lock.f1(10);
			}
		}.start();
	}
}
