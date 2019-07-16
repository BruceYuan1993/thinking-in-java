package com.bruce.demo.annotations.pap;

import java.io.IOException;

import javax.annotation.PostConstruct;

public class Testing {
	
	private int aaa;
	@ToBeTested(group = "123")
	  public <T> void m1(T... args){ 
	  }
	  
	  @ToBeTested(group = "123")
	  public int m2(int a, int b, String op) throws IOException{ 
		  int result = 0;
		  if(op.equals("+")){
			  result = a + b;
		  }else {
			result = a - b;
		  }
		  return result;
	  }
	  
	  @PostConstruct
	  public void m3(){
		  
	  }
	  
	  public class InnerTest{
			
	  }
}


