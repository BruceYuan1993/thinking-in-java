package com.bruce.demo.innerclass;


 class Demo22 {
	private int i;
	public class InnerDemo{
		//private int i = 5;
		public void out()
		{
			System.out.println(i);	
		}
	}
	public static class NestedDemo{
		int i;
		private void sysout() {
			// TODO Auto-generated method stub
			//System.out.println(i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Demo demo = new Demo();
//		InnerDemo innerDemo = demo.new InnerDemo();
//		innerDemo.out();
	}

}
 class AA{}
 class BB{}
