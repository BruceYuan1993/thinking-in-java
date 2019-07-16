package com.bruce.demo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));
		try {
			byte[] data = new byte[in.available()];
			in.read(data);
			return data;
		} finally {
			// TODO: handle finally clause
			in.close();
		}
	}
	
	
}
