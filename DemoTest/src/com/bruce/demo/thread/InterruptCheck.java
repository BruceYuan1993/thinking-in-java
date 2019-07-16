package com.bruce.demo.thread;

public class InterruptCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread t = Thread.currentThread();
//		System.out.println(t.isInterrupted());
//		t.interrupt();
//		System.out.println(t.isInterrupted());
//		try{
//			Thread.sleep(2000);
//			System.out.println("was NOT interrupted");
//		}catch(InterruptedException x){
//			System.out.println("was interrupted");
//			System.out.println(t.isInterrupted());
//		}
//		System.out.println(t.isInterrupted());
		
		Thread.currentThread().interrupt();
		System.out.println(
				"Point X: Thread.interrupted()=" + Thread.interrupted());
		System.out.println(
				"Point X: Thread.interrupted()=" + Thread.interrupted());
			Thread.currentThread().interrupt();
			System.out.println(
				"Point Y: Thread.interrupted()=" + Thread.interrupted());
			System.out.println(
				"Point Z: Thread.interrupted()=" + Thread.interrupted());
	}

}
