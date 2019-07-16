package com.bruce.demo.collection;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import com.bruce.demo.collection.EntrySet.MyEntry;

@SuppressWarnings("unchecked")
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {
	static final int SIZE = 997;
	
	LinkedList<MyEntry<K, V>>[] bucket = new LinkedList[SIZE];
	
	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		int index = Math.abs(key.hashCode()) % size();
		if (bucket[index] != null) {
			for (MyEntry<K, V> entry : bucket[index]) {
				if (entry.getKey().equals(key)){
					return entry.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (bucket[index] == null){
			bucket[index] = new LinkedList<MyEntry<K,V>>();
		}
		
		LinkedList<MyEntry<K,V>> list = bucket[index];
		boolean found = false;
		MyEntry<K, V> entry = new MyEntry<K, V>(key, value);
		 
		ListIterator<MyEntry<K, V>> it = list.listIterator();
		while (it.hasNext()) {
			MyEntry<K, V> ipair = it.next();
			if(ipair.getKey().equals(key)){
				oldValue = ipair.getValue();
				it.set(entry);
				found = true;
				break;
			}
		}
		if (!found){
			list.add(entry);
		}
		return oldValue;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K, V>> set = new HashSet<Entry<K,V>>();
		for (LinkedList<MyEntry<K, V>> b : bucket) {
			if (b == null) continue;
			for (MyEntry<K, V> m : b){
				set.add(m);
			}
		}
		return set;
	}
	
}
