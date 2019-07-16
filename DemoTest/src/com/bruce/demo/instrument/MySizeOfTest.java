package com.bruce.demo.instrument;




	public class MySizeOfTest {
		public String test()
		{
			String s = null;
			
			for (int i = 0; i < 10000; i++){
				s = s + i;
			}
			
			return s;
		}
		public static void main(String []args) {
			  
		      System.out.println(new TransClass().getNumber());
		}
	}

