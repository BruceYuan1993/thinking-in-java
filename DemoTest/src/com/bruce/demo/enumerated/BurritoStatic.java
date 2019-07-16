package com.bruce.demo.enumerated;

import com.bruce.demo.enumerated.EnumDemo.Spiciness;

import static com.bruce.demo.enumerated.EnumDemo.Spiciness.*;

public class BurritoStatic {
    Spiciness degress;
	public BurritoStatic(Spiciness degress) {
		this.degress = degress;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BurritoStatic is " + degress.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BurritoStatic(NOT));
		System.out.println(new BurritoStatic(MEDIUM));
		System.out.println(new BurritoStatic(HOT));
	}

}
