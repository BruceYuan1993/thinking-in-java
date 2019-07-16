package com.bruce.demo.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor{

	public DaemonThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L,TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
		// TODO Auto-generated constructor stub
	}

}
