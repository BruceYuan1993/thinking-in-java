package com.bruce.demo.annotations.asserttest;

public class AssertTest1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
		AssertTest1 test1 = new AssertTest1();
		try {
			//test1.assertTest(true);
			test1.assertTest(false);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("finally");
		}finally{
			
		}
		
	}
	private void assertTest(boolean flag) throws Exception
	{
		assert flag : "BruceTest";
		System.out.println("true condition");
	}
}
