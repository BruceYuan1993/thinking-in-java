package com.bruce.demo.annotations.pap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE) 
@Target(ElementType.METHOD) 
public @interface ToBeTested{ 
  String owner() default "Chinajash"; 
  String group(); 
} 
