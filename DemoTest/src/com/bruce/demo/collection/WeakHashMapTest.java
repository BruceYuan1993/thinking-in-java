package com.bruce.demo.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import com.bruce.demo.generics.New;

public class WeakHashMapTest {
	public static void main(String[] args) {
//		 List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
//
//	        for (int i = 0; i < 1000; i++) {
//	            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
//	            d.put(new byte[1000][1000], new byte[1000][1000]);
//	            maps.add(d);
//	            System.gc();
//	            System.err.println(i);
//	            
//	            for (int j = 0; j < i; j++) {
//	                System.out.println(j+  " size " + maps.get(j).size());  
//	            }
//	        }
		
//		Object value = new Object();
//		final ReferenceQueue referenceQueue = new ReferenceQueue();
//		
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		for(int i = 0;i < 10000;i++) {
//		    byte[] bytes = new byte[1024*1024];
//		    WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
//		    map.put(weakReference, value);
//		}
//		System.out.println("map.size->" + map.size());
//		
//		Thread thread = new Thread(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//			        int cnt = 0;
//			        WeakReference<byte[]> k;
//			        while((k = (WeakReference) referenceQueue.remove()) != null) {
//			            System.out.println((cnt++) + " Collected " + k);
//			        }
//			    } catch(InterruptedException e) {
//			    }
//			}
//			
//		};
//		thread.setDaemon(true);
//		thread.start();
		
		List<WeakHashMap<byte[][], Object>> maps = new ArrayList<WeakHashMap<byte[][],Object>>();
		for (int i = 0; i < 1000; i++) {
		    WeakHashMap<byte[][], Object> d = new WeakHashMap<byte[][], Object>();
		    d.put(new byte[1000][1000], new Object());
		    maps.add(d);
		    System.gc();
		    System.err.println(i);
		    //d.size();
		}
		
		
		
	}
}
