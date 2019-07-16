package com.bruce.demo.basic;

class WithInner{
	class Inner{}
}

public class InheritInner extends WithInner.Inner{
	public InheritInner(WithInner wi){
		wi.super();
	}
}
