package com.bruce.demo.exception;

import java.util.ArrayList;

class Annoyance extends Exception{}
class Sneeze extends Annoyance{}

public class Human {
	public static void main(String[] args) {
		try {
			throw new Sneeze();
		} catch (Sneeze e) {
			// TODO: handle exception
			System.out.println("Sneeze");
		} catch (Annoyance e) {
			// TODO: handle exception
			System.out.println("Annoyance");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
		} 
		
		
//		try {
//			throw new Sneeze();
//		} catch (Annoyance e) {
//			// TODO: handle exception
//			System.out.println("Annoyance");
//		} catch (Sneeze e) {
//			// TODO: handle exception
//			System.out.println("Sneeze");
//		} 
	}
}
