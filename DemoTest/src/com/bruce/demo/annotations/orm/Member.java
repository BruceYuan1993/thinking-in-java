package com.bruce.demo.annotations.orm;

@DBTable(name = "Student")
public class Member {
	@SQLString(30)
	private String firstName;
	@SQLString(30)
	private String lastName;
	@SQLInteger
	private int age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	private String handleString;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHandleString() {
		return handleString;
	}
	public void setHandleString(String handleString) {
		this.handleString = handleString;
	}
	static int memberCount;
}
