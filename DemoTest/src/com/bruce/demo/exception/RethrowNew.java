package com.bruce.demo.exception;

class OneException extends Exception{
	public OneException(String s) {
		super(s);
	}
}
class TwoException extends Exception{
	public TwoException(String s) {
		super(s);
	}
}

public class RethrowNew {
	public static void f() throws OneException{
		System.out.println("Originating the exception in f()");
		throw new OneException("thrown from f()");
	}
	
	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				// TODO: handle exception
				System.out.println("Caught in inner try, printStackTrace");
				e.printStackTrace(System.out);
				throw new TwoException("From inner try");
			}
		} catch (TwoException e) {
			// TODO: handle exception
			System.out.println("Caught in outter try, printStackTrace");
			e.printStackTrace(System.out);
		}
		
	}
}
