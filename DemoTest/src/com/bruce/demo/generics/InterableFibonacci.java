package com.bruce.demo.generics;

import java.util.Iterator;

public class InterableFibonacci 
					//extends Fibonacci 
					implements Iterable<Integer>{
	private int n;
	private Fibonacci fibonacci = new Fibonacci();
	
	protected InterableFibonacci(int n) {
		this.n = n;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (n > 0);
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				n--;
				return InterableFibonacci.this.fibonacci.next();
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
		InterableFibonacci fibonacci = new InterableFibonacci(18);
		for (int i : fibonacci) {
			System.out.print(i + "    ");
		}
	}
}
