package com.bruce.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bruce.demo.enumerated.Operation;


@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface UseCase {
	public int id() default 0;
	public String description() default "no description";
//	public Class<?> type();
//	public Operation operation();
//	public ExceptionTest exceptionTest();
//	public Testable tt();
}
