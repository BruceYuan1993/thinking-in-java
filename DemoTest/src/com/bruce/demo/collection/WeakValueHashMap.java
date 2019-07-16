package com.bruce.demo.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class WeakValue extends WeakReference<byte[]>{
	public Object key;
	
	public WeakValue(Object key, byte[] referent, ReferenceQueue<? super byte[]> queue) {
		super(referent, queue);
		// TODO Auto-generated constructor stub
		this.key = key;
	}
}

public class WeakValueHashMap {
	public static void main(String[] args) throws Exception {
		final ReferenceQueue<byte[]> queue = new ReferenceQueue<byte[]>();
		final Map<Object, WeakValue> map = new HashMap<Object, WeakValue>();
		for(int i = 0;i < 10000;i++) {
			byte[] bytesKey = new byte[1024];
			byte[] bytesValue = new byte[1024];
			map.put(bytesKey, new WeakValue(bytesKey, bytesValue, queue));
		}
		
		Thread thread = new Thread(){
		
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							int cnt = 0;
							WeakValue k;
					        while((k = (WeakValue) queue.remove()) != null) {
					            System.out.println((cnt++) + " collect: " + k);
					            
					            map.remove(k.key);
					        }
					    } catch(InterruptedException e) {
					    	
					    }
					    
					}
					
				};
				thread.setDaemon(true);
				thread.start();
				Thread.sleep(1000 * 10);
				System.out.println(map.size());
        }
	
		
	
}
