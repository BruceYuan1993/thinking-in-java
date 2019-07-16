package com.bruce.demo.annotations;


@UseCase
public class BaseObject {
	@UseCase
	private int id;
	@UseCase
	public String name;
	@UseCase
	protected void printTest(@UseCase int i){
		System.out.println(i);
	}
}
