package com.bruce.demo.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class Customer{
	private static long counter = 1;
	private final long id = counter++;
	private Customer(){}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Coustomer " + id;
	}
	
	public static Generator<Customer> generator(){
		return new Generator<Customer>() {
			
			@Override
			public Customer next() {
				// TODO Auto-generated method stub
				return new Customer();
			}
		};
	}
}

class Teller{
	private static long counter = 1;
	private final long id = counter++;
	private Teller(){}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Teller " + id;
	}
	public static  Generator<Teller> generator = new Generator<Teller>() {
		
		@Override
		public Teller next() {
			// TODO Auto-generated method stub
			return new Teller();
		}
	};
}
public class BankTeller {
	public static void serve(Teller t, Customer c){
		System.out.println(t + " serve " + c);
	}
	
	public static void main(String[] args) {
		Random random = new Random(47);
		Queue<Customer> lines = new LinkedList<Customer>();
		Generators.fill(lines, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<Teller>();
		Generators.fill(tellers, Teller.generator, 4);
		for (Customer customer : lines) {
			serve(tellers.get(random.nextInt(tellers.size())), customer);
		}
	}
}
