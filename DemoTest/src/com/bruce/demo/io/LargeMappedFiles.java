package com.bruce.demo.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class LargeMappedFiles {
	static int length = 0x8FFFFFF;
	public static void main(String[] args) throws Exception, IOException {
		//RandomAccessFile outFile = new RandomAccessFile("test.dat", "rw");
		FileOutputStream outFile = new FileOutputStream("test.dat");
		MappedByteBuffer out = outFile.getChannel().map(
				MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		System.out.println("Finished writing");
		
		for(int i = length/2; i< length/2+6; i++){
			System.out.println((char)out.get(i));
		}
	}
}
