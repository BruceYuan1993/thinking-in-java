package com.bruce.demo.generics;

class HasF{
	public void f()
	{
		System.out.println("HasF.f()");
	}
}

class FF extends HasF{
	
}

class Manioulator<T extends HasF>{
	private T obj;
	public Manioulator(T x){
		this.obj = x;
	}
	public void manipulate(){
		obj.f();
	}
	
	public T get()
	{
		return obj;
	}
}

class Manioulator3{
	private HasF obj;
	public Manioulator3(HasF x){
		this.obj = x;
	}
	public void manipulate(){
		obj.f();
	}
	public HasF get()
	{
		return obj;
	}
}
public class Manipulation {
	public static void main(String[] args) {
		Manioulator<FF> m1 = new Manioulator<FF>(new FF());
		FF f1 = m1.get();
		
		Manioulator3 m2 = new Manioulator3(new FF());
		FF f2 = (FF) m2.get();
		
		System.out.println(f2);
	}
}
