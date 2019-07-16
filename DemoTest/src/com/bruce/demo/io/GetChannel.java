package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static  final int BSIZE = 1024;
	
	public static void main(String[] args) {
		try {
			FileChannel fc = new FileOutputStream("data.txt").getChannel();
			fc.write(ByteBuffer.wrap("Some text".getBytes()));
			fc.close();
			
			fc = new RandomAccessFile("data.txt", "rw").getChannel();
			fc.position(fc.size());
//			ByteBuffer test =  ByteBuffer.allocate(2000);
//			test.put("Some more test".getBytes("UTF-8"));
//			System.out.println("Some more test".getBytes().length);
//			//test.limit("Some more test".getBytes().length);
//			fc.write(test);
			
			fc.write(ByteBuffer.wrap("Some more".getBytes()));
			fc.close();
			
			fc = new FileInputStream("data.txt").getChannel();
			ByteBuffer buff = ByteBuffer.allocate(BSIZE);
			fc.read(buff);
			buff.flip();
			System.out.println(buff.capacity());
			//buff.position(buff.limit());
			while (buff.hasRemaining()) {
				System.out.print((char)buff.get());
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
