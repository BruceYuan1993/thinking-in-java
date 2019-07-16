package com.bruce.demo.exception;

public class Rethrowing {
	public static void f() throws Exception{
		System.out.println("Originating the exception in f()");
		throw new Exception("thrown from f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main:printStackTrace");
			e.printStackTrace(System.out);
		}
		System.out.println("------------------");
		try {
			h();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main:printStackTrace");
			e.printStackTrace(System.out);
		}
	}
}
