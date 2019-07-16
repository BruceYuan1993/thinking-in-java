package com.bruce.demo.typeinfo.typecounter;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PetCount3 {
	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{
		public PetCounter(){
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}
		public void count(Pet pet){
			for (Entry<Class<? extends Pet>, Integer> pair: entrySet()) {
				if (pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue()+1);
				}
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder result = new StringBuilder("{");
			for (Entry<Class<? extends Pet>, Integer> pair: entrySet()){
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(",");
			}
			result.delete(result.length() - 1, result.length());
			result.append("}");
			return result.toString();
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for (Pet pet : Pets.createArray(20)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		System.out.println("\n");
		System.out.println(petCount);
	}
}
