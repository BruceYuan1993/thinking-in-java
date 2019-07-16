package com.bruce.demo.exception;

public class MultipleReturns {
	public static void f(int i){
		try {
			System.out.println("Point 1");
			if(i == 1)
				return;
			System.out.println("Point 2");
			if(i == 2)
				return;
			System.out.println("Point 3");
			if(i == 3)
				return;
			System.out.println("end");
			return;
		} finally{
			System.out.println("Clean up");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 5; i++) {
			f(i);
		}
	}

}
