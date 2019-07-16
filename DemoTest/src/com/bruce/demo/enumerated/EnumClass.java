package com.bruce.demo.enumerated;

public class EnumClass {
	enum Shrubbery{
		GROUND,CRAWLING,HANGING
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for( Shrubbery s : Shrubbery.values()){
			System.out.println(s + " ordinal " + s.ordinal());
			System.out.println("compareTo(Shrubbery.CRAWLING) " + s.compareTo(Shrubbery.CRAWLING) + "");
			System.out.println("equals(Shrubbery.CRAWLING) " + s.equals(Shrubbery.CRAWLING));
			System.out.println("==(Shrubbery.CRAWLING) " + (s == Shrubbery.CRAWLING));
			System.out.println(s.getDeclaringClass());
			System.out.println(s.getClass());
			System.out.println(s.name());
			System.out.println(s.getDeclaringClass().equals(s.getClass()));
			System.out.println(s.getDeclaringClass() == s.getClass());
			System.out.println("----------------------------------------------");
		}
		
		for(String s : "GROUND,CRAWLING,HANGING".split(",")){
			Shrubbery shr = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shr);
			Shrubbery shr2 = Shrubbery.valueOf(s);
			System.out.println(shr2);
		}
	}

}
