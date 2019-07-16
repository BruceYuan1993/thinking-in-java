package com.bruce.demo.enumerated;

import com.bruce.demo.enumerated.Food.Appetizer;
import com.bruce.demo.enumerated.Food.Coffee;
import com.bruce.demo.enumerated.Food.Dessert;
import com.bruce.demo.enumerated.Food.MainCourse;

public class TypeOfFood {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food = Appetizer.SALAD;
		System.out.println(food.getClass());
		food = MainCourse.LASAGNE;
		System.out.println(food.getClass());
		food = Dessert.GELATO;
		System.out.println(food.getClass());
		food = Coffee.CAPPUCCINO;
		System.out.println(food.getClass());
	}

}
