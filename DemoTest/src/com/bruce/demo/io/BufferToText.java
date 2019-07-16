package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		fc.read(bb);
		bb.flip();
		System.out.println(bb.asCharBuffer());	
		bb.rewind();
		String encoding = System.getProperty("file.encoding");
		//System.out.println(encoding);
		System.out.println(Charset.forName(encoding).decode(bb));
		
		//Cp1252
		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		bb.clear();
		fc.read(bb);
		bb.flip();
		System.out.println(bb.asCharBuffer());	
		
		
		
		fc = new FileOutputStream("data2.txt").getChannel();
		bb = ByteBuffer.allocate(18);
		bb.asCharBuffer().put("Some text");
		fc.write(bb);
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		bb.clear();
		fc.read(bb);
		bb.flip();
		System.out.println(bb.asCharBuffer());	
	}
}
