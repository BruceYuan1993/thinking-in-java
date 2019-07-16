package com.bruce.demo.typeinfo;

class Building{}
class House extends Building{}
public class ClassCasts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building building = new House();
		
		Class<House> houseType = House.class;
		House house = houseType.cast(building);
		House house1 = houseType.cast(new Object());
		house = (House) building;
		Class<Building> buildType = Building.class;
		System.out.println(houseType.asSubclass(buildType));
		
		Integer a = new Integer(1);
		Boolean b = new Boolean(false);
		
		//a = (Integer)b;
	}

}
