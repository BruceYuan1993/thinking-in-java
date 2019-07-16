package com.bruce.demo.thread.threadlocal;

public class ThreadLocalTest2 {
	public final static ThreadLocal<String> TestName = new ThreadLocal<String>();
	public final static ThreadLocal<String> TestValue = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++){
			final String name = "Thread - [" + i + "]";
			final String value = String.valueOf(i);
			new Thread(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						TestName.set(name);
						TestValue.set(value);
						callA();
					} finally {
						// TODO: handle finally clause
						TestName.remove();
						TestValue.remove();
					}
				}
			}.start();
		}
	}
	public static void callA(){
		callB();
	}
	public static void callB(){
		new ThreadLocalTest2().callC();
	}
	public void callC(){
		callD();
	}
	
	public void callD(){
		System.out.println(TestName.get()+"\t = \t" + TestValue.get());
	}
}
