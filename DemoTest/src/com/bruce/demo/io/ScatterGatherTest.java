package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterGatherTest {
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		ByteBuffer bb1 = ByteBuffer.allocate(10);
		ByteBuffer bb2 = ByteBuffer.allocate(4);
		bb1.put("ab".getBytes());
		bb2.put("cd".getBytes());
		bb1.flip();
		bb2.flip();
		fc.write(new ByteBuffer[]{bb1,bb2});
		
		FileChannel fc1 = new FileInputStream("data2.txt").getChannel();
		bb1.clear();
		bb2.clear();
		fc1.read(new ByteBuffer[]{bb1,bb2});
		bb1.rewind();
		bb2.rewind();
		while (bb1.hasRemaining()) {
			System.out.println((char)bb1.get());
		}
		while (bb2.hasRemaining()) {
			System.out.println((char)bb2.get());
		}
	}
}
