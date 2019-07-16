package com.bruce.demo.typeinfo.nullobject;

public class Position {
	private String title;
	private Person person;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
		if (this.person == null){
			this.person = Person.NULL;
		}
	}
	public Position(String title, Person person) {
		super();
		this.title = title;
		this.person = person;
		if (this.person == null){
			this.person = Person.NULL;
		}
	}
	public Position(String title) {
		super();
		this.title = title;
		this.person = Person.NULL;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Position: "+title +" " + person;
	}
}
