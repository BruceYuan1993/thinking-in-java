package com.bruce.demo.typeinfo;


interface HasBatteries {}
interface Waterproof{}
interface Shoots{}
interface NewInterface{}
class Toy{
	Toy() {
		// TODO Auto-generated constructor stub
	}
	Toy(int i){
		
	}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots,NewInterface{
	FancyToy() {
		// TODO Auto-generated constructor stub
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc){
		System.out.println("Class name: "+cc.getName()+" is interface?["+cc.isInterface()+"]");
		System.out.println("Simple name: "+ cc.getSimpleName());
		System.out.println("Canonical name: "+cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.bruce.demo.typeinfo.FancyToy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		printInfo(up);
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
		printInfo(obj.getClass());
		int[] aa = new int[]{1,2,3};
		Class<?> acClass = aa.getClass();
		System.out.println(acClass.getSimpleName());
	}
}
