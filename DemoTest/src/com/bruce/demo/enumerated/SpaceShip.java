package com.bruce.demo.enumerated;

public enum SpaceShip {
	SCOUT,CARGO,MOTHERSHIP;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String supername = super.toString();
		String methodname = name();
		System.out.println(supername.equals(methodname));
		String lower = methodname.substring(1).toLowerCase();
		return methodname.charAt(0) + lower;
	}
	
	public static void main(String[] args){
		for(SpaceShip s : SpaceShip.values()){
			System.out.println(s);
		}
	}
	
}
