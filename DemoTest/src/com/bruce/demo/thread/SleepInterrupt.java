package com.bruce.demo.thread;

public class SleepInterrupt implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("in run() - about to sleep for 20 seconds");
			Thread.currentThread().sleep(20000);
//			for (int i=0 ; i < 100000; i++){
//				System.out.println(i);
//			}
			System.out.println("in run() - wake up");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("in run() - interrupted while sleeping");
			return;  
		}
		System.out.println("in run() - normal leave");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SleepInterrupt si = new SleepInterrupt();
		Thread thread = new Thread(si);
		thread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("in main() - interrupting other thread");
		thread.interrupt();
		System.out.println("in main() - leaving");
	}

}
