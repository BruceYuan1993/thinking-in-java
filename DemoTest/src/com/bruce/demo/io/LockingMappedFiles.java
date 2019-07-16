package com.bruce.demo.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;


public class LockingMappedFiles {
	static int length = 0x8FFFFFF;
	static FileChannel fc;
	
	public static void main(String[] args) throws Exception{
		fc = new RandomAccessFile("test.dat", "rw").getChannel();
		MappedByteBuffer out = fc.map(MapMode.READ_WRITE, 0, length);
		for(int i = 0; i< length; i++){
			out.put((byte)'x');
		}
		new LockAndModiy(out, 0, length/3);
		new LockAndModiy(out, length/2, length/2 + length/4);
	}
	
	private static class LockAndModiy extends Thread{
		private ByteBuffer buff;
		private int start,end;
		public LockAndModiy(ByteBuffer mbb, int start, int end) {
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();
			start();
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				FileLock lock = fc.lock(start, end, false);
				System.out.println("Locked : " + start + " to "+ end);
				
				while (buff.position() < buff.limit() - 1) {
					buff.put((byte)(buff.get() + 1));
				}
				
				lock.release();
				
				System.out.println("Released : " + start + " to "+ end);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
