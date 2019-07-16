package com.bruce.demo.collection;

import java.util.Arrays;
import java.util.List;

import com.bruce.demo.typeinfo.typecounter.Pet;
import com.bruce.demo.typeinfo.typecounter.Pets;

public class ListFeatures {
	public static void main(String[] args) {
		List<Pet> list = Pets.arrayList(2);
		//System.out.println(list);
		//list.addAll(1, Arrays.asList(new Pet()));
		//System.out.println(list);
		Object[] ar1 =  list.toArray();
		System.out.println(Arrays.toString(ar1));
		Pet[] ar3 = new Pet[]{ new Pet(),new Pet(),new Pet(),new Pet(),new Pet()};
		System.out.println(Arrays.toString(ar3));
		Pet[] ar2 = list.toArray(ar3);
		System.out.println(Arrays.toString(ar2));
	}
}
