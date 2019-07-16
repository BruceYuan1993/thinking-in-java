package com.bruce.demo.io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	public static void main(String[] args) throws Exception{
		FileOutputStream out = new FileOutputStream("file.txt");
		FileLock lock = out.getChannel().tryLock();
		if (lock != null) {
			System.out.println("LockedFile");
			TimeUnit.MILLISECONDS.sleep(100);
			lock.release();
			System.out.println("Released Lock");
		}
		out.close();
	}
}
