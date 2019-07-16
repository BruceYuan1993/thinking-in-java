package com.bruce.demo.thread;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker{

	public NetworkHealthChecker(CountDownLatch latch) {
		super("Network Service", latch);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verifyService() {
		// TODO Auto-generated method stub
		System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
	}

}
