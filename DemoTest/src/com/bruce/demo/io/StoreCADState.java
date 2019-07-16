package com.bruce.demo.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable{
	public static final int RED = 1, BLUE = 2, GREEN =3;
	private int xPos, yPos, dimension;
	private static Random random = new Random(47);
	private static int counter = 0;
	
	public abstract void setColor(int newColor);
	public abstract int getColor();
	public Shape(int xPos, int yPos, int dimension) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.dimension = dimension;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass() + "color[" + getColor() +"] xPos[" + xPos + "] yPos[" + yPos +
				"] dim["+dimension +"]\n" ;
	}
	
	public static Shape randomFactory() {
		int xVal = random.nextInt(100);
		int yVal = random.nextInt(100);
		int dim = random.nextInt(100);
		switch (counter++ %3) {
		case 0:
			return new Circle(xVal, yVal, dim);
		case 1:
			return new Square(xVal, yVal, dim);
		case 2:
			return new Line(xVal, yVal, dim);
		default:
			break;
			
		}
		return null;
	}
}

class Circle extends Shape{
	private static int color = RED;
	public Circle(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}

class Square extends Shape{
	private static int color;
	public Square(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
		// TODO Auto-generated constructor stub
		color = RED;
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}


class Line extends Shape{
	private static int color = RED;
	public static void serializeStaticState(ObjectOutputStream os) throws Exception{
		os.writeInt(color);
	}
	
	public static void deserializeStaticState(ObjectInputStream os) throws Exception{
		color = os.readInt();
	}
	
	public Line(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(int newColor) {
		// TODO Auto-generated method stub
		color = newColor;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
}

public class StoreCADState {
	public static void main(String[] args) throws Exception {
		List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		
		List<Shape> shapes = new ArrayList<Shape>();
		for(int i=0; i<10; i++){
			shapes.add(Shape.randomFactory());
		}
		
		
		for(int i=0; i<10; i++){
			((Shape)shapes.get(i)).setColor(Shape.GREEN);
		}
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CadState.out"));
		out.writeObject(shapeTypes);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		System.out.println(shapes);
	}
}
