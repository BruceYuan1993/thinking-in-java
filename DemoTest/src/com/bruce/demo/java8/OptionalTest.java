package com.bruce.demo.java8;

import java.util.Optional;


class User{
	private String name;
	public User(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}


public class OptionalTest {
	public static void main(String[] args) {
		Optional<User> user = Optional.of(new User(null));
		user.ifPresent(System.out::println);
		//user = user.empty();
		System.out.println(user.orElseGet(() -> getANewUser()).getName());
		//user.orElseThrow(()-> new NullPointerException("AA"));
		System.out.println(user.map(x -> x.getName()).map(x -> x.charAt(0)).orElse('a'));
	}
	
	
	private static User getANewUser(){
		return new User("BB");
	}
}
