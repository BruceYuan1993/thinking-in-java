package com.bruce.demo.exception;

class SimpleException extends Exception{
	
}
public class InheritingExceptions extends Exception{
	public void f() throws SimpleException{
		System.out.println("throw simpleException from f()");
		throw new SimpleException();
	}
	
	public void m() throws Exception {
		f();
	}
	
	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.m();
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println("1-----" + e.getMessage());
//			System.out.println("2-----" + e.getLocalizedMessage());
//			
//			System.out.println(e.getClass().getName());
//			//e.fillInStackTrace()
//			e.printStackTrace(System.err);
//			System.out.println("-------------->");
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element);
			}
		}
	}
}
