package com.bruce.demo.annotations.hibernate;

@Property(column = "Person_age", type = "int")
@Persistent(table = "Person_table")
public class Person {
	@Property(column = "Person_age", type = "int")
	@IdProperty(column = "Person_id", generator = "identity", type = "int")
	private int id;
	
	@Property(column = "Person_name", type = "varchar")
	private String name;
	
	@Property(column = "Person_age", type = "int")
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
