package com.bruce.demo.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

 class ShowMethods {
	private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n" +
								"To Show all methods in class or:\n" +
								"ShowMethods qualified.class.name word\n" +
								"To search for methods involving 'word'";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods =  c.getMethods();
			Constructor<?>[] ctors = c.getDeclaredConstructors();
				//c.getConstructors();
			if (args.length == 1) {
				for (Method m : methods) {
					System.out.println(m.toString());
				}
				for (Constructor<?> cstor : ctors) {
					System.out.println(cstor.toString());
				}
				lines = methods.length + ctors.length;
			}else {
				for (Method m : methods) {
					if (m.toString().indexOf(args[1]) != -1) {
						System.out.println(m.toString());
						lines++;
					}
					//System.out.println(m.toString());
				}
				for (Constructor<?> cstor : ctors) {
					if (cstor.toString().indexOf(args[1]) != -1) {
						System.out.println(cstor.toString());
						lines++;
					}
					//System.out.println(cstor.toString());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
