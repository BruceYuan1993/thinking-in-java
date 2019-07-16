package com.bruce.demo.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	public static void main(String[] args) {
		char[] data = "UsingBuffers1".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetrixScramable(cb);
		System.out.println(cb.rewind());
		symmetrixScramable(cb);
		System.out.println(cb.rewind());
	}
	public static void symmetrixScramable(CharBuffer buffer){
		while (buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			if (buffer.hasRemaining())
			{
				char c2 = buffer.get();
				buffer.reset();
				buffer.put(c2).put(c1);
			}
			
		}
	}
}
