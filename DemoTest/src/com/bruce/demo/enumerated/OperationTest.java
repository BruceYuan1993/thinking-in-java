package com.bruce.demo.enumerated;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

interface IOperation{
	double apply(double x, double y);
}
enum BasicOperation implements IOperation{
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x + y;
		}
	},
	MINUS("-"){

		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x - y;
		}
		
	},
	TIMES("*"){

		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x * y;
		}
		
	},
	DIVIDE("/"){

		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x / y;
		}
		
	}
	;
	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.symbol;
	}
		
}

enum ExtendedOperation implements IOperation{
	EXP("^"){

		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return Math.pow(x, y);
		}
		
	},
	REMAINDER("%"){

		@Override
		public double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x % y;
		}
		
	}
	;

	private final String symbol;

	ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.symbol;
	}
	
}
public class OperationTest {
public static void main(String[] args) {
	test1(ExtendedOperation.class,4,2);
	test2(Arrays.asList(ExtendedOperation.values()),4,2);
}
private static <T extends Enum<T> & IOperation> void test1(Class<T> opSet, double x, double y){
	for (T op : opSet.getEnumConstants()) {
		System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
	}
}

private static void test2(Collection<? extends IOperation> opSet, double x, double y){
	for (IOperation op : opSet) {
		System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
	}
}
}
