package com.bruce.demo.exception;

class FourException extends Exception{}
public class AlwaysFinally {
	public static void main(String[] args) {
		try {
			try {
				throw new FourException();
			} finally{
				System.out.println("inner finally");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("outter finally");
		}
	}
}
