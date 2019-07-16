package com.bruce.demo.typeinfo.nullobject;
public class Person {
	public final String first;
	public final String last;
	public final String address;
	
	public Person(String first, String last, String address){
		this.first = first;
		this.last = last;
		this.address = address;
	}
	public String toString(){
		return "Person: "+first + " " + last + " " +address;
	}
	static class NullPerson extends Person implements Null{

		public NullPerson() {
			super("none", "none", "none");
			// TODO Auto-generated constructor stub
			
		}

		@Override
		public String toString() {
			return "NullPerson";
		}
	}
	public static final Person NULL = new NullPerson();
}
