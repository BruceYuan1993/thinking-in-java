package com.bruce.demo.generics;

import java.awt.Color;

interface HasColor{
	Color getColor();
}

class Colored<T extends HasColor>{
	T item;
	public Colored(T item) {
		this.item = item;
	}
	Color color(){
		return item.getColor();
	}
}

class Dimension{
	public int x, y, z;
}

//class ColoredDimension<T extends HasColor & Dimension>{
//	
//}
class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	ColoredDimension(T item){
		this.item = item;
	}
	Color color(){
		return item.getColor();
	}
	int getX(){
		return item.x;
	}
	int getY(){
		return item.y;
	}
	int getZ(){
		return item.z;
	}
}

interface Weight{
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight>{
	T item;
	Solid(T item){
		this.item = item;
	}
	Color color(){
		return item.getColor();
	}
	int getX(){
		return item.x;
	}
	int getY(){
		return item.y;
	}
	int getZ(){
		return item.z;
	}
	int weigth(){
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor,Weight{

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class BasicBounds {
public static void main(String[] args) {
	Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
	solid.color();
	solid.getY();
	solid.weigth();
}
}
