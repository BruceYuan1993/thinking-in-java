package com.bruce.demo.generics;

import java.util.Iterator;
import java.util.List;

interface UnaryFunction<T>{
	T apply(T arg);
}

public class UnaryFunctionTest {
	private static UnaryFunction<Object> iDENTITY_Function = new UnaryFunction<Object>() {

		@Override
		public Object apply(Object arg) {
			// TODO Auto-generated method stub
			return arg;
		}
	};
	
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction(){
		return (UnaryFunction<T>) iDENTITY_Function;
	}
	
	
	public static void main(String[] args) {
		String[] strings = {"jute", "hemp", "nylon"};
		UnaryFunction<String> sameString = identityFunction();
		for (String string : strings) {
			System.out.println(sameString.apply(string));
		}
		
		Number[] numbers ={1, 2.0, 3L};
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number number : numbers) {
			System.out.println(sameNumber.apply(number));
		}
		
		StackForEJ<Number> numberStack = new StackForEJ<Number>();
		
	}
	
	public static <T extends Comparable<? super T>> T max(List<? extends T> list){
		Iterator<? extends T> iterator = list.iterator();
		T result = iterator.next();
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
		
	}
}
