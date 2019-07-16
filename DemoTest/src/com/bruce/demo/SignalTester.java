package com.bruce.demo;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalTester {
	public static void main(String[] args) throws InterruptedException {
		
		Signal.handle(new Signal("INT"), new SignalHandler() {

			@Override
			public void handle(Signal arg0) {
				// TODO Auto-generated method stub
				System.out
						.println("Aaarggh, a user is trying to interrupt me!!");
				System.out
						.println("(throw garlic at user, say `shoo, go away')");
			}
		});
		
		Signal.handle(new Signal("TERM"), new SignalHandler() {

			@Override
			public void handle(Signal arg0) {
				// TODO Auto-generated method stub
				System.out
						.println("Aaarggh, a user is trying to interrupt me!!");
				System.out
						.println("(throw garlic at user, say `shoo, go away')");
			}
		});
		
		Signal.handle(new Signal("ILL"), new SignalHandler() {

			@Override
			public void handle(Signal arg0) {
				// TODO Auto-generated method stub
				System.out
						.println("Aaarggh, a user is trying to interrupt me!!");
				System.out
						.println("(throw garlic at user, say `shoo, go away')");
			}
		});
		
		
		for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.print('.');
        }
	}
}
