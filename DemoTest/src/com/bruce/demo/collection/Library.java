package com.bruce.demo.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


class Book{
	char[] symbols =  new char[30000];
}

class BookShelf{
	public int ID;
	Book[] books = new Book[100];
	
	public BookShelf(int iD) {
		ID = iD;
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("BookShelf: " + ID + " is dying!");
	}
}

class BookShelfReference extends WeakReference<BookShelf>{
	
	public int ID;
	static ReferenceQueue<BookShelf> queue 
		= new ReferenceQueue<BookShelf>();

	public BookShelfReference(BookShelf referent) {
		super(referent, queue);
		// TODO Auto-generated constructor stub
		this.ID = referent.ID;
	}
}

class GarbageMonitor extends Thread{
	ReferenceQueue<BookShelf> queue;

	public GarbageMonitor(ReferenceQueue<BookShelf> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				BookShelfReference reference = (BookShelfReference) queue.remove();
				System.out.println("Monitor : " + reference.ID + " was collected");
				if(reference.get() == null){
					System.out.println("get is null");
				}else {
					System.out.println("************************");
				};
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
		}
	}
	
}

public class Library {
	public static void main(String[] args) {
//		BookShelfReference[] shelves = new BookShelfReference[50];
//		
//		GarbageMonitor monitor = new GarbageMonitor(BookShelfReference.queue);
//		monitor.start();
//		
//		for(int i = 0; i < shelves.length; i++){
//			shelves[i] = new BookShelfReference(new BookShelf(i+1));
//			System.out.println("Creating bookshelf : " + (i+1));
//		}
		
		
		
		ReferenceQueue<Object> q = new ReferenceQueue<Object>();

		Object obj = new Object();
		SoftReference<Object> sr = new SoftReference<Object>(obj, q);
		obj = null;
		Object obj1 = sr.get();
		if (obj1 == null){
			obj1 = new Object();
		}else {
			System.out.println("----------");
		}
		SoftReference<Object> obj2 = null;
		while( (obj2 = (SoftReference<Object>) q.poll()) != null){
			System.out.println(obj2);
		}
		
	}
}
