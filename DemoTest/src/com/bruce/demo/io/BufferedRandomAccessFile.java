package com.bruce.demo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class BufferedRandomAccessFile extends RandomAccessFile{

	public BufferedRandomAccessFile(File file, String mode) throws FileNotFoundException {
		super(file, mode);
		// TODO Auto-generated constructor stub
		//BufferedInputStream 
	}
	
}
