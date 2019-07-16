package com.bruce.demo.string;

import java.lang.reflect.Field;
import java.util.Random;


public class StringTest {
	static final int MAX = 1000 * 10000;
	static final String[] arr = new String[MAX];
	/**
	 * @param args
	 * @throws Exception 
	 * @throws  
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String a = "abcd";
//		String b = "abcd";
//		System.out.println(a == b);
//		System.out.println(a.equals(b));
//		
//		String c = new String("abcd");
//		String d = new String("abcd");
//		System.out.println(c == d);
//		System.out.println(c.equals(d));
//		System.out.println(c == b);
//		System.out.println(c.equals(b));
		
//		String m = "hello,world";
//		String n = "hello,world";
//		String u = new String(m);
//		String v = new String("hello,world");
//		
//		Field field = m.getClass().getDeclaredField("value");
//		field.setAccessible(true);
//		char[] value = (char[]) field.get(m);
//		System.out.println(value);
//		value[0] = 'Y';
//		//field.set(m, value);
//		
//		System.out.println(m);
//		System.out.println(n);
//		System.out.println(u);
//		System.out.println(v);
		
//		String m = "hello,world";
//		String v = new String("hello,world");
//		Field field = m.getClass().getDeclaredField("value");
//		field.setAccessible(true);
//		char[] value = (char[]) field.get(m);
//		value[0] = 'Y';
//		
//		System.out.println(m);
//		System.out.println(v);
//		new B().print();
		
//		String m = "hello,world";
//		String u = m.substring(2,10);
//		String v = u.substring(2,7);
//		
//		Field field = m.getClass().getDeclaredField("value");
//		field.setAccessible(true);
//		char[] value = (char[]) field.get(m);
//		value[5] = 'Y';
//		System.out.println(m);
//		System.out.println(u);
//		System.out.println(v);
		
		
		
//		String m = "hello,world";
//		String u = m.replace('o', 'Y');
//		String v = m +"abc";
//		String x = new String(m.substring(2, 10));
//		
//		Field field = m.getClass().getDeclaredField("value");
//		field.setAccessible(true);
//		char[] value = (char[]) field.get(m);
//		value[5] = 'Y';
//		System.out.println(m);
//		System.out.println(u);
//		System.out.println(v);
//		System.out.println(x);
		
		
//		final String m = "hello,world";
//		String u = m + ".";
//		String v = "hello,world.";
//		
//		Field field = m.getClass().getDeclaredField("value");
//		field.setAccessible(true);
//		char[] value = (char[]) field.get(u);
//		value[5] = 'Y';
//		System.out.println(u);
//		System.out.println(v);
		
		
//		String s1 = new String("1");
//		s1.intern();
//		String s2 = "1";
//		System.out.println(s1 == s2);
//		
//		String s3 = new String("1") + new String("1");
//		s3.intern();
//		String s4 = "11";
//		System.out.println(s3 == s4);
		
		Integer[] DB_DATA = new Integer[10];
		Random random = new Random(10 * 10000);
		for (int i = 0; i < DB_DATA.length; i++) {
			DB_DATA[i] = random.nextInt();
		}
		long t = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
		}
		
		System.out.println(System.currentTimeMillis() - t);
		System.gc();
	}
}

class B{
	void print(){
		System.out.println("hello,world");
	}
}
