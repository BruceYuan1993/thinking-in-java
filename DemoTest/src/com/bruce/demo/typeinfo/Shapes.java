package com.bruce.demo.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


abstract class Shape{
	void draw(){
		System.out.println(this + ".draw()");
		
	}

	@Override
	abstract public String toString();
}
class Circle extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
	
}
class Square extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square";
	}
	
}
class Triahgle extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triahgle";
	}
	
}
public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),new Triahgle());
		for(Shape shape : shapeList){
			shape.draw();
		}
	}
}
