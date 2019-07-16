package com.bruce.demo.enumerated;

import java.util.Random;


enum Outcome{
	WIN,LOSE,DRAW
}
interface Item{
	Outcome compete(Item it);
	Outcome eval(Paper p);
	Outcome eval(Scissors s);
	Outcome eval(Rock r);
}
class Rock implements Item{

	@Override
	public Outcome compete(Item it) {
		// TODO Auto-generated method stub
		return it.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		// TODO Auto-generated method stub
		return Outcome.WIN;
	}

	@Override
	public Outcome eval(Scissors s) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.DRAW;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rock";
	}
	
}
class Scissors implements Item{

	@Override
	public Outcome compete(Item it) {
		// TODO Auto-generated method stub
		return it.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Scissors s) {
		// TODO Auto-generated method stub
		return Outcome.DRAW;
	}

	@Override
	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.WIN;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Scissors";
	}
}
class Paper implements Item{

	@Override
	public Outcome compete(Item it) {
		// TODO Auto-generated method stub
		return it.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		// TODO Auto-generated method stub
		return Outcome.DRAW;
	}

	@Override
	public Outcome eval(Scissors s) {
		// TODO Auto-generated method stub
		return Outcome.WIN;
	}

	@Override
	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Paper";
	}
	
}
public class RoShamBo1 {
	static final int SIZE = 20;
	public static Random random = new Random(47);
	public static Item newItem(){
		switch (random.nextInt(3)) {
		default:
		case 0:
			return new Scissors();
		case 1:
			return new Paper();
		case 2:
			return new Rock();
		}
	}
	public static void match(Item a, Item b){
		System.out.println(a + " vs. "+b+": "+a.compete(b));
	}
	public static void main(String[] args) {
		for (int i = 0; i < SIZE; i++) {
			match(newItem(), newItem());
		}
	}
}
