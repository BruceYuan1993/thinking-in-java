package com.bruce.demo.basic;

import java.io.FileNotFoundException;

class Glyph{
	void draw() throws NullPointerException{
		System.out.println("Glphy.draw()");
	}
	public Glyph() throws NullPointerException,FileNotFoundException{
		// TODO Auto-generated constructor stub
		System.out.println("Glphy() before draw()");
		draw();
		System.out.println("Glphy() after draw()");
	}
}

class RoundGlyph extends Glyph{
	private int redius = 1;
	RoundGlyph(int r) throws NullPointerException,FileNotFoundException{
		redius = r;
		System.out.println("RoundGlyph.RoundGlyph(), redius = " + redius);
	}
	 void draw() throws NullPointerException{
		System.out.println("RoundGlyph.draw(), redius = " + redius);
	}
}
public class PolyConstructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new RoundGlyph(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
