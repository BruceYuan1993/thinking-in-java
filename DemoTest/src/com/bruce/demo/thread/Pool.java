package com.bruce.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Pool<T> {
	private int size;
	private List<T> items = new ArrayList<>();
	private volatile boolean[] checkedOut;
	private Semaphore avaiable;
	public Pool(Class<T> clazz, int size) {
		this.size = size;
		checkedOut = new boolean[size];
		avaiable = new Semaphore(size, true);
		
		for (int i = 0; i < size; i++) {
			try {
				items.add(clazz.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public T checkOut() throws InterruptedException{
		avaiable.acquire();
		return getItem();
	}
	
	public void checkIn(T item) throws InterruptedException{
		if (releseItem(item)){
			avaiable.release();
		}
		//return getItem();
	}

	private synchronized T getItem() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; ++i) {
			if (!checkedOut[i]){
				checkedOut[i] = true;
				return items.get(i);
			}
		}
		return null;
	}
	
	private synchronized boolean releseItem(T item) {
		// TODO Auto-generated method stub
		int index = items.indexOf(item);
		if (index < 0) return false;
		if (checkedOut[index]){
			checkedOut[index] = false;
			return true;
		}
		return false;
	}
	
}
