package com.bruce.demo.enumerated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

abstract class Flower{
	abstract void accept(IIVisitor visitor);
	String getName() {
		return this.getClass().getSimpleName();
	}
}
class Gladiolus extends Flower{

	@Override
	public void accept(IIVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
class Runuculus extends Flower{

	@Override
	public void accept(IIVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
class Chrysanthemum extends Flower{

	@Override
	public void accept(IIVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}

interface IIVisitor{
	void visit(Gladiolus g);
	void visit(Runuculus g);
	void visit(Chrysanthemum g);
}
class StringVal implements IIVisitor{
	private String s;
	@Override
	public void visit(Gladiolus g) {
		// TODO Auto-generated method stub
		s = g.getName();
	}

	@Override
	public void visit(Runuculus g) {
		// TODO Auto-generated method stub
		s = g.getName();
	}

	@Override
	public void visit(Chrysanthemum g) {
		// TODO Auto-generated method stub
		s = g.getName();
	}
	public String toString(){
		return s;
	}
}

class Bee implements IIVisitor{
	private String s = "Bee ";
	@Override
	public void visit(Gladiolus g) {
		// TODO Auto-generated method stub
		s += g.getName();
	}

	@Override
	public void visit(Runuculus g) {
		// TODO Auto-generated method stub
		s += g.getName();
	}

	@Override
	public void visit(Chrysanthemum g) {
		// TODO Auto-generated method stub
		s += g.getName();
	}
	public String toString(){
		return s;
	}
}

class FlowerGenerator {
	private static Random random = new Random(47);
	public static Flower newFlower(){
		switch (random.nextInt(3)) {
		case 0:
			return new Gladiolus();
		case 1:
			return new Runuculus();
		case 2:
			return new Chrysanthemum();
		default :
			return null;
		}
	}
}

public class VisitorPatternTest {
	
	public static void main(String[] args) {
		List flowers = new ArrayList();
		for(int i = 0; i < 10; i++)
			flowers.add(FlowerGenerator.newFlower());
		IIVisitor sval = new Bee();
		Iterator it = flowers.iterator();
		while(it.hasNext()) {
			((Flower)it.next()).accept(sval);
			System.out.println(sval);
		}
	}
}
