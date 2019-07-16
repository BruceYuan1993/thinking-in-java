package com.bruce.demo.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskWithResult implements Callable<String>{
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Result " + id;
	}
	
}

public class CallableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		
		for (int i =0; i < 10; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> future : results) {
			try {
				System.out.println(future.get());
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
		}
	}

}
