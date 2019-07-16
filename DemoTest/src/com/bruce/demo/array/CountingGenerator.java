package com.bruce.demo.array;


import com.bruce.demo.generics.Generator;

public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean>{
		private boolean value = false;
		@Override
		public java.lang.Boolean next() {
			// TODO Auto-generated method stub
			value = !value;
			return value;
		}
		
	}
	
	
	public static class Byte implements Generator<java.lang.Byte>{
		private byte value = 0;
		@Override
		public java.lang.Byte next() {
			// TODO Auto-generated method stub
			return value++;
		}
		
	}
	
	static char[] chars = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static class Character implements Generator<java.lang.Character>{
		int index = -1;
		@Override
		public java.lang.Character next() {
			// TODO Auto-generated method stub
			index = (index + 1) % chars.length;
			return chars[index];
		}
		
	}
	
	
	public static class String implements Generator<java.lang.String>{
		private int length = 7;
		
		Generator<java.lang.Character> cg = new Character();
		public String(){}
		
		public String(int length){
			this.length = length;
		}
		@Override
		public java.lang.String next() {
			// TODO Auto-generated method stub
			char[] buf = new char[length];
			for (int i = 0; i < buf.length; i++) {
				buf[i] = cg.next();
			}
			return new java.lang.String(buf);
		}
	}
	
}
