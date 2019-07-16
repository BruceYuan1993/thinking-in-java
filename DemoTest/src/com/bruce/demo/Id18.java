package com.bruce.demo;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Id18 {
	private static final int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
	private static final char[] validate={ '1','0','X','9','8','7','6','5','4','3','2'};
	
	public static char getValidateCode(String id17){
		int sum = 0;
		int mod = -1;
		int index = 0;
		for (char x : id17.toCharArray()) {
			sum += (Integer.parseInt(String.valueOf(x)) * weight[index++]);
		}
		mod = sum % 11;
		return validate[mod];
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Id18.getValidateCode("410726199107031229".substring(0, 17)));
		try {
			try {
				throw new Sneeze();
			} 
			catch ( Annoyance a ) {
				System.out.println("Caught Annoyance");
				throw a;
			}
		} 
		catch ( Sneeze s ) {
			System.out.println("Caught Sneeze");
			return ;
		}
		finally {
			System.out.println("Hello World!");
		}
//		String s1 = "Programming";
//		
//		String s2 = new String("Programming");
//		String s3 = "Program" + "ming";
//		final String s4 = "Program";
//		final String s5 = "ming";
//		final String s6 = s4 + s5;
//		
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s3);
//		System.out.println(s1 == s6);
//		s3.intern();
//		System.out.println(s1 == s3);


	}
}
