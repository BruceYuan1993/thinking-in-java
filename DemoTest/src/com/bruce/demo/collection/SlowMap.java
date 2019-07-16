package com.bruce.demo.collection;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.bruce.demo.collection.EntrySet.MyEntry;
import com.bruce.demo.collection.ToDoList.ToDoItem;
import com.sun.org.apache.bcel.internal.generic.IXOR;






class EntrySet<K, V> extends AbstractSet<MyEntry<K, V>>{
	private List<K> keys ;
	private List<V> values;
	public EntrySet(List<K> keys, List<V> values){
		this.keys = keys;
		this.values = values;
	}
	@Override
	public Iterator<MyEntry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<MyEntry<K,V>>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < keys.size();
			}

			@Override
			public MyEntry<K, V> next() {
				// TODO Auto-generated method stub
				MyEntry result = new MyEntry<K, V>(keys.get(index), values.get(index));
				index++;
				return result;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				keys.remove(index);
				values.remove(index);
			}
		};
	}
	
	static class MyEntry<K, V> implements Entry<K, V>{
		private K key;
		private V value;
		
		
		
		public MyEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			V result = this.value;
			this.value = value; 
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if (obj == this)
				return true;
			if (!(obj instanceof MyEntry))
				return false;
			MyEntry me = (MyEntry)obj;
			return (key == null ? me.getKey() == null : me.getKey().equals(key))&&
			(value == null ? me.getValue() == null : me.getValue().equals(value));
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return (key == null ? 0 : key.hashCode())^
			(value == null ? 0 : key.hashCode());
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return keys.size();
	}
	//public EntrySet(List<K>, List<V>);
}




public class SlowMap<K, V> extends AbstractMap<K, V>{
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	@Override
	public V put(K key, V value){
		V oldValue = get(key);
		if (!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}
	
	@Override
	public V get(Object key){
		if (!keys.contains(key)){
			return null;
		}
		return values.get(keys.indexOf(key));
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
//		Set<Entry<K, V>> set = new HashSet<Entry<K,V>>();
//		Iterator<K> ki = keys.iterator();
//		Iterator<V> vi = values.iterator();
//		while (ki.hasNext()) {
//			set.add(new MyEntry<K, V>(ki.next(),vi.next()));
//			
//		}
//		return set;
		return new EntrySet(keys, values);
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		Map<String, ToDoItem> map = new HashMap<String, ToDoItem>();
		map.put("1", new ToDoItem("1", 'A', 1));
		System.out.println(map);
		
		Set<Entry<String, ToDoItem>> sets = map.entrySet();
		Iterator<Entry<String, ToDoItem>>  it = sets.iterator();
		while (it.hasNext()) {
			
			Entry<String, ToDoItem> item = it.next();
			item.setValue(new ToDoItem("2", 'B', 2));
			//it.remove();
		}
		
		System.out.println(map);
	}

}


