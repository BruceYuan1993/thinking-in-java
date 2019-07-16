package com.bruce.demo.typeinfo.typecounter;

import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K, V> {
	public MapData(Iterable<K> keys, V value){
		for (K key : keys) {
			put(key, value);
		}
	}
	public static <K,V> MapData<K,V>
	  map(Iterable<K> genK, V value) { 
	    return new MapData<K,V>(genK, value);
	}
}
