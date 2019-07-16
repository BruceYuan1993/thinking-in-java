package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private static  final int BSIZE = 1024;
	public static void main(String[] args) {
		String src = "data.txt";
		String dest = "databack.txt";
		
		try {
			FileChannel 
			out = new FileOutputStream(dest).getChannel(),
			in = new FileInputStream(src).getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
			while (in.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
