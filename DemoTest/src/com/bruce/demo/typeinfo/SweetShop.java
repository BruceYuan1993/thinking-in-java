package com.bruce.demo.typeinfo;



class Candy{
	static {
		System.out.println("Loading Candy");
	}
}
class Gum{
	static {
		System.out.println("Loading Gum");
	}
}
class Cookie{
	static {
		System.out.println("Loading Cookie");
	}
}
public class SweetShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main");
		new Candy();
		System.out.println("After Creating Candy");
		try {
			Class<?> c = Class.forName("com.bruce.demo.typeinfo.Gum");
			System.out.println(c.getClassLoader().toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After Creating Candy");
		new Cookie();
		System.out.println(Object.class.getClassLoader());
	}

}
