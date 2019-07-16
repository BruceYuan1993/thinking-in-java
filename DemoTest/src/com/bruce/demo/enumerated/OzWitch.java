package com.bruce.demo.enumerated;

import java.util.Calendar;


public enum OzWitch {
	WEST("Miss Gulch, aka the Wicked Witch of the west"),
	NORTH("Glinda, the Good WItch of the north"),
	EAST("Wicked witch of the east");
	
	private String description;

	OzWitch(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static String getNow(){
		return Calendar.YEAR + "";
	}
	
	public static void main(String[] args){
		for(OzWitch o : OzWitch.values()){
			System.out.println(o.getDescription());
		}
		System.out.println(OzWitch.getNow());
	}
	
	
}
