package com.bruce.demo.enumerated;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
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
	private static final Map<String, Operation> stringToEnum =
		new HashMap<String, Operation>();
	static{
		for (Operation op : values()) {
			stringToEnum.put(op.toString(), op);
		}
	}
	private Operation(String symbol) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		
	}
	abstract double apply(double x, double y);
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return symbol;
	}
	public static Operation fromString(String symbol){
		return stringToEnum.get(symbol);
	}
	public static Operation inverse(Operation op){
		switch(op){
			default :
			case PLUS: return Operation.MINUS;
			case MINUS: return Operation.PLUS;
			case TIMES: return Operation.DIVIDE;
			case DIVIDE: return Operation.TIMES;
		}
	}
	public static void main(String[] args) {
		Operation operation = Operation.PLUS;
		operation = Operation.fromString(operation.toString());
		System.out.println(inverse(operation));
	}
}
