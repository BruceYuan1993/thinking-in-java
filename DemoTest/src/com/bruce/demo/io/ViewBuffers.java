package com.bruce.demo.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind();
		
		System.out.println("Byte Buffer ");
		while (bb.hasRemaining()) {
			System.out.print(bb.position() + " --> " + bb.get() +",  ");
		}
		System.out.println();
		
		
		System.out.println("Char Buffer ");
		CharBuffer cb = bb.asCharBuffer();
		//CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
		while (cb.hasRemaining()) {
			System.out.print(cb.position() + " --> " + cb.get() +",  ");
		}
		System.out.println();
		
		
		System.out.println("ShortBuffer ");
		ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
		while (sb.hasRemaining()) {
			System.out.print(sb.position() + " --> " + sb.get() +",  ");
		}
		System.out.println();
		
		System.out.println("FloatBuffer Buffer ");
		FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
		while (fb.hasRemaining()) {
			System.out.print(fb.position() + " --> " + fb.get() +",  ");
		}
		System.out.println();
		
		
		System.out.println("IntBuffer ");
		IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		while (ib.hasRemaining()) {
			System.out.print(ib.position() + " --> " + ib.get() +",  ");
		}
		System.out.println();
		
		System.out.println("LongBuffer ");
		LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
		while (lb.hasRemaining()) {
			System.out.print(lb.position() + " --> " + lb.get() +",  ");
		}
		System.out.println();
		
		
		
		System.out.println("Double ");
		DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
		while (db.hasRemaining()) {
			System.out.print(db.position() + " --> " + db.get() +",  ");
		}
		System.out.println();
	}
}
