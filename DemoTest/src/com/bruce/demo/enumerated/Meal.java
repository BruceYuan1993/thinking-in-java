package com.bruce.demo.enumerated;

public class Meal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (Course course: Course.values()) {
				System.out.println(course.randomSelection());
			}
			System.out.println("-------");
		}
		
	}

}
