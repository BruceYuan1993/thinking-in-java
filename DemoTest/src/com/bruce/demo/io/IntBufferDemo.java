package com.bruce.demo.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1046 });

		System.out.println(ib.get(3));
		ib.put(3, 1811);
		ib.flip();
		while (ib.hasRemaining()) {
			System.out.println(ib.get());
		}

		System.out.println("*************************************");
		bb.clear();
		while (ib.hasRemaining()) {
			System.out.println(ib.get());
		}
		System.out.println("*************************************");
		
		bb.order(ByteOrder.BIG_ENDIAN);
		
		ib.rewind();
		ib.put(new int[] { 1, 2, 3, 4, 5 });
		ib.flip();
		while (bb.hasRemaining()) {
			System.out.println(bb.get());
		}
	}
}
