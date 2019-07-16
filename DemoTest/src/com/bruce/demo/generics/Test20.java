package com.bruce.demo.generics;
interface IA{
	void f1();
	void f2();
}

class AA implements IA{

	@Override
	public void f1() {
		// TODO Auto-generated method stub
		System.out.println("IA.f1()");
	}

	@Override
	public void f2() {
		// TODO Auto-generated method stub
		System.out.println("IA.f2()");
	}
	
	public void f3(){
		System.out.println("IA.f3()");
	}
	
}

public class Test20 {
	public <T extends IA> void test(T t){
		t.f1();
		t.f2();
		// T x = new T();
		
	}
	public static <T> void testCast(String s) {
		T x = (T)s;
		System.out.println(x.getClass());
		System.out.println(x);
		
//		if (x instanceof T){
//			
//		}
//		T y = new T();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test20().test(new AA());
		Test20.<Integer>testCast("2");
	}

}
