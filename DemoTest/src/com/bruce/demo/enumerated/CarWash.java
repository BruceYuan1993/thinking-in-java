package com.bruce.demo.enumerated;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle{
		UNDERBODY {
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("Sparying the underbody");
			}
		},
		WHEELWASH {
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("Washing the wheels");
			}
		},
		PREWASH{
			public void action(){
				System.out.println("Loosening the dirt");
			}
		},
		BASIC{
			public void action(){
				System.out.println("The basic wash");
			}
		},
		HOTWAX{
			public void action(){
				System.out.println("Applying hot wax");
			}
		},
		RINSE{
			public void action(){
				System.out.println("Rinsing");
			}
		},
		BLOWDRY{
			public void action(){
				System.out.println("Blowing dry");
			}
		}
		;
		abstract void action();
	}
	
	EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);
	public void add(Cycle cycle){
		cycles.add(cycle);
	}
	public void washCar(){
		for(Cycle c : cycles){
			c.action();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cycles.toString();
	}
	
	public static void main(String[] args) {
		CarWash wash = new CarWash();
		System.out.println(wash);
		wash.washCar();
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.RINSE);
		wash.add(Cycle.HOTWAX);
		System.out.println(wash);
		wash.washCar();
	}
	
}
