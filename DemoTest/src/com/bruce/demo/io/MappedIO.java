package com.bruce.demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Random;

public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	
	private abstract static class Tester{
		private String name;
		public Tester(String name){
			this.name = name;
		}
		
		public void runTest(){
			System.out.println(name + ":");
			try{
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration/1.0e9);
				
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}
	private static Tester[] testers = {
			new Tester("Stream Write"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
							new FileOutputStream(new File("temp.tmp"))));
					for(int i =0; i < numOfInts; i++)
						out.writeInt(i);
					out.close();
				}
			},
			
			new Tester("Mapped Write"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib = fc.map(MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
					for(int i =0; i < numOfInts; i++)
						ib.put(i);
					fc.close();
				}
			},
			
			new Tester("Stream Read"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					DataInputStream in = new DataInputStream(new BufferedInputStream(
							new FileInputStream(new File("temp.tmp"))));
					for(int i =0; i < numOfInts; i++)
						in.readInt();
					in.close();
				}
			},
			
			new Tester("Mapped read"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib = fc.map(MapMode.READ_ONLY,0,fc.size()).asIntBuffer();
					while (ib.hasRemaining()) {
						ib.get();
					}
					fc.close();
				}
			},
			
			new Tester("Stream read/write"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					RandomAccessFile fc = new RandomAccessFile("temp.tmp", "rw");
					fc.writeInt(1);
					for(int i = 0; i < numOfUbuffInts; i++){
						fc.seek(fc.length() - 4);
						fc.writeInt(fc.readInt());
					}
					fc.close();
				}
			},
			
			new Tester("Mapped read/Write"){

				@Override
				public void test() throws IOException {
					// TODO Auto-generated method stub
					FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib = fc.map(MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
					ib.put(0);
					
					for(int i = 1; i < numOfUbuffInts; i++){
						ib.put(ib.get(i-1));
					}
					fc.close();
				}
			}
	};
	public static void main(String[] args) {
		for(Tester tester : testers)
		{
			tester.runTest();
		}
	}
}
