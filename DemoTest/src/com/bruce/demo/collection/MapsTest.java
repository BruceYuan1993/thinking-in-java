package com.bruce.demo.collection;

import java.util.HashMap;
import java.util.Map;


public class MapsTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.putAll(new CountingMapData(25));
		System.out.println(map);
		System.out.println(map.values());
		map.values().clear();
		System.out.println(map.size());
	}
}
