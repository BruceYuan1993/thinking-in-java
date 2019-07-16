package com.bruce.demo.thread;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InputStream socket = new Socket("localhost",8080).getInputStream();
		exec.execute(new IOBlocked(socket));
		exec.execute(new IOBlocked(System.in));
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Closing " + socket.getClass().getName());
		socket.close();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Closing " + System.in.getClass().getName());
		System.in.close();
	}
}
