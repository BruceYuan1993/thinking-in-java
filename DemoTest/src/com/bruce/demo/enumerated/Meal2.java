package com.bruce.demo.enumerated;

import com.bruce.demo.util.Enums;

public enum Meal2 {
	APPETIZER(Food2.Appetizer.class),
	MAINCOURSE(Food2.MainCourse.class),
	DESSERT(Food2.Dessert.class),
	COFFEE(Food2.Coffee.class);
	public interface Food2 {
		enum Appetizer implements Food2{
			SALAD , SOUP, SPRING_ROLLS
		}
		enum MainCourse implements Food2{
			LASAGNE, BURRITO, PAD_THAI,
			LENTILS, HUMMOUS, VINDALOO;
		}
		enum Dessert implements Food2{
			TIRAMISU, GELATO, BLACK_FOREST_CAKE,
			FRUIT, CREME_CARAMEL;
		}
		enum Coffee implements Food2{
			BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
			LATTE, CAPPUCCINO, TEA, HERB_TEA;
		}
	}
	private Food2[] values;
	private Meal2(Class<? extends Food2> kind){
		values = kind.getEnumConstants();
	}
	public Food2 randomSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (Meal2 course: Meal2.values()) {
				System.out.println(course.randomSelection());
			}
			System.out.println("-------");
		}
		
	}
}
