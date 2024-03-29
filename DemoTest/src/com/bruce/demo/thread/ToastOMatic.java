package com.bruce.demo.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast{
	public enum Status { Dry, BUTTERED, JAMMED }
	private Status status = Status.Dry;
	private final int id;
	public Toast(int id) {
		super();
		this.id = id;
	}
	public void butter(){
		status = Status.BUTTERED;
	}
	
	public void jam(){
		status = Status.JAMMED;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public int getId(){
		return id;
	}
	@Override
	public String toString() {
		return "Toast " + id + ": " + id + status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast>{
	
}

class Toaster implements Runnable{
	
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);
	
	
	public Toaster(ToastQueue toastQueue) {
		super();
		this.toastQueue = toastQueue;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				Toast toast = new Toast(count++);
				System.out.println(toast);
				toastQueue.put(toast);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}
}

class Butterer implements Runnable{
	private ToastQueue dryQueue, butteredQueue;
	public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
		super();
		this.dryQueue = dryQueue;
		this.butteredQueue = butteredQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				Toast toast = dryQueue.take();
				toast.butter();
				System.out.println(toast);
				butteredQueue.put(toast);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}
}


class Jammer implements Runnable{
	private ToastQueue butteredQueue, finishedQueue;
	public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
		super();
		this.finishedQueue = finishedQueue;
		this.butteredQueue = butteredQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				Toast toast = butteredQueue.take();
				toast.jam();
				System.out.println(toast);
				finishedQueue.put(toast);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer off");
	}
}

class Eater implements Runnable{
	private ToastQueue finishedQueue;
	private int counter = 0;
	public Eater(ToastQueue finishedQueue) {
		super();
		this.finishedQueue = finishedQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				Toast toast = finishedQueue.take();
				
				if (toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED){
					System.out.println(">>>>> Error: " + toast);
					System.exit(1);
				}else{
					System.out.println("Chomp! " + toast);
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}
}


public class ToastOMatic {
	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue = new ToastQueue(),
				butteredQueue = new ToastQueue(),
				finishedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue,finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		
		exec.shutdownNow();
	}
}
