package com.bruce.demo.typeinfo.nullobject;

import java.util.List;

public interface Robot {
	String name();
	String model();
	List<Operation> operations();
	class Test{
		public static void test(Robot r){
			if (r instanceof Null){
				System.out.println("[NULL ROBOT]");
			}
			System.out.println("Robot name: " + r.name());
			System.out.println("Robot mode: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		} 
	}
}
