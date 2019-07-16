package com.bruce.demo.exception;

class VeryImportantException extends Exception{

	@Override
	public String toString() {
		return "a very important Exception";
	}
	
}

class HohumException extends Exception{
	@Override
	public String toString() {
		return "a trivial Exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	
	void dispose() throws HohumException{
		throw new HohumException();
	}
	
	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} catch (Exception e) {
				// TODO: handle exception
				//System.out.println(e);
			}finally{
				lm.dispose();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} 
	}
}
