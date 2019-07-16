package com.bruce.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TransferTo {
	public static void main(String[] args) {
		String src = "data.txt";
		String dest = "databack.txt";
		
		try {
			FileChannel 
			out = new FileOutputStream(dest).getChannel(),
			in = new FileInputStream(src).getChannel();
			
			//in.transferTo(0, in.size(), out);
			out.transferFrom(in, 0, in.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
