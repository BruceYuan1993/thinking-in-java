package com.bruce.demo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.bruce.demo.generics.New;

public class SearchInArray {
	public static boolean useList(String[] arr, String value){
		return Arrays.asList(arr).contains(value);
	}
	
	public static boolean useSet(String[] arr, String value){
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(value);
	}
	
	public static boolean useLoop(String[] arr, String value){
		for(String s: arr){
			if (value.equals(s))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean useBinarySearch(String[] arr, String value){
		int i = Arrays.binarySearch(arr, value);
		if (i > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		final int MAX = 100000;
		final String[] arr = new String[MAX];
		Random random = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String(String.valueOf(random.nextInt())).intern();
		}
		
		String value = String.valueOf(random.nextInt());
		
		long start = System.nanoTime();
		useList(arr, value);
		long end = System.nanoTime();
		System.out.println("useList:  " + (end - start) / 1000000);
		
		start = System.nanoTime();
		useSet(arr, value);
		end = System.nanoTime();
		System.out.println("useSet:  " + (end - start) / 1000000);
		
		start = System.nanoTime();
		useLoop(arr, value);
		end = System.nanoTime();
		System.out.println("useLoop:  " + (end - start) / 1000000);
		
		start = System.nanoTime();
		useBinarySearch(arr, value);
		end = System.nanoTime();
		System.out.println("useBinarySearch:  " + (end - start) / 1000000);
		
		
	}
	public static void timer(){
		long start = System.nanoTime();
		
		long end = System.nanoTime();
		System.out.println("useSet:  " + (start - end) / 1000000);
	}
	
}
