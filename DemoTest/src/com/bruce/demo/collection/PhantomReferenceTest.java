package com.bruce.demo.collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class TestObject{

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("finalize() execute");
		super.finalize();
	}
	
}

public class PhantomReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestObject object = new TestObject();
		ReferenceQueue<TestObject> queue = new ReferenceQueue<TestObject>();
		PhantomReference<TestObject> pr = new PhantomReference<TestObject>(object, queue);
		System.out.println(pr);
		System.out.println(pr.isEnqueued());
		object = null;
		System.gc();
		
		
		try {
			Thread.currentThread().sleep(1000);
			System.gc();
			System.out.println(pr.isEnqueued());
			System.out.println(queue.remove(2000));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
