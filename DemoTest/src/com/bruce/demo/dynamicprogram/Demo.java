package com.bruce.demo.dynamicprogram;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class Demo {
	public static void main(String[] args) throws Exception {
		System.out.println("begin");
		Greeter greeter = new Greeter();
		System.out.println("createred");
		greeter.greet();
		
		System.out.println(incrementField("count", greeter));
		int[] a = {1,2,3};
		Object b = growArray(a,7);
		System.out.println(Array.getLength(b));
		System.out.println(b.getClass().getComponentType());
		
		
		Message msg = new Message("x");
		Field field = msg.getClass().getDeclaredField("m_text");
		field.setAccessible(true);
		field.get(msg);
	}
	
	public static int incrementField(String name, Object obj) throws Exception {
	    Field field = obj.getClass().getDeclaredField(name);
	    int value = field.getInt(obj) + 1;
	    field.setInt(obj, value);
	    return value;
	}
	public static Object growArray(Object array, int size)
	{
		Class<?> t = array.getClass().getComponentType();
		Object newArray = Array.newInstance(t, size);
		System.arraycopy(array, 0, newArray, 0, Math.min(Array.getLength(array), size));
		return newArray;
		
	}
}
class Greeter{
	public int count = 3;
	private static Message msg = new Message("Hello World");
	public void greet(){
		msg.print(System.out);
	}
}
class Message{
	private String m_text;
	public Message(String text){
		m_text = text;
	}
	public void print(PrintStream ps)
	{
		ps.print(m_text);
	}
}
