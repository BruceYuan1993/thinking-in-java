package com.bruce.demo.annotations;

import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;


public class Bigram {
	private final char first;
	private final char second;
	
	public Bigram(char first, char second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Bigram)){
			return false;
		}
		Bigram b = (Bigram) obj;
		return b.first == first && b.second == second ;
	}



	public int hashCode() {
		// TODO Auto-generated method stub
		return 31*first + second;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Bigram> set = new HashSet<Bigram>();
		for (int i = 0; i < 10; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				set.add(new Bigram(ch, ch));
			}
		}
		System.out.println(set.size());
	}

}
