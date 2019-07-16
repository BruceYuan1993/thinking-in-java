package com.bruce.demo.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Apply {
	public static <T, S extends Iterable<? extends T>> void apply(S seq,
			Method f, Object... args) {
		for (T t : seq) {
			try {
				f.invoke(t, args);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Shape1 {
	public void rotate() {
		System.out.println(this + "totate");
	}

	public void resize(int newSize) {
		System.out.println(this + " resize " + newSize);
	}
}

class Square extends Shape1 {
}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			while (--size > 0) {

				add(type.newInstance());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SimpleQueue<T> implements Iterable<T>{
	private LinkedList<T> storage = new LinkedList<T>();
	public void add(T t){
		storage.offer(t);
	}
	public T get(){
		return storage.poll();
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return storage.iterator();
	}
	
}

class ApplyTest{
	public static void main(String[] args) throws Exception{
		List<Shape1> shapes = new ArrayList<Shape1>();
		for (int i = 0; i < 10; i++) {
			shapes.add(new Shape1());
		}
		Apply.apply(shapes, Shape1.class.getMethod("rotate"));
		Apply.apply(shapes, Shape1.class.getMethod("resize",int.class), 5);
		
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < 10; i++) {
			squares.add(new Square());
		}
		Apply.apply(squares, Shape1.class.getMethod("rotate"));
		Apply.apply(squares, Shape1.class.getMethod("resize",int.class), 5);
		
		Apply.apply(new FilledList<Shape1>(Shape1.class, 10), Shape1.class.getMethod("rotate"));
		Apply.apply(new FilledList<Square>(Square.class, 10), Shape1.class.getMethod("rotate"));
		
		SimpleQueue<Shape1> shapeQ = new SimpleQueue<Shape1>();
		for (int i = 0; i < 5; i++) {
			shapeQ.add(new Shape1());
			shapeQ.add(new Square());
		}
		Apply.apply(shapeQ, Shape1.class.getMethod("rotate"));
	}
}
