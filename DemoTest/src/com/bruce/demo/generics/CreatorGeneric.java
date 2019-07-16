package com.bruce.demo.generics;

public class CreatorGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator c = new Creator();
		c.f();
	}
}
	abstract class GenericWithCreate<T>{
		final T x;
		abstract T create();
		public GenericWithCreate(){
			x = create();
		}
	}
	
	class X{}
	
	class Creator extends GenericWithCreate<X>{

		@Override
		X create() {
			// TODO Auto-generated method stub
			return new X();
		}
		
		void f(){
			System.out.println(x.getClass().getSimpleName());
		}
	}


