package com.bruce.demo.enumerated;

public enum OverrideConstantSpecific {
	NUT,BOLT,
	WASHER{
		public void f() {
			// TODO Auto-generated method stub
			System.out.println("Overridden Method");
		}
		
	}
	;
	public void f(){
		System.out.println("Default behavior");
	}
	public static void main(String[] args) {
		for(OverrideConstantSpecific ocs : values()){
			System.out.print(ocs + ":");
			ocs.f();
		}
	}
}
