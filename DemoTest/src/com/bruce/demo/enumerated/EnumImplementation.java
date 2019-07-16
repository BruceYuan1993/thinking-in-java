package com.bruce.demo.enumerated;

import java.util.Random;


enum CartoonCharacter  {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private static Random rand = new Random(47);
	
	public static CartoonCharacter next() {
		// TODO Auto-generated method stub
		return values()[rand.nextInt(values().length)];
	}
}
public class EnumImplementation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i=0;i<10;i++){
			printNext();
			//System.out.println(cc);
		}
	}
	public static <T> void printNext(){
		System.out.print(CartoonCharacter.next()+"------>");
	}
}
