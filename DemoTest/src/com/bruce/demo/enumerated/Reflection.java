package com.bruce.demo.enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.bruce.demo.util.OSExecute;


enum Explore{
	HERE,THERE
}
public class Reflection {
	public static List<String> analyze(Class<?> enumClass){
		System.out.println("------ Analyzing " + enumClass + " -------");
		System.out.println("Interfaces:");
		for(Type t : enumClass.getGenericInterfaces()){
			System.out.println(t);
		}
		System.out.println("Base:" + enumClass.getSuperclass());
		System.out.println("Method: ");
		List<String> methods = new ArrayList<String>();
		
		for(Method m : enumClass.getMethods()){
			methods.add(m.getName());
		}
		System.out.println(methods);
		return methods;
	}
	public static void main(String[] args) throws Exception{
		List<String> exploreMethods = analyze(Explore.class);
		List<String> enumMethods = analyze(Enum.class);
		System.out.println("Explore.containsAll(enum)?  "+ exploreMethods.containsAll(enumMethods));
		System.out.print("Explore.removeAll(enum)  ");
		exploreMethods.removeAll(enumMethods);
		System.out.println(exploreMethods);
		//Runtime.getRuntime().exec("javap Explore");
		OSExecute.command("javap Explore");
	}
}
