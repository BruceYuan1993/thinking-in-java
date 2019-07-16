package com.bruce.demo.thread;

public class SelfManaged implements Runnable{
	private int countDown = 5;
	private Thread t = new Thread(this);
	
	public SelfManaged() {
		// TODO Auto-generated constructor stub
		t.start();
	}
	
	@Override
	public String toString() {
		return Thread.currentThread().getName() + "[" + countDown + "]";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(this);
			if (--countDown == 0){
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i < 5; i++){
			new SelfManaged();
		}
	}
	
}
