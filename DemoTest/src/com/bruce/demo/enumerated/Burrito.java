package com.bruce.demo.enumerated;

import com.bruce.demo.enumerated.EnumDemo.Spiciness;

public class Burrito {
	Spiciness degress;

	public Burrito(Spiciness degress) {
		this.degress = degress;
	}
	
	public void describe(){
		System.out.print("this burrito is ");
		switch(degress) {
			case NOT:
				System.out.println("not spicy at all.");
				break;
			case MILD:
			case MEDIUM:
				System.out.println("a little hot.");
				break;
			case HOT:
			case FLAMING:
			default :
				System.out.println("maybe too hot.");
		}
	}
	
	public static void main(String[] args){
		Burrito plain = new Burrito(Spiciness.NOT),
			greenChile = new Burrito(Spiciness.MEDIUM),
			jalapeno = new Burrito(Spiciness.HOT);
		plain.describe();
		greenChile.describe();
		jalapeno.describe();
	}
}
